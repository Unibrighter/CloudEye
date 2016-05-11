package test;

import java.util.List;

import com.beans.Tweet;
import com.file.FileUtils;
import com.preprocess.Preprocessing;
import com.sentiment.SentimentClassifier;

public class PreprocessingTest {

    public static void main(String[] args) {
        List<Tweet> list = FileUtils.getInstance()
                .readTweetCSV("/Users/zhangyu/Desktop/timeline.csv");
        for (Tweet t : list) {
            String text = Preprocessing.process(t.getContent());
            System.out.println(text + " <"
                    + SentimentClassifier.getInstance().classify(text) + ">");
        }
        // String text = "we We is are Are Some some like";
        // text = Preprocessing.process(text);
        // System.out.println(text);
        // System.out.println(SentimentClassifier.getInstance().classify(text));
    }
}
