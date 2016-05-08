package test;

import com.base.BaseRunnable;
import com.tasks.RateWindowTimer;

public class TimerTest {

    public static void main(String[] args) {
        new A(5).start();
        new A(5).start();
//        new A(20).start();
//        new A(20).start();
//        new A(20).start();
    }
}

class A extends BaseRunnable {
    
    private int count;
    
    public A(int count) {
        this.count = count;
    }

    @Override
    public boolean runTask() throws Exception {
        for (int i = 0; i < count; i++) {
            RateWindowTimer.getInstance().request();
            Thread.sleep(100);
        }
        return false;
    }
    
}