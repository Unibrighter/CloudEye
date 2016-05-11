package com.sentiment;

import java.io.IOException;

import com.aliasi.classify.LMClassifier;
import com.aliasi.util.AbstractExternalizable;
import com.file.FileUtils;
import com.tag.HashTag;
import com.tag.SentimentTag;

/**
 * The accuracy of sentiment analysis is 75% approximately. It can also handle
 * the emoji classification.
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 */
public class SentimentClassifier {

    private String[] categories;
    @SuppressWarnings("rawtypes")
    private LMClassifier classify;

    private static SentimentClassifier instance;

    public synchronized static SentimentClassifier getInstance() {
        if (instance == null) {
            instance = new SentimentClassifier();
        }
        return instance;
    }

    @SuppressWarnings("rawtypes")
    public SentimentClassifier() {
        try {
            classify = (LMClassifier) AbstractExternalizable.readResourceObject(
                    SentimentClassifier.class, FileUtils.FILE_CLASSIFIER);
            categories = classify.categories();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getCategories() {
        return categories;
    }

    public SentimentTag classify(String text) {
        return HashTag.getSentimentTag(classify.classify(text).bestCategory());
    }
}