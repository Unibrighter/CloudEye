package test;

import java.util.List;

import com.beans.Tweet;
import com.beans.JsonTweet;
import com.beans.Tag;
import com.file.FileUtils;
import com.google.gson.JsonObject;

public class TopicClassiferTest {

    public static void main(String[] args) {
        List<Tweet> list = FileUtils.getInstance()
                .readTweetCSV("/Users/zhangyu/Desktop/timeline.csv");
        for (Tweet t : list) {
            Tag tag = t.preprocessing();
            JsonObject json = JsonTweet.build(tag.classifyTopic());
            System.out.println(json.toString());
        }
    }
}
