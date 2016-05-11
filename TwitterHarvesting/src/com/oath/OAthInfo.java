package com.oath;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class OAthInfo {

    private final String consumerSecret;
    private final String consumerKey;
    private final String accessToken;
    private final String accessTokenSecret;

    public OAthInfo(String consumerSecret, String consumerKey,
            String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}
