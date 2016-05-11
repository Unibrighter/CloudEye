package com.file.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.beans.Tag;
import com.beans.Tweet;
import com.file.FileUtils;
import com.file.impl.CSVTags;
import com.oath.OAthConfig;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class CSVConvert {

    private static final String tagPath = "/Users/zhangyu/Desktop/TAG_Tweets.csv";
    private static final String targetPath = "/Users/zhangyu/Desktop/Finaldata/north/";
    private static int writeSize = 0;
    private static final String[] filename;

    static {
        filename = new File(targetPath).list();
    }

    public static void main(String[] args) {
        int count = 0;
        for (String file : filename) {
            if (!file.equals(".DS_Store")) {
                String path = targetPath + file;
                readCSV(path);
                System.out.println("finish: " + path);
                count++;
            }
        }
        System.out.println("file count : " + count);
        System.out.println("total : " + writeSize);
    }

    public static void readCSV(String path) {
        long start = System.currentTimeMillis();
        OAthConfig.setApplicationNum(4);

        // read tweets json file, json position is the third column
        List<Tweet> list = FileUtils.getInstance().readTweetCSV(path, 2);
        System.out.println("Tweets csv size: " + list.size());
        System.out.println("reading time: " + getRunTime(start));
        start = System.currentTimeMillis();

        // tag processing
        List<Tag> taglist = new ArrayList<>();
        int cacheSize = 1000;
        int eachcount = 0;
        for (Tweet t : list) {
            taglist.add(t.preprocessing());
            if (taglist.size() == cacheSize) {
                FileUtils.getInstance().writeTweets(new CSVTags(taglist),
                        tagPath);
                eachcount += taglist.size();
                taglist.clear();
            }
        }
        if (taglist.size() > 0) {
            FileUtils.getInstance().writeTweets(new CSVTags(taglist), tagPath);
            eachcount += taglist.size();
        }
        System.out.println("actual write size: " + eachcount);
        System.out.println("processing and writing time: " + getRunTime(start));
        writeSize += eachcount;
        list.clear();
    }

    public static float getRunTime(long startTime) {
        return (float) (System.currentTimeMillis() - startTime) / 1000;
    }
}
