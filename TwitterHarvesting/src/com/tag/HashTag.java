package com.tag;

import java.util.HashMap;

public class HashTag {

    private static final HashMap<TopicTag, String[]> topicMap = new HashMap<>();
    private static final HashMap<String, SentimentTag> sentimentMap = new HashMap<>();

    static {
        topicMap.put(TopicTag.Sport, Key.EXERCISE);
        topicMap.put(TopicTag.Car, Key.CAR);
        topicMap.put(TopicTag.Transport, Key.TRANSPORT);
        topicMap.put(TopicTag.Religion, Key.RELIGION);
        topicMap.put(TopicTag.Restaurant, Key.CAFE);

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
