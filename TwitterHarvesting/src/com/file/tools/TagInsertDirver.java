package com.file.tools;

import java.util.List;

import com.file.FileUtils;
import com.google.gson.JsonObject;
import com.tasks.CouchDBTask;

public class TagInsertDirver {

    private static CouchDBTask dbTask = new CouchDBTask();

    public static void main(String[] args) throws InterruptedException {
        List<JsonObject> list = FileUtils.getInstance()
                .readTag("/Users/zhangyu/Desktop/North_Streaming_TAG_Tweets.csv");
        dbTask.insert(list);
    }
}
