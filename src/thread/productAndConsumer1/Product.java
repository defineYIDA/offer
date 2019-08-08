package thread.productAndConsumer1;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: zl
 * @Date: 2019/8/7 17:01
 */
public class Product implements Runnable {
    ArrayList<String> goods;

    private final BlockingQueue<String> blockingQueue;

    public Product(BlockingQueue<String> blockingQueue, ArrayList<String> goods) {
        this.goods = goods;
        this.blockingQueue = blockingQueue;
    }


    private int c = 1;

    @Override
    public void run() {
        while (c < 4) {
            String good = "good" + c++;
            try {
                blockingQueue.put(good);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "生产了商品：--" + good);
        }
    }
}
