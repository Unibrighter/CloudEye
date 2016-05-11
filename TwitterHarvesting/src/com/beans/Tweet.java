package com.beans;

import java.util.Date;

import com.preprocess.Preprocessing;
import com.utils.UtilHelper;

import twitter4j.GeoLocation;
import twitter4j.Place;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public final class Tweet {

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

    public String getLocation() {
        return location;
    }

    public Tweet setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public Tweet setDevice(String device) {
        this.device = device;
        return this;
    }

    public long getId() {
        return id;
    }

    public Tweet setId(long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Tweet setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Tweet setDate(Date date) {
        this.date = UtilHelper.dateFormat(date);
        return this;
    }

    public String getLang() {
        return lang;
    }

    public Tweet setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public Place getPlace() {
        return place;
    }

    public Tweet setPlace(Place place) {
        this.place = place;
        return this;
    }

    public GeoLocation getGeo() {
        return geo;
    }

    public Tweet setGeo(GeoLocation geo) {
        this.geo = geo;
        return this;
    }

    public long getUserID() {
        return userID;
    }

    public Tweet setUserID(long userID) {
        this.userID = userID;
        return this;
    }

    public String getJson() {
        return json;
    }

    public Tweet setJson(String json) {
        this.json = json;
        return this;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, location, UtilHelper.toString(geo),
                UtilHelper.toString(place), id, content, date, lang, userID);
    }

    public Tag preprocessing() {
        // convert from a tweet to a tagged tweet.
        return new Tag().setId(getId())
                .setContent(Preprocessing.process(getContent()))
                .setOriginalContext(getContent()).setDate(getDate())
                .setGeo(getGeo()).setLocation(getLocation()).classifyTopic();
    }
}
