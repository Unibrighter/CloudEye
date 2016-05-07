package test;

import com.sentiment.Classifier;

public class SentimentTest {

    public static void main(String[] args) {
        String s = "this is <3";
        System.out.println(Classifier.getInstance().classify(s));
    }

}
