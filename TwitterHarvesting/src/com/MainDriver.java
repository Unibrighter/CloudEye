package com;

import com.search.Search;
import com.search.impl.StreamingImpl;
import com.tag.Resource;
import com.utils.log.Log;

import twitter4j.TwitterException;

public class MainDriver {

    private static final Log log = Log.getInstance();

    public static void main(String[] args) throws TwitterException {
        search();
    }

    public static void search() throws TwitterException {
        Search search = new StreamingImpl(Resource.INNER);
        search.search(StreamingImpl.MAX_COUNT);
        log.info("finish");
    }

}
