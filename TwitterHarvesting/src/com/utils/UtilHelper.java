package com.utils;

import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.config.Tweets;

import twitter4j.Status;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class UtilHelper {

    private static final String consumerSecret = "IkoXSddjZHDuzdpgToiRPbi4di12iTptRevHwDLGDdjkKmoXJZ";
    private static final String consumerKey = "OljCaeSTjxIYxPW01xG1eDuEv";
    private static final String accessToken = "4035327626-POQsYQEyFccE7ptVoGG5eX36h3ftGcJrC0TfvB3";
    private static final String accessTokenSecret = "pnyiNTsGGQJbfI5Xjj6WUaFEhGGBicosRQFNkfqERnHBR";

    public static Configuration getConfig(boolean isJSONStoreEnabled) {
        return new ConfigurationBuilder().setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)
                .setJSONStoreEnabled(isJSONStoreEnabled).build();
    }

    public static String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);

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

    public static Tweets convertStatus(Status status) {
        if (status == null) {
            return null;
        }
        return new Tweets().setId(status.getId()).setContent(status.getText())
                .setDate(status.getCreatedAt()).setDevice(status.getSource())
                .setGeo(status.getGeoLocation())
                .setUserID(status.getUser().getId()).setLang(status.getLang())
                .setPlace(status.getPlace())
                .setJson(TwitterObjectFactory.getRawJSON(status));
    }

    /**
     * Remove url from the string using regular expression
     * 
     * @param text
     * @return URL free text
     */
    public static String removeUrl(String text) {
        String url = "((https?|ftp|telnet|file|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(url, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        int i = 0;
        while (match.find()) {
            text = text.replaceAll(match.group(i), "").trim();
            i++;
        }

        return removeHTMLChar(text);
    }

    /**
     * Public tweets contains certain reserve character of HTML such as &amp,
     * &quote This method cleans such HTMl reserve characters from the text
     * using Regular Expression.
     * 
     * @param text
     * @return
     */
    private static String removeHTMLChar(String text) {

        return text.replaceAll("&amp;", "&").replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'").replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">");
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
