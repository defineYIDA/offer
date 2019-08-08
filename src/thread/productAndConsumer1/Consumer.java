package thread.productAndConsumer1;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: zl
 * @Date: 2019/8/7 17:01
 */
public class Consumer implements Runnable {
    ArrayList<String> goods;

    final BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue blockingQueue, ArrayList<String> goods) {
        this.goods = goods;
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                String s = blockingQueue.take();
                Thread.sleep(11111);
                System.out.println(Thread.currentThread().getName() + "消费了商品：--" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
