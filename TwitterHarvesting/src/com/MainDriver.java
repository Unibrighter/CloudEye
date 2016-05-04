package com;

import com.utils.log.Log;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainDriver {

    private static final Log log = Log.getInstance();

    public static void main(String[] args) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        String message = "AAAA test request.";
        Status status = twitter.updateStatus(message);
        log.debug("Successfully updated status to " + status.getText());
    }

}
