package com.search.impl;

import java.util.ArrayList;
import java.util.List;

import com.beans.Tweets;
import com.search.BaseStatusListener;
import com.search.Search;
import com.tag.HashTag;
import com.tag.Key;
import com.tag.TopicTag;
import com.utils.UtilHelper;
import com.utils.log.Log;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public final class StreamSearchImpl implements Search {

    private static final Log log = Log.getInstance();

    private TopicTag topic;
    private double[][] area;

    public StreamSearchImpl(TopicTag topic, double[][] area) {
        this.topic = topic;
        this.area = area;
    }

    public List<Tweets> search(int count, String sinceDate) {
        return this.search(count, sinceDate, null, Key.EN);
    }

    public List<Tweets> search(int count) {
        return this.search(count, null, null, Key.EN);
    }

    @Override
    public List<Tweets> search(int count, String sinceDate, String endDate,
            String[] lang) {
        final TwitterStream twitterStream = new TwitterStreamFactory(
                UtilHelper.getConfig(true)).getInstance();
        final List<Tweets> infos = new ArrayList<Tweets>();
        final int all = (count == -1 ? 1000 : count);
        twitterStream.addListener(new BaseStatusListener() {

            @Override
            public void onStatus(Status status) {

                infos.add(UtilHelper.convertStatus(status));

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
        query.track(HashTag.getTopic(topic));
        query.locations(area);
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
