package timer;

import java.util.concurrent.*;
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

    //自定义线程池
    public ExecutorService createSelfPool() {
        //最小线程池数量，如果线程数量小于该值，新提交任务，即使有空闲线程，也会再创建一个；
        //线程数量等于最小线程池数量，但缓冲队列未满时，会将新提交任务放到workQueue中，按照FIFO原则，有空闲线程则执行缓冲队列任务；
        //线程数量大于最小线程池数量，缓冲队列已满，就会新建线程执行任务

        //当线程数小于核心线程数时，创建线程。
        //当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
        //当线程数大于等于核心线程数，且任务队列已满
        //若线程数小于最大线程数，创建线程
        //若线程数等于最大线程数，抛出异常，拒绝任务
        return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
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
