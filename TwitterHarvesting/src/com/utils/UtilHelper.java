package com.utils;

import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beans.JsonTweet;
import com.beans.Tweet;
import com.google.gson.JsonObject;
import com.preprocess.Preprocessing;

import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class UtilHelper {

    public static String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);

    }

    public static List<JsonObject> commitSingle(Status status) {
        List<JsonObject> jsons = new ArrayList<>();
        jsons.add(JsonTweet.build(convertStatus(status).preprocessing()));
        return jsons;
    }

    public static List<JsonObject> commitTag(List<Tweet> list) {
        List<JsonObject> jsons = new ArrayList<>();
        for (Tweet tw : list) {
            jsons.add(JsonTweet.build(tw.preprocessing()));
        }
        return jsons;
    }

    public static String getExactPattern(final String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                sb.append(words[i]);
            }
            else {
                sb.append(words[i] + "|");
            }
        }
        return String.format(Preprocessing.EXACT_PATTERN, sb.toString());
    }

    public static String toString(Object o) {
        if (o != null) {
            return o.toString();
        }
        return "";
    }

    /**
     * 
     * @param s
     * @return true: empty; false: not
     */
    public static boolean isEmptyStr(String s) {
        if (s != null && s.length() != 0) {
            return false;
        }
        return true;
    }

    public static Tweet convertStatus(Status status) {
        if (status == null) {
            return null;
        }
        return new Tweet().setId(status.getId()).setContent(status.getText())
                .setDate(status.getCreatedAt()).setDevice(status.getSource())
                .setGeo(status.getGeoLocation())
                .setUserID(status.getUser().getId()).setLang(status.getLang())
                .setPlace(status.getPlace())
                .setJson(TwitterObjectFactory.getRawJSON(status))
                .setLocation(status.getUser().getLocation());
    }

    public static String forJSON(String aText) {
        final StringBuilder result = new StringBuilder();
        StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != StringCharacterIterator.DONE) {
            if (character == '\"') {
                result.append("\\\"");
            }
            else if (character == '\\') {
                result.append("\\\\");
            }
            else if (character == '/') {
                result.append("\\/");
            }
            else if (character == '\b') {
                result.append("\\b");
            }
            else if (character == '\f') {
                result.append("\\f");
            }
            else if (character == '\n') {
                result.append("\\n");
            }
            else if (character == '\r') {
                result.append("\\r");
            }
            else if (character == '\t') {
                result.append("\\t");
            }
            else {
                // the char is not a special one
                // add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

}
