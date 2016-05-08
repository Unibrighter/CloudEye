package test;

import java.util.List;

import com.base.BaseRunnable;
import com.beans.Tweet;
import com.file.FileUtils;
import com.resource.GeoResource;
import com.search.impl.RestRequestImpl;
import com.tasks.RateWindowTimer;
import com.tasks.TimerListener;

public class TaskTest extends BaseRunnable implements TimerListener {

    private long userid;

    public TaskTest(long userid) {
        this.userid = userid;
        RateWindowTimer.getInstance().setTimeListener(this);
        start();
    }

    @Override
    public boolean runTask() throws Exception {
        while (!stop) {
            List<Tweet> list = new RestRequestImpl(userid)
                    .getTimeLineOnePage(RestRequestImpl.MAX_PER_PAGE_COUNT);

            FileUtils.getInstance().writeTweets(list,
                    "/Users/zhangyu/Desktop/testrate3.csv");
        }
        return false;
    }

    @Override
    public void reloadRequest() {
        if (stop) {
            log.debug("restart a RestRequestTask");
            new TaskTest(userid);
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
