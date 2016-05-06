package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.beans.Tweets;

import sun.swing.plaf.synth.DefaultSynthStyle.StateInfo;
import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

public class FileUtils {

    public static final String FOLDER_PATH = System.getProperty("user.home")
            + File.separator;
    public static final String FILE_LOG_PATH = FOLDER_PATH + "logs.txt";
    public static final String FILE_TWEETS_PATH = FOLDER_PATH + "tweets.csv";
    public static final String FILE_CLASSIFIER = "classifier.txt";
    public static final String NEW_LINE = "\n";
    public static final String SPLIT = ",";
    public static final String FILE_FORMAT = "UTF-8";
    private static final String HEADER = "id";
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
        CSVPrinter csv = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true), FILE_FORMAT), buffedSize);
            csv = new CSVPrinter(bw, CSVFormat.DEFAULT);
            // add header
            String[] header = new String[] { "id", "content", "JSON" };
            for (String s : header) {
                csv.print(s);
            }
            csv.println();
            for (Tweets te : list) {
                csv.print(te.getId());
                csv.print(te.getContent());
                csv.print(te.getJson());
                csv.println();
            }
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
            if (csv != null) {
                try {
                    csv.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized List<Tweets> readCSV(String path) {
        List<Tweets> list = new ArrayList<>();
        BufferedReader br = null;
        CSVParser csv = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize);
            csv = new CSVParser(br, CSVFormat.DEFAULT);
            // skip the header.
            for (CSVRecord record : csv) {
                if (!HEADER.equals(record.get(0))) {
                    String json = record.get(record.size() - 1);
                    Status status = (Status) TwitterObjectFactory
                            .createObject(json.toString());
                    list.add(UtilHelper.convertStatus(status));
                }
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
            if (csv != null) {
                try {
                    csv.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
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
