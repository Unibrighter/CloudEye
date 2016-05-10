package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.beans.Tweet;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.utils.UtilHelper;
import com.utils.csv.CSVFormat;
import com.utils.csv.CSVParser;
import com.utils.csv.CSVPrinter;
import com.utils.csv.CSVRecord;
import com.utils.log.Log;

import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

public class FileUtils {

    private static final Log log = Log.getInstance();
    public static final String FOLDER_PATH = System.getProperty("user.home")
            + File.separator;
    public static final String FILE_LOG_PATH = FOLDER_PATH + "logs.txt";
    public static final String FILE_TWEETS_PATH = FOLDER_PATH + "tweets.csv";
    public static final String FILE_REST_TWEETS_PATH = FOLDER_PATH
            + "rest_tweets.csv";
    public static final String FILE_CLASSIFIER = "classifier.txt";
    public static final String NEW_LINE = "\n";
    public static final String SPLIT = ",";
    public static final String FILE_FORMAT = "UTF-8";
    public static final String HEADER = "id";
    public static int buffedSize = 1024;
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

    public synchronized void writeTweets(CSVWriteLIstener<?> data,
            String path) {
        if (data.getList() == null) {
            return;
        }
        BufferedWriter bw = null;
        CSVPrinter csv = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, true), FILE_FORMAT), buffedSize);
            csv = new CSVPrinter(bw, CSVFormat.DEFAULT);
            // add header
            String[] header = data.getHeader();
            if (header != null) {
                for (String s : header) {
                    csv.print(s);
                }
                csv.println();
            }
            for (Object t : data.getList()) {
                for (String cell : data.getRawData(t)) {
                    csv.print(cell);
                }
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

    public int getFileLine(String path) {
        int line = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize);
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                if (!UtilHelper.isEmptyStr(readLine)) {
                    ++line;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public List<JsonObject> readTag(String path) {
        List<JsonObject> list = new ArrayList<>();
        CSVParser csv = null;
        try {
            csv = new CSVParser(new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize),
                    CSVFormat.DEFAULT);
            for (CSVRecord record : csv) {
                String json = record.get(0);
                list.add(new JsonParser().parse(json).getAsJsonObject());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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

    public List<Tweet> readTweetCSV(String path) {
        return readTweetCSV(path, -1);
    }

    public List<Tweet> readTweetCSV(String path, int column) {
        List<Tweet> list = new ArrayList<>();
        BufferedReader br = null;
        CSVParser csv = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize);
            csv = new CSVParser(br, CSVFormat.DEFAULT);
            int errorCount = 0;
            for (CSVRecord record : csv) {
                if (!HEADER.equals(record.get(0))) {
                    int col = column == -1 ? record.size() - 1 : column;
                    String json = null;
                    try {
                        json = record.get(col);
                    }
                    catch (Exception e1) {
                        continue;
                    }
                    if (!UtilHelper.isEmptyStr(json)) {
                        try {
                            Status status = (Status) TwitterObjectFactory
                                    .createObject(json);
                            list.add(UtilHelper.convertStatus(status));
                        }
                        catch (Exception e) {
                            ++errorCount;
                            log.debug("Json Parser exception: count: "
                                    + errorCount + " Json: " + json);
                            continue;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            log.debug("CSV reading error: " + e.getMessage());
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
    public Set<String> read(String path) {
        Set<String> words = new HashSet<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), FILE_FORMAT), buffedSize);
            String line = null;
            while ((line = br.readLine()) != null) {
                words.add(line);
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
        return words;
    }
}
