package timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author zhangsy
 * @date 2017/11/17
 */
public class NormalThread {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(123);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(456);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 2000L);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    }
}
