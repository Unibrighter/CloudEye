package test;

import com.oath.OAthConfig;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class OAthTest {

    public static void main(String[] args) throws TwitterException {
        for (int i = 1; i <= 8; i++) {
            OAthConfig.setApplicationNum(i);
            sendStatus("test sending status...");
        }
    }

    public static void sendStatus(String text) throws TwitterException {
        Twitter t = new TwitterFactory(OAthConfig.getConfig(true))
                .getInstance();
        Status s = t.updateStatus(text);
        System.out.println("success. " + s.getText());
    }
}
