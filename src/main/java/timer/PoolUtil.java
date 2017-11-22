package timer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author zhangsy
 * @date 2017/11/21
 */
public class PoolUtil {

    private static PoolUtil poolUtil = new PoolUtil();
    private ExecutorService executorService = null;
    private int threadCount = 10;

    private PoolUtil() {
        System.out.println("MaxCount: " + threadCount);
//        executorService = ExecutorServiceFactory.getInstance().createFixedPool(threadCount);
        executorService = ExecutorServiceFactory.getInstance().createSinglePool();
    }

    public static PoolUtil getInstance() {
        return poolUtil;
    }

    //关闭线程池
    public void shutdown() {
        executorService.shutdown();
    }

    //提交线程池
    public Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }

    public Future<?> submit(Callable<?> task) {
        return executorService.submit(task);
    }

    //直接提交，无返回值
    public void execute(Runnable task) {
        executorService.execute(task);
    }
}
