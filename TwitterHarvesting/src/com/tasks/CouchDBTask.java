package com.tasks;

import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbException;
import org.lightcouch.DocumentConflictException;
import org.lightcouch.Response;

import com.base.BaseRunnable;
import com.google.gson.JsonObject;
import com.utils.log.Log;

public class CouchDBTask extends BaseRunnable {

    private static final Log log = Log.getInstance();
    private static CouchDbClient connection;
    private List<JsonObject> list = null;

    public CouchDBTask() {
    }

    public CouchDBTask(List<JsonObject> list) {
        this.list = list;
    }

    /**
     * true: insert success; false: failed insert
     * 
     * @param list
     * @return
     */
    public boolean insert(List<JsonObject> list) throws CouchDbException {
        if (list == null) {
            return false;
        }
        if (getConnection() == null) {
            return false;
        }
        if (stop) {
            // wake up db task
            start();
        }
        // post a new insert task
        post(new CouchDBTask(list));
        return true;
    }

    @Override
    public boolean runTask() throws Exception {
        save();
        return true;
    }

    private synchronized CouchDbClient getConnection() {
        if (connection == null) {
            connection = new CouchDbClient();
        }
        return connection;
    }

    private void save() {
        if (list == null) {
            return;
        }
        for (JsonObject jsonObject : list) {
            try {
                Response response = getConnection().save(jsonObject);
            }
            catch (DocumentConflictException e) {
                log.debug(
                        "Insert conflict as the dulipated data: " + jsonObject);
                continue;
            }
            catch (CouchDbException e) {
                // TODO save the rest data into cache file, when the next
                // connection start, the rest data will be inserted firstly.
                close();
                return;
            }
        }
        list = null;
    }

    public void close() {
        if (connection != null) {
            connection.shutdown();
            connection = null;
        }
    }

    @Override
    public void stop() {
        close();
        super.stop();
    }
}
