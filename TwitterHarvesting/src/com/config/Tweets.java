package com.config;

import java.util.Date;

import com.utils.UtilHelper;

import twitter4j.GeoLocation;
import twitter4j.Place;

public class Tweets {

    private static final String FORMAT_OUTPUT = "id: %d, text: %s, date: %s, lang: %s, place: %s, geo: %s, userid: %d";

    private long id;
    private String content;
    private String date;
    private String device;
    private String lang;
    private Place place;
    private GeoLocation geo;
    private long userID;
    private String json;

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
        return String.format(FORMAT_OUTPUT, id, content, date, lang,
                UtilHelper.toString(place), UtilHelper.toString(geo), userID);
    }
}
