package com.utils.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtils {

    public static final String FOLDER_PATH = System.getProperty("user.home")
            + File.separator;
    public static final String OUTPUT_PATH = FOLDER_PATH + "logs.txt";
    public static final String NEW_LINE = "\n";
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
}
