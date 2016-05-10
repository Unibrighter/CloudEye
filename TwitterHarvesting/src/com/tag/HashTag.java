package com.tag;

import java.util.HashMap;

import com.resource.Resource;
import com.utils.UtilHelper;

public class HashTag {

    private static final HashMap<TopicTag, String> topicMap = new HashMap<>();
    private static final HashMap<String, SentimentTag> sentimentMap = new HashMap<>();

    static {
        topicMap.put(TopicTag.asianfood,
                UtilHelper.getExactPattern(Resource.asianfood));
        topicMap.put(TopicTag.chinesefood,
                UtilHelper.getExactPattern(Resource.chinesefood));
        topicMap.put(TopicTag.crime,
                UtilHelper.getExactPattern(Resource.crime));
        topicMap.put(TopicTag.fitness,
                UtilHelper.getExactPattern(Resource.fitness));
        topicMap.put(TopicTag.frenchfood,
                UtilHelper.getExactPattern(Resource.frenchfood));
        topicMap.put(TopicTag.immigration,
                UtilHelper.getExactPattern(Resource.immigration));
        topicMap.put(TopicTag.italianfood,
                UtilHelper.getExactPattern(Resource.italianfood));
        topicMap.put(TopicTag.ozfood,
                UtilHelper.getExactPattern(Resource.ozfood));
        topicMap.put(TopicTag.politic,
                UtilHelper.getExactPattern(Resource.politic));
        topicMap.put(TopicTag.trump,
                UtilHelper.getExactPattern(Resource.trump));
        topicMap.put(TopicTag.tvshow,
                UtilHelper.getExactPattern(Resource.tvshow));

        sentimentMap.put(SentimentTag.neg.name(), SentimentTag.neg);
        sentimentMap.put(SentimentTag.neu.name(), SentimentTag.neu);
        sentimentMap.put(SentimentTag.pos.name(), SentimentTag.pos);
    }

    public static String getTopicPattern(TopicTag tag) {
        return topicMap.get(tag);
    }

    public static SentimentTag getSentimentTag(String tag) {
        return sentimentMap.get(tag);
    }
}
