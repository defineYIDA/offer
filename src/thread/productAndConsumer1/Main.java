package thread.productAndConsumer1;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author: zl
 * @Date: 2019/8/7 17:01
 */
public class Main {
    /**
     * 采用阻塞队列的方式实现多线程间的生产者消费者模式
     * 实现原理：BlockingQueue  的 put 和 take方法，对于空或者满的队列操作
     *                 会发生阻塞。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> goods = new ArrayList<>();//goods
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

        //BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(new Product(blockingQueue, goods), "Product-1").start();//Product
        new Thread(new Product(blockingQueue, goods), "Product-2").start();
        new Thread(new Product(blockingQueue, goods), "Product-3").start();
        new Thread(new Consumer(blockingQueue, goods), "Consumer-1").start();//Consumer
        new Thread(new Consumer(blockingQueue, goods), "Consumer-2").start();
        new Thread(new Consumer(blockingQueue, goods), "Consumer-3").start();
    }
}
