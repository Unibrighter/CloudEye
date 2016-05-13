package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.beans.Tweet;
import com.oath.OAthConfig;
import com.resource.GeoResource;
import com.resource.Resource;
import com.search.AbstractSearch;
import com.search.BaseStatusListener;
import com.tasks.CouchDBTask;
import com.utils.UtilHelper;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public final class StreamingImpl extends AbstractSearch {

    private static final int MAX_FILE_SIZE = 10;
    private volatile int allSize = 0;
    private CouchDBTask dbTask = new CouchDBTask();

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
        final List<Tweet> cacheStatus = new ArrayList<Tweet>();
        final int cacheSize = Math.min(count, MAX_FILE_SIZE);
        final int maxSize = Math.min(count, MAX_COUNT);
        twitterStream.addListener(new BaseStatusListener() {

            @Override
            public void onStatus(Status status) {
                // New plan is to make it as a real-time display.
                dbTask.insert(UtilHelper.commitSingle(status));
                log.info("has got tweet size: " + (++allSize) + " content: "
                        + status.getText());

                // Old plan is to cache a number of statuses and put them into
                // db once.
                // cacheStatus.add(UtilHelper.convertStatus(status));
                // if (cacheStatus.size() == cacheSize) {
                // dbTask.insert(UtilHelper.commitTag(cacheStatus));
                // allSize += cacheStatus.size();
                // log.info("get tweets size: " + allSize);
                // cacheStatus.clear();
                // }

                if (allSize >= maxSize) {
                    twitterStream.shutdown();
                    synchronized (cacheStatus) {
                        cacheStatus.notify();
                    }
                }
            }
        });
        FilterQuery query = new FilterQuery();
        query.locations(geo.getArea());
        query.language(lang);
        twitterStream.filter(query);
        synchronized (cacheStatus) {
            try {
                cacheStatus.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cacheStatus;
    }
}
