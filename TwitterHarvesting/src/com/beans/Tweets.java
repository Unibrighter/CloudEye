package com.beans;

import java.util.Date;

import com.tag.AreaTag;
import com.tag.SentimentTag;
import com.tag.TopicTag;
import com.utils.UtilHelper;

import twitter4j.GeoLocation;
import twitter4j.Place;

public final class Tweets {

    private static final String FORMAT_OUTPUT = "{location: %s} {geo: %s} {place: %s} {id: %d} {text: %s} "
            + "{date: %s} {lang: %s} {userid: %d}";

    private long id;
    private String content;
    private String date;
    private String device;
    private String lang;
    private String location;
    private Place place;
    private GeoLocation geo;
    private long userID;
    private String json;
    private TopicTag topic;
    private SentimentTag sentiment;
    private AreaTag area;

    public AreaTag getArea() {
        return area;
    }

    public Tweets setArea(AreaTag area) {
        this.area = area;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Tweets setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public Tweets setDevice(String device) {
        this.device = device;
        return this;
    }

    public long getId() {
        return id;
    }

    public Tweets setId(long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Tweets setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Tweets setDate(Date date) {
        this.date = UtilHelper.dateFormat(date);
        return this;
    }

    public String getLang() {
        return lang;
    }

    public Tweets setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public Place getPlace() {
        return place;
    }

    public Tweets setPlace(Place place) {
        this.place = place;
        return this;
    }

    public GeoLocation getGeo() {
        return geo;
    }

    public Tweets setGeo(GeoLocation geo) {
        this.geo = geo;
        return this;
    }

    public long getUserID() {
        return userID;
    }

    public Tweets setUserID(long userID) {
        this.userID = userID;
        return this;
    }

    public String getJson() {
        return json;
    }

    public Tweets setJson(String json) {
        this.json = json;
        return this;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, location, UtilHelper.toString(geo),
                UtilHelper.toString(place), id, content, date, lang, userID);
    }

    public TopicTag getTopic() {
        return topic;
    }

    public void setTopic(TopicTag topic) {
        this.topic = topic;
    }

    public SentimentTag getSentiment() {
        return sentiment;
    }

    public void setSentiment(SentimentTag sentiment) {
        this.sentiment = sentiment;
    }
}
