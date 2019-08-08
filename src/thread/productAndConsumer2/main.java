package thread.productAndConsumer2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zl
 * @Date: 2019/8/7 23:37
 */
public class main {
    public static void main(String[] args) {
        ArrayList<String> goods = new ArrayList<>();//goods
        //BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

        //BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        ExecutorService poolExecutor = Executors.newCachedThreadPool();
        //ExecutorService poolExecutor = Executors.newSingleThreadExecutor();
        poolExecutor.submit(new Product(goods));
        poolExecutor.submit(new Product(goods));
        poolExecutor.submit(new Product(goods));
        poolExecutor.submit(new Consumer(goods));
        poolExecutor.submit(new Consumer(goods));
        poolExecutor.submit(new Consumer(goods));
    }
}
