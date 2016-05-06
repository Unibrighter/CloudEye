package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.config.Key;
import com.config.Tweets;
import com.search.BaseStatusListener;
import com.search.Search;
import com.utils.UtilHelper;
import com.utils.log.Log;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public final class StreamSearchImpl implements Search {

    private static final Log log = Log.getInstance();

    public List<Tweets> search(String[] key) {
        return this.search(key, -1, null, null, null, Key.EN);
    }

    public List<Tweets> search(String[] key, int count, String sinceDate) {
        return this.search(key, count, sinceDate, null, null, Key.EN);
    }

    public List<Tweets> search(String[] key, int count) {
        return this.search(key, count, null, null, null, Key.EN);
    }

    @Override
    public List<Tweets> search(final String[] key, int count, String sinceDate,
            String endDate, double[][] locations, String[] lang) {
        final TwitterStream twitterStream = new TwitterStreamFactory(
                UtilHelper.getConfig(true)).getInstance();
        final List<Tweets> infos = new ArrayList<Tweets>();
        final int all = (count == -1 ? 1000 : count);
        twitterStream.addListener(new BaseStatusListener() {

            @Override
            public void onStatus(Status status) {
                Tweets info = new Tweets();
                info.setId(status.getId());
                info.setContent(status.getText());
                info.setDate(status.getCreatedAt());
                info.setDevice(status.getSource());
                info.setGeo(status.getGeoLocation());
                info.setUserID(status.getUser().getId());
                info.setLang(status.getLang());
                info.setPlace(status.getPlace());
                info.setJson(TwitterObjectFactory.getRawJSON(status));

                infos.add(info);

                if (infos.size() >= all) {
                    twitterStream.shutdown();
                    synchronized (infos) {
                        infos.notify();
                    }
                }
            }
        });
        FilterQuery query = new FilterQuery();
        query.count(0);
        query.track(key);
        query.locations(locations);
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
