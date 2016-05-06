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

    public void setDevice(String device) {
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = UtilHelper.dateFormat(date);
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public GeoLocation getGeo() {
        return geo;
    }

    public void setGeo(GeoLocation geo) {
        this.geo = geo;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, id, content, date, lang,
                UtilHelper.toString(place), UtilHelper.toString(geo), userID);
    }
}
