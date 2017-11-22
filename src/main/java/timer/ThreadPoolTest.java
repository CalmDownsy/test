package timer;

/**
 * @author zhangsy
 * @date 2017/11/21
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        PoolUtil poolUtil = PoolUtil.getInstance();
        for (int i = 0; i < 5; i++) {
            poolUtil.execute(new TestTask("fortest"));
        }
        poolUtil.shutdown();
    }

    static class TestTask implements Runnable {
        private String threadName;

        public TestTask(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadName: " + this.threadName);
        }
    }
}
