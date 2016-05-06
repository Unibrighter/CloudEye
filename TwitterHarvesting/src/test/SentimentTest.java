package test;

import com.sentiment.Classifier;

public class SentimentTest {

    public static void main(String[] args) {
        String s = "Even the best students strike sometimes @CoachHilary1 :-). CU tom. @ #Kenya #Fitness #Challenge @TFCKenya bootcamp https://t.co/6Ad05HPQAJ-";
        System.out.println(Classifier.getInstance().classify(s));
    }

}
