package com.file.tools;

import java.io.File;
import java.util.List;

import com.file.FileUtils;
import com.google.gson.JsonObject;
import com.tasks.CouchDBTask;

public class TagInsertDirver {

    private static CouchDBTask dbTask = new CouchDBTask();
    private static final String targetPath = "/Users/zhangyu/Desktop/Finaldata/west/";
    private static final String[] filename;

    static {
        filename = new File(targetPath).list();
    }

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        for (String file : filename) {
            if (!file.equals(".DS_Store")) {
                String path = targetPath + file;
                List<JsonObject> list = FileUtils.getInstance().readTag(path);
                dbTask.insert(list);
                System.out.println("finish: " + path);
                count++;
            }
        }
        System.out.println("file count : " + count);
    }
}
