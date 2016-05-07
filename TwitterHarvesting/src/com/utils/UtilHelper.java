package com.utils;

import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Date;

import com.beans.Tweets;

import twitter4j.Status;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class UtilHelper {
    /* Harvesting 1 */
    private static final String consumerSecret = "IkoXSddjZHDuzdpgToiRPbi4di12iTptRevHwDLGDdjkKmoXJZ";
    private static final String consumerKey = "OljCaeSTjxIYxPW01xG1eDuEv";
    private static final String accessToken = "4035327626-POQsYQEyFccE7ptVoGG5eX36h3ftGcJrC0TfvB3";
    private static final String accessTokenSecret = "pnyiNTsGGQJbfI5Xjj6WUaFEhGGBicosRQFNkfqERnHBR";
    
    /* Harvesting 2 */
//    private static final String consumerSecret = "BPHNDOj7kOlHa1izVNkJ1oHgyvqNJurR9AgoPpCW5PvqHtwOt2";
//    private static final String consumerKey = "wLndHBmWyRxLjoErlDNlDDUkX";
//    private static final String accessToken = "728261638839664640-Qm46bPkAsbJmJGDPxePoiqrlTQdickx";
//    private static final String accessTokenSecret = "0MMrlJNaGUNByLudidcy7ELv00SQU1Uu0hXig5GOS76wx";
    /* Harvesting 3 */
//    private static final String consumerSecret = "Zjk5urEuvMT4ipj7wD1OkKvpcCrTnfdYqvIEOOOW7IvVg4mfvY";
//    private static final String consumerKey = "gegAKPdB0VqC0cg5kTWd6s8Qg";
//    private static final String accessToken = "321842685-v2fLN3tyP7AQUr3AzGwGYiDGHbm1xcRuEoEyGEos";
//    private static final String accessTokenSecret = "vpMWX4KPpt8ulPet0lcAsugKibMbgAR5FkTPx4MmOGKK4";
    /* Harvesting 4 */
//    private static final String consumerSecret = "DPi2ixuchm4qYoy0NL02IY0qRs13Drgzy0G41KShsioYeOaOZM";
//    private static final String consumerKey = "GAPDFACAdNSRTkJiCwcLn59kR";
//    private static final String accessToken = "728264517315002368-PZDXJOmE2wXVjWVHCPxS9UUWdmxUlTI";
//    private static final String accessTokenSecret = "VSKthKSYbqPQ7Zl9jETvU9TU3ieGTYax3gEZaCaRsjtw6";

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
