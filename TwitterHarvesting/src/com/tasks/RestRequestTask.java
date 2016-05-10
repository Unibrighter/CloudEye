package com.tasks;

import java.util.List;

import com.base.BaseRunnable;
import com.beans.Tweet;
import com.resource.GeoResource;
import com.search.impl.RestRequestImpl;
import com.utils.UtilHelper;

public class RestRequestTask extends BaseRunnable implements TimerListener {

    private GeoResource geo;
    private CouchDBTask dbTask = new CouchDBTask();

    public RestRequestTask(GeoResource geo) {
        this.geo = geo;
        RateWindowTimer.getInstance().setTimeListener(this);
        start();
    }

    @Override
    public boolean runTask() throws Exception {
        while (!stop) {
            List<Tweet> list = new RestRequestImpl(geo)
                    .search(RestRequestImpl.MAX_PER_SEARCH_COUNT);
            dbTask.insert(UtilHelper.commitTag(list));
        }
        return false;
    }

    @Override
    public void reloadRequest() {
        if (stop) {
            log.debug("restart a RestRequestTask");
            new RestRequestImpl(geo);
        }
    }

    @Override
    public void terminal() {
        stop();
    }

    @Override
    public void stop() {
        super.stop();
        log.debug("limit exceed. stopping RestRequestTask.");
    }
}
