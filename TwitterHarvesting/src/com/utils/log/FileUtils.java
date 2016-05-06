package com.utils.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import com.config.Tweets;
import com.utils.UtilHelper;

import sun.swing.plaf.synth.DefaultSynthStyle.StateInfo;

public class FileUtils {

    public static final String FOLDER_PATH = System.getProperty("user.home")
            + File.separator;
    public static final String OUTPUT_PATH = FOLDER_PATH + "logs.txt";
    public static final String TWEETS_PATH = FOLDER_PATH + "tweets.csv";
    public static final String NEW_LINE = "\n";
    public static final String SPLIT = ",";
    private static final String FILE_FORMAT = "UTF-8";
    private static int buffedSize = 1024;
    private static FileUtils instance;

    public static synchronized FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    /**
     * Writing the output into a given file.
     * 
     * @param text
     * @param path
     */
    public synchronized void write(String text, String path) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true), FILE_FORMAT), buffedSize);
            bw.write(text);
            bw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void writeTweets(List<Tweets> list, String path) {
        if (list == null) {
            return;
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true), FILE_FORMAT), buffedSize);
            StringBuilder sb = new StringBuilder();
            for (Tweets te : list) {
                sb.append(te.getId() + SPLIT + te.getDate() + SPLIT
                        + te.getContent() + SPLIT + te.getLang() + SPLIT
                        + te.getUserID() + SPLIT + te.getLang() + SPLIT
                        + UtilHelper.toString(te.getPlace()) + SPLIT
                        + UtilHelper.toString(te.getGeo()) + SPLIT
                        + te.getDevice() + SPLIT + te.getJson());
                sb.append(NEW_LINE);
            }
            bw.write(sb.toString());
            bw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reading a text from a given file path.
     * 
     * @param path
     * @return
     */
    public String read(String path) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
