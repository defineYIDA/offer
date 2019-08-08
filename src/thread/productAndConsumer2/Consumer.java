package thread.productAndConsumer2;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: zl
 * @Date: 2019/8/7 17:01
 */
public class Consumer implements Runnable {
    ArrayList<String> goods;


    public Consumer(ArrayList<String> goods) {
        this.goods = goods;
    }


    @Override
    public void run() {
        while (true) {
            String s = goods.remove(0);
            //Thread.sleep(11111);
            System.out.println(Thread.currentThread().getName() + "消费了商品：--" + s);
        }
    }
}
