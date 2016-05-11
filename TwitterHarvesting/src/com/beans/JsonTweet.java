package com.beans;

import com.google.gson.JsonObject;

public class JsonTweet {

    public static final String ID = "_id";
    public static final String CONTENT = "content";
    public static final String AREA = "region_code";
    public static final String SENTIMENT = "sentiment";
    public static final String LATITUDE = "latitude";
    public static final String LOCATION = "location";
    public static final String LONGITUDE = "longitude";
    public static final String DATE = "date";

    public static final String CRIME = "crime";
    public static final String POLITIC = "politic";
    public static final String FITNESS = "fitness";
    public static final String TV = "tv_show";
    public static final String ASIAN_FOOD = "asian_food";
    public static final String OZ_FOOD = "oz_food";
    public static final String CHINESE_FOOD = "chinese_food";
    public static final String ITALIAN_FOOD = "italian_food";
    public static final String FRENCH_FOOD = "french_food";
    public static final String IMMI = "immigration";
    public static final String TRUMP = "trump_mentioned";

    public static JsonObject build(Tag taged) {
        if (taged == null) {
            return null;
        }
        JsonObject tweetJson = new JsonObject();
        tweetJson.addProperty(ID, String.valueOf(taged.getId()));
        tweetJson.addProperty(CONTENT, taged.getOriginalContext());
        tweetJson.addProperty(SENTIMENT, taged.getSentiment());
        tweetJson.addProperty(LOCATION, taged.getLocation());
        tweetJson.addProperty(AREA, taged.getArea().name());
        tweetJson.addProperty(LATITUDE, taged.getGeo().getLatitude());
        tweetJson.addProperty(LONGITUDE, taged.getGeo().getLongitude());
        tweetJson.addProperty(DATE, taged.getDate());
        tweetJson.addProperty(CRIME, taged.isCrime());
        tweetJson.addProperty(POLITIC, taged.isPolitic());
        tweetJson.addProperty(FITNESS, taged.isFitness());
        tweetJson.addProperty(TV, taged.isTv());
        tweetJson.addProperty(ASIAN_FOOD, taged.isAsianFood());
        tweetJson.addProperty(OZ_FOOD, taged.isOzFood());
        tweetJson.addProperty(CHINESE_FOOD, taged.isChineseFood());
        tweetJson.addProperty(ITALIAN_FOOD, taged.isItalianFood());
        tweetJson.addProperty(FRENCH_FOOD, taged.isFrenchFood());
        tweetJson.addProperty(IMMI, taged.isImmigration());
        tweetJson.addProperty(TRUMP, taged.isTrump());
        return tweetJson;
    }
}
