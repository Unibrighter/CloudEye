package test;

import java.util.List;

import com.beans.Tweets;
import com.file.FileUtils;
import com.search.Search;
import com.search.impl.RestfulImpl;
import com.tag.Resource;

import twitter4j.TwitterException;

public class RestfulTest {

    public static void main(String[] args) throws TwitterException {
        // try {
        // for (int i = 0; i < 200; i++) {
        // if (i == 179) {
        // System.out.println(i);
        // }
        // List<Tweets> list = new RestfulImpl(429570086)
        // .getTimeLineOnePage(RestfulImpl.MAX_PAGE_COUNT);
        // FileUtils.getInstance().writeTweets(list,
        // "/Users/zhangyu/Desktop/testrate.csv");
        // }
        // }
        // catch (TwitterException e) {
        // e.printStackTrace();
        // }
        //
        // System.out.println("Geo...............");

        // Inner
        Search s = new RestfulImpl(Resource.REST_INNER);
        List<Tweets> list = s.search(RestfulImpl.MAX_PER_COUNT);
        FileUtils.getInstance().writeTweets(list,
                "/Users/zhangyu/Desktop/innerGeo.csv");
    }
}
