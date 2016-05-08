package com.tag;

import java.util.HashMap;

import com.resource.Resource;

public class HashTag {

    private static final HashMap<TopicTag, String[]> topicMap = new HashMap<>();
    private static final HashMap<String, SentimentTag> sentimentMap = new HashMap<>();

    static {
        topicMap.put(TopicTag.Sport, Resource.EXERCISE);
        topicMap.put(TopicTag.Car, Resource.CAR);
        topicMap.put(TopicTag.Transport, Resource.TRANSPORT);
        topicMap.put(TopicTag.Religion, Resource.RELIGION);
        topicMap.put(TopicTag.Restaurant, Resource.CAFE);

        sentimentMap.put(SentimentTag.neg.name(), SentimentTag.neg);
        sentimentMap.put(SentimentTag.neu.name(), SentimentTag.neu);
        sentimentMap.put(SentimentTag.pos.name(), SentimentTag.pos);
    }

    public static String[] getTopic(TopicTag tag) {
        return topicMap.get(tag);
    }

    public static SentimentTag getSentimentTag(String tag) {
        return sentimentMap.get(tag);
    }
}
