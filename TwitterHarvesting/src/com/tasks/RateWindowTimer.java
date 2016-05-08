package com.tasks;

import com.base.BaseRunnable;
import com.search.impl.RestRequestImpl;

public class RateWindowTimer extends BaseRunnable {

    private static RateWindowTimer timer;
    private volatile int restCount = RestRequestImpl.MAX_REQUEST_COUNT;
    private final Object lock = new Object();
    private TimerListener listener = null;

    public static synchronized RateWindowTimer getInstance() {
        if (timer == null) {
            timer = new RateWindowTimer();
        }
        return timer;
    }

    public RateWindowTimer() {
        start();
    }

    public void setTimeListener(TimerListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean runTask() throws Exception {
        while (!stop) {
            Thread.sleep(RestRequestImpl.MAX_WINDOW_TIME);
            synchronized (lock) {
                resetRequestCount();
                lock.notifyAll();
            }
        }
        return false;
    }

    private void resetRequestCount() {
        restCount = RestRequestImpl.MAX_REQUEST_COUNT;
        log.info("resetRequestCount : " + restCount);
        if (listener != null) {
            listener.reloadRequest();
        }
    }

    public void request() throws InterruptedException {
        synchronized (lock) {
            if (restCount > 0) {
                --restCount;
                log.info("rest request count: " + restCount);
            }
            else {
                log.info(
                        "REST API waiting as the window rate has been reached...");
                lock.wait();
                request();
            }
        }
    }

    @Override
    public void stop() {
        if (listener != null) {
            listener.terminal();
            listener = null;
        }
        super.stop();
    }
}
