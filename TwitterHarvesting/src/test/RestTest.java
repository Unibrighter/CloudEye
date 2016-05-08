package test;

import com.oath.OAthConfig;

import twitter4j.TwitterException;

public class RestTest {

    public static void main(String[] args) throws TwitterException {
        OAthConfig.setApplicationNum(5);
        new TaskTest(125551669);

        // Inner
        // for (int i = 0; i < AbstractSearch.MAX_COUNT; i++) {
        // AbstractSearch s = new RestRequestImpl(Resource.REST_INNER);
        // List<Tweet> list = s.search(RestRequestImpl.MAX_PER_SEARCH_COUNT);
        // FileUtils.getInstance().writeTweets(list,
        // "/Users/zhangyu/Desktop/innerGeo3.csv");
        // }
    }
}
