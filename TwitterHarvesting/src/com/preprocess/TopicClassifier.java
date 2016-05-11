package com.preprocess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beans.Tag;
import com.oath.OAthConfig;
import com.sentiment.SentimentClassifier;
import com.tag.AreaTag;
import com.tag.HashTag;
import com.tag.TopicTag;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class TopicClassifier {

    private Tag tagTweet;

    public TopicClassifier(Tag tagTweet) {
        this.tagTweet = tagTweet;
    }

    public final Tag getTagTweet() {
        return tagTweet;
    }

    /**
     * Sentiment Tag, Area Tag, Topic Tags.
     * 
     * @return
     */
    public Tag classify() {
        switch (OAthConfig.getGeoType()) {
            case Inner_Cir:
            case Inner_Rct:
                return classify(AreaTag.inner);
            case East_Cir:
            case East_Rct:
                return classify(AreaTag.east);
            case West_Cir:
            case West_Rct:
                return classify(AreaTag.west);
            case North_Cir:
            case North_Rct:
                return classify(AreaTag.north);
        }
        return classify(AreaTag.melbourne);
    }

    public Tag classify(AreaTag areaTag) {
        // Sentiment tag
        switch (SentimentClassifier.getInstance()
                .classify(tagTweet.getContent())) {
            case pos:
                tagTweet.setSentiment(1);
                break;
            case neg:
                tagTweet.setSentiment(-1);
                break;
            case neu:
                tagTweet.setSentiment(0);
                break;
        }
        // Area tag
        tagTweet.setArea(areaTag);

        // Topic tag
        return match(TopicTag.crime).match(TopicTag.politic)
                .match(TopicTag.fitness).match(TopicTag.tvshow)
                .match(TopicTag.asianfood).match(TopicTag.ozfood)
                .match(TopicTag.chinesefood).match(TopicTag.italianfood)
                .match(TopicTag.frenchfood).match(TopicTag.immigration)
                .match(TopicTag.trump).getTagTweet();
    }

    public TopicClassifier match(TopicTag tag) {
        Pattern pattern = Pattern.compile(HashTag.getTopicPattern(tag),
                Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(tagTweet.getContent());
        while (match.find()) {
            switch (tag) {
                case crime:
                    tagTweet.setCrime(true);
                    return this;
                case politic:
                    tagTweet.setPolitic(true);
                    return this;
                case fitness:
                    tagTweet.setFitness(true);
                    return this;
                case tvshow:
                    tagTweet.setTv(true);
                    return this;
                case asianfood:
                    tagTweet.setAsianFood(true);
                    return this;
                case ozfood:
                    tagTweet.setOzFood(true);
                    return this;
                case chinesefood:
                    tagTweet.setChineseFood(true);
                    return this;
                case italianfood:
                    tagTweet.setItalianFood(true);
                    return this;
                case frenchfood:
                    tagTweet.setFrenchFood(true);
                    return this;
                case immigration:
                    tagTweet.setImmigration(true);
                    return this;
                case trump:
                    tagTweet.setTrump(true);
                    return this;
            }
        }
        return this;
    }
}
