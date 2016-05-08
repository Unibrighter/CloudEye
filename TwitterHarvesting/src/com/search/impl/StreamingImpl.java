package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.beans.Tweet;
import com.file.FileUtils;
import com.oath.OAthConfig;
import com.resource.GeoResource;
import com.resource.Resource;
import com.search.AbstractSearch;
import com.search.BaseStatusListener;
import com.utils.UtilHelper;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public final class StreamingImpl extends AbstractSearch {

    private static final int MAX_FILE_SIZE = 10;
    private volatile int allSize = 0;

    public StreamingImpl(GeoResource geo) {
        super(geo);
    }

    public List<Tweet> search(int count, String sinceDate) {
        return this.search(count, sinceDate, null, Resource.EN);
    }

    public List<Tweet> search(int count) {
        return this.search(count, null, null, Resource.EN);
    }

    @Override
    public List<Tweet> search(int count, String sinceDate, String endDate,
            String[] lang) {
        final TwitterStream twitterStream = new TwitterStreamFactory(
                OAthConfig.getConfig(true)).getInstance();
        final List<Tweet> infos = new ArrayList<Tweet>();
        final int cacheSize = Math.min(count, MAX_FILE_SIZE);
        final int maxSize = Math.min(count, MAX_COUNT);
        twitterStream.addListener(new BaseStatusListener() {

            @Override
            public void onStatus(Status status) {
                infos.add(UtilHelper.convertStatus(status));
                if (infos.size() == cacheSize) {
                    //TODO pre-processing
                    FileUtils.getInstance().writeTweets(infos,
                            FileUtils.FILE_TWEETS_PATH);
                    allSize += infos.size();
                    log.info("get tweets size: " + allSize);
                    infos.clear();
                }

                if (allSize >= maxSize) {
                    twitterStream.shutdown();
                    synchronized (infos) {
                        infos.notify();
                    }
                }
            }
        });
        FilterQuery query = new FilterQuery();
        query.locations(geo.getArea());
        query.language(lang);
        twitterStream.filter(query);
        synchronized (infos) {
            try {
                infos.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }
}
