package com.search;

import com.utils.log.Log;

import twitter4j.StallWarning;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public abstract class BaseStatusListener implements StatusListener {

    private static final Log log = Log.getInstance();

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        log.info("Got a status deletion notice id:"
                + statusDeletionNotice.getStatusId());
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        log.info("Got track limitation notice:" + numberOfLimitedStatuses);
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
        log.info("Got scrub_geo event userId:" + userId + " upToStatusId:"
                + upToStatusId);
    }

    @Override
    public void onStallWarning(StallWarning warning) {
        log.info("Got stall warning:" + warning);
    }

    @Override
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
}
