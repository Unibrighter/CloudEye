package com.base;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class StopRunnable extends BaseRunnable {

    @Override
    public boolean runTask() throws Exception {
        // do nothing, just for gracefully interrupt the thread with a message
        // queue.
        return false;
    }

}
