package com.tasks;

import com.base.BaseRunnable;
import com.resource.GeoResource;
import com.search.AbstractSearch;
import com.search.impl.StreamingImpl;

public class StreamingTask extends BaseRunnable {

    private GeoResource geo;

    public StreamingTask(GeoResource geo) {
        this.geo = geo;
        start();
    }

    @Override
    public boolean runTask() throws Exception {
        AbstractSearch search = new StreamingImpl(geo);
        search.search(AbstractSearch.MAX_COUNT);
        log.info("StreamingTask finish");
        return false;
    }
}
