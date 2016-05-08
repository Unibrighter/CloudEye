package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.beans.Tweet;
import com.oath.OAthConfig;
import com.resource.GeoResource;
import com.resource.Resource;
import com.search.AbstractSearch;
import com.tasks.RateWindowTimer;
import com.utils.UtilHelper;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.Query.Unit;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public final class RestRequestImpl extends AbstractSearch {

    public static final long MAX_WINDOW_TIME = 16 * 60 * 1000;
    public static final int MAX_REQUEST_COUNT = 180;
    /* max count per search */
    public static final int MAX_PER_SEARCH_COUNT = 100;
    /* max count per page for 1 call */
    public static final int MAX_PER_PAGE_COUNT = 200;

    private Twitter twitter = new TwitterFactory(OAthConfig.getConfig(true))
            .getInstance();
    private long userId;

    public RestRequestImpl(long userId) {
        this(userId, null);
    }

    public RestRequestImpl(GeoResource geo) {
        this(0, geo);
    }

    public RestRequestImpl(long userId, GeoResource geo) {
        super(geo);
        this.userId = userId;
    }

    @Override
    public List<Tweet> search(int count, String sinceDate)
            throws TwitterException {
        return search(count, sinceDate, null, Resource.EN);
    }

    @Override
    public List<Tweet> search(int count) throws TwitterException {
        return search(count, null, null, Resource.EN);
    }

    @Override
    public List<Tweet> search(int count, String sinceDate, String endDate,
            String[] lang) throws TwitterException {
        List<Tweet> tweets = new ArrayList<>();
        count = Math.min(count, MAX_PER_SEARCH_COUNT);
        Query query = new Query();
        query.setSince(sinceDate);
        query.setUntil(endDate);
        query.setLang(lang[0]);
        query.setCount(count);
        query.setGeoCode(
                new GeoLocation(geo.getCircle().getLatitude(),
                        geo.getCircle().getLongitude()),
                geo.getCircle().getRadius(), Unit.mi);

        QueryResult result = null;
        do {
            lockRequest();
            result = twitter.search(query);
            List<Status> list = result.getTweets();
            for (Status status : list) {
                tweets.add(UtilHelper.convertStatus(status));
            }
        }
        while ((query = result.nextQuery()) != null);
        return tweets;
    }

    public List<Tweet> getTimeLineOnePage(int count) throws TwitterException {
        return getUserTimeLine(1, count);
    }

    public List<Tweet> getUserTimeLine(int page, int count)
            throws TwitterException {
        lockRequest();
        count = Math.min(count, MAX_PER_PAGE_COUNT);
        List<Tweet> tweets = new ArrayList<>();
        List<Status> list = twitter.getUserTimeline(userId,
                new Paging(page, count));
        for (Status status : list) {
            tweets.add(UtilHelper.convertStatus(status));
        }
        return tweets;
    }

    private void lockRequest() {
        try {
            RateWindowTimer.getInstance().request();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
