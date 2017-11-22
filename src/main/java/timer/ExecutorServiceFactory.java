package timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangsy
 * @date 2017/11/17
 */
public class ExecutorServiceFactory {

    private static ExecutorServiceFactory executorServiceFactory = new ExecutorServiceFactory();

    private ExecutorServiceFactory() {}

    public static ExecutorServiceFactory getInstance() {
        return executorServiceFactory;
    }

    //通过Executors获取四种线程池

    public ExecutorService createScheduledPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Executors.newScheduledThreadPool(availableProcessors, getFactory());
    }

    public ExecutorService createSinglePool() {
        return Executors.newSingleThreadScheduledExecutor(getFactory());
    }

    public ExecutorService createFixedPool(int count) {
        return Executors.newFixedThreadPool(count);
    }

    public ExecutorService createCachePool() {
        return Executors.newCachedThreadPool(getFactory());
    }


    /**
     * 创建线程池工厂，自定义Thread
     * @return
     */
    private ThreadFactory getFactory() {
        return new ThreadFactory() {
            AtomicInteger ai = new AtomicInteger();
            public Thread newThread(Runnable r) {
                SecurityManager sm = System.getSecurityManager();
                ThreadGroup threadGroup = (null != sm) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
                Thread thread = new Thread(threadGroup, r);
                thread.setName("任务线程：" + ai.incrementAndGet());
                return thread;
            }
        };
    }
}
