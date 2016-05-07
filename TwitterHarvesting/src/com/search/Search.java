package com.search;

import java.util.List;

import com.beans.Tweets;
import com.utils.log.Log;

import twitter4j.TwitterException;

public abstract class Search {

    protected static final Log log = Log.getInstance();

    public abstract List<Tweets> search(int count, String sinceDate)
            throws TwitterException;

    public abstract List<Tweets> search(int count) throws TwitterException;

    public abstract List<Tweets> search(int count, String sinceDate,
            String endDate, String[] lang) throws TwitterException;
}
