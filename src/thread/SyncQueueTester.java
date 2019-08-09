package thread;

import java.util.concurrent.*;

/**
 * @Author: zl
 * @Date: 2019/8/7 23:21
 */
public class SyncQueueTester {

    //顺序执行，对于期间插入队列的元素进行抛弃，抛弃的原因是线程数到达最大值，而不是队列容量（可以测试将核心线程调高）
    /**
     * start 0
     * stop 0
     * start 5
     * stop 5
     */
    /*private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new ThreadPoolExecutor.DiscardPolicy());*/

    //和上一种方式类似，只不过如果生产者再生产的时候，如果线程还在执行就抛异常
    /*private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());*/

    //和前面方法唯一不同的是：ArrayBlockingQueue<>(1)存在一个容量，所以生产1的时候会被保存，而SynchronousQueue不会
    /**
     * start 0
     * stop 0
     * start 1
     * stop 1
     * start 5
     * stop 5
     */
    private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.DiscardPolicy());

    //顺序执行FIFO，产生原因是LinkedBlockingQueue在单线程被占用的时候可以被缓存下来，直到任务执行完，线程空闲
    //private static ExecutorService executor = Executors.newSingleThreadExecutor();
    //return new FinalizableDelegatedExecutorService
    //            (new ThreadPoolExecutor(1, 1,
    //                                    0L, TimeUnit.MILLISECONDS,
    //                                    new LinkedBlockingQueue<Runnable>()));

    //并发执行无序，因为非核心线程多个，被take后又会put，无法对任务是否执行完毕进行约束（其实只能通过单线程，线程占用来约束）
    //private static ExecutorService executor = Executors.newCachedThreadPool();
    //return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
    //                                      60L, TimeUnit.SECONDS,
    //                                      new SynchronousQueue<Runnable>());


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            kickOffEntry(i);

            Thread.sleep(200);
        }

        executor.shutdown();
    }

    private static void kickOffEntry(final int index) {
        executor.
                submit(
                        new Callable<Void>() {
                            public Void call() throws InterruptedException {
                                System.out.println("start " + index);
                                Thread.sleep(1000); // pretend to do work
                                System.out.println("stop " + index);
                                return null;
                            }
                        }
                );
    }

}
