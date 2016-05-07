package com;

import java.util.List;

import com.beans.Tweets;
import com.search.Search;
import com.search.impl.StreamSearchImpl;
import com.tag.Key;
import com.utils.FileUtils;
import com.utils.log.Log;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainDriver {

    private static final Log log = Log.getInstance();
    private static final int COUNT = 1;

    public static void main(String[] args) throws TwitterException {
        search();
        printAll();
    }

    public static void search() {
        Search search = new StreamSearchImpl(Key.EAST);
        List<Tweets> list = search.search(StreamSearchImpl.MAX_COUNT);
        System.out.println("finish");
    }

    public static void printAll() {
        List<Tweets> list = FileUtils.getInstance()
                .readCSV(FileUtils.FILE_TWEETS_PATH);
        for (Tweets t : list) {
            System.out.println(t.toString());
        }
    }

    public static void postStatus() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        String message = "how r u";
        Status status = twitter.updateStatus(message);
        log.debug("Successfully updated status to " + status.getText());
    }

}
