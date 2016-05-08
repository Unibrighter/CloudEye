package com.search;

import java.util.List;

import com.beans.Tweet;
import com.resource.GeoResource;
import com.utils.log.Log;

import twitter4j.TwitterException;

public abstract class AbstractSearch {

    public static final int MAX_COUNT = Integer.MAX_VALUE;
    protected static final Log log = Log.getInstance();
    protected GeoResource geo;

    public AbstractSearch(GeoResource geo) {
        this.geo = geo;
    }

    public abstract List<Tweet> search(int count, String sinceDate)
            throws TwitterException;

    public abstract List<Tweet> search(int count) throws TwitterException;

    public abstract List<Tweet> search(int count, String sinceDate,
            String endDate, String[] lang) throws TwitterException;
}
