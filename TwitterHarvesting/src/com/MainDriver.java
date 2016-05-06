package com;

import java.util.List;

import com.config.Key;
import com.config.Tweets;
import com.search.Search;
import com.search.impl.StreamSearchImpl;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import com.utils.log.FileUtils;
import com.utils.log.Log;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

public class MainDriver {

    private static final Log log = Log.getInstance();
    private static final int COUNT = 2;

    public static void main(String[] args) throws TwitterException {
        // Post a status onto twitter.
        // Twitter twitter = TwitterFactory.getSingleton();
        // String message = "AAAA test request.";
        // Status status = twitter.updateStatus(message);
        // log.debug("Successfully updated status to " + status.getText());

        Search search = new StreamSearchImpl();
        List<Tweets> list = search.search(new String[] { "Nike" }, COUNT, null,
                null, Key.EAST, Key.EN);

        FileUtils.getInstance().writeTweets(list, FileUtils.TWEETS_PATH);

    }

}
