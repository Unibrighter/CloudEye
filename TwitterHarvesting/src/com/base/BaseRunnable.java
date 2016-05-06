package com.base;

import java.util.concurrent.LinkedBlockingQueue;

import com.utils.log.Log;

public abstract class BaseRunnable implements Runnable {

    protected static final Log log = Log.getInstance();
    protected boolean stop = true;
    private LinkedBlockingQueue<BaseRunnable> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        stop = false;
        try {
            // e.g. if connection should not be closed, each connection can set
            // (isLoop = true) to keep the connection thread alive.
            boolean isLoop = true;
            while (isLoop && !stop) {
                isLoop = queue.take().runTask();
            }
        }
        catch (Exception e) {
            log.error("Task has been terminated by the exception: " + e);
        }
        finally {
            stop();
        }
    }

    /**
     * true: the thread will keep doing runnable by the post() method until
     * stop.
     * 
     * false: stop doing runnable.
     * 
     * default value should return false;
     */
    public abstract boolean runTask() throws Exception;

    public boolean isRunning() {
        return !stop;
    }

    public void stop() {
        if (!stop) {
            stop = true;
            post(new StopRunnable());
            log.debug(this.getClass().getSimpleName()
                    + " task has been stopped.");
        }
    }

    public void start() {
        start(this);
    }

    protected void start(BaseRunnable task) {
        post(task);
        // Starting a thread or adding this runnable into a thread-pool.
        new Thread(this).start();
    }

    protected void post(BaseRunnable runnable) {
        queue.offer(runnable);
    }
}
