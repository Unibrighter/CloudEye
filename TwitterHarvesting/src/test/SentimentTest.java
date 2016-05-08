package test;

import com.sentiment.SentimentClassifier;

public class SentimentTest {

    public static void main(String[] args) {
        String s = "this is <3";
        System.out.println(SentimentClassifier.getInstance().classify(s));
    }

}
