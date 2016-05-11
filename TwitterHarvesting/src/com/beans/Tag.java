package com.beans;

import com.preprocess.TopicClassifier;
import com.tag.AreaTag;

import twitter4j.GeoLocation;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class Tag {

    private long id;
    private String content;
    private String originalContext;
    private String date;
    private GeoLocation geo;
    private String location;
    private int sentiment = 0;
    private AreaTag area = AreaTag.melbourne;

    private boolean crime;
    private boolean politic;
    private boolean fitness;
    private boolean tv;
    private boolean asianFood;
    private boolean ozFood;
    private boolean chineseFood;
    private boolean italianFood;
    private boolean frenchFood;
    private boolean immigration;
    private boolean trump;

    public long getId() {
        return id;
    }

    public Tag setId(long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Tag setContent(String content) {
        this.content = content;
        return this;
    }

    public String getOriginalContext() {
        return originalContext;
    }

    public Tag setOriginalContext(String originalContext) {
        this.originalContext = originalContext;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Tag setDate(String date) {
        this.date = date;
        return this;
    }

    public GeoLocation getGeo() {
        return geo == null ? new GeoLocation(0, 0) : geo;
    }

    public Tag setGeo(GeoLocation geo) {
        this.geo = geo;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Tag setLocation(String location) {
        this.location = location;
        return this;
    }

    public int getSentiment() {
        return sentiment;
    }

    public Tag setSentiment(int sentiment) {
        this.sentiment = sentiment;
        return this;
    }

    public AreaTag getArea() {
        return area;
    }

    public Tag setArea(AreaTag area) {
        this.area = area;
        return this;
    }

    public boolean isCrime() {
        return crime;
    }

    public Tag setCrime(boolean crime) {
        this.crime = crime;
        return this;
    }

    public boolean isPolitic() {
        return politic;
    }

    public Tag setPolitic(boolean politic) {
        this.politic = politic;
        return this;
    }

    public boolean isFitness() {
        return fitness;
    }

    public Tag setFitness(boolean fitness) {
        this.fitness = fitness;
        return this;
    }

    public boolean isTv() {
        return tv;
    }

    public Tag setTv(boolean tv) {
        this.tv = tv;
        return this;
    }

    public boolean isAsianFood() {
        return asianFood;
    }

    public Tag setAsianFood(boolean asianFood) {
        this.asianFood = asianFood;
        return this;
    }

    public boolean isOzFood() {
        return ozFood;
    }

    public Tag setOzFood(boolean ozFood) {
        this.ozFood = ozFood;
        return this;
    }

    public boolean isChineseFood() {
        return chineseFood;
    }

    public Tag setChineseFood(boolean chineseFood) {
        this.chineseFood = chineseFood;
        return this;
    }

    public boolean isItalianFood() {
        return italianFood;
    }

    public Tag setItalianFood(boolean italianFood) {
        this.italianFood = italianFood;
        return this;
    }

    public boolean isFrenchFood() {
        return frenchFood;
    }

    public Tag setFrenchFood(boolean frenchFood) {
        this.frenchFood = frenchFood;
        return this;
    }

    public boolean isImmigration() {
        return immigration;
    }

    public Tag setImmigration(boolean immigration) {
        this.immigration = immigration;
        return this;
    }

    public boolean isTrump() {
        return trump;
    }

    public Tag setTrump(boolean trump) {
        this.trump = trump;
        return this;
    }

    /**
     * Classify each tweet belong to which topic.
     * 
     * @return
     */
    public final Tag classifyTopic() {
        return new TopicClassifier(this).classify();
    }
}
