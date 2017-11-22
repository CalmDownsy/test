package timer;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangsy
 * @date 2017/11/21
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }
                }
            });
        }
    }

    @Test
    public void fixedPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }
                }
            });
        }
    }
}
