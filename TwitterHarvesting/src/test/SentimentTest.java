package test;

import com.sentiment.Classifier;

public class SentimentTest {

    public static void main(String[] args) {
        String s = "i like you";
        System.out.println(Classifier.getInstance().classify(s));
    }

}
