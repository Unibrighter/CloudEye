package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.beans.GeoCircle;
import com.beans.Tweets;
import com.search.Search;
import com.tag.Resource;
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

public final class RestfulImpl extends Search {

    public static final int MAX_WINDOW_TIME = 15 * 60 * 1000;
    public static final int MAX_REQUEST_COUNT = 180;
    /* max count per search */
    public static final int MAX_PER_COUNT = 100;
    /* max count per page for 1 call */
    public static final int MAX_PAGE_COUNT = 200;

    private Twitter twitter = new TwitterFactory(UtilHelper.getConfig(true))
            .getInstance();
    private GeoCircle geo;
    private long userId;

    public RestfulImpl(long userId) {
        this.userId = userId;
    }

    public RestfulImpl(GeoCircle geo) {
        this.geo = geo;
    }

    @Override
    public List<Tweets> search(int count, String sinceDate)
            throws TwitterException {
        return search(count, sinceDate, null, Resource.EN);
    }

    @Override
    public List<Tweets> search(int count) throws TwitterException {
        return search(count, null, null, Resource.EN);
    }

    @Override
    public List<Tweets> search(int count, String sinceDate, String endDate,
            String[] lang) throws TwitterException {
        List<Tweets> tweets = new ArrayList<>();
        count = Math.min(count, MAX_PER_COUNT);
        Query query = new Query();
        query.setSince(sinceDate);
        query.setUntil(endDate);
        query.setLang(lang[0]);
        query.setCount(count);
        query.setGeoCode(new GeoLocation(geo.getLatitude(), geo.getLongitude()),
                geo.getRadius(), Unit.km);

        QueryResult result = null;
        do {
            result = twitter.search(query);
            List<Status> list = result.getTweets();
            for (Status status : list) {
                tweets.add(UtilHelper.convertStatus(status));
            }
        }
        while ((query = result.nextQuery()) != null);
        return tweets;
    }

    public List<Tweets> getTimeLineOnePage(int count) throws TwitterException {
        return getUserTimeLine(1, count);
    }

    public List<Tweets> getUserTimeLine(int page, int count)
            throws TwitterException {
        count = Math.min(count, MAX_PAGE_COUNT);
        List<Tweets> tweets = new ArrayList<>();
        List<Status> list = twitter.getUserTimeline(userId,
                new Paging(page, count));
        for (Status status : list) {
            tweets.add(UtilHelper.convertStatus(status));
        }
        return tweets;
    }
}
