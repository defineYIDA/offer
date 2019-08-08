package thread.productAndConsumer2;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: zl
 * @Date: 2019/8/7 17:01
 */
public class Product implements Runnable {
    ArrayList<String> goods;

    public Product(ArrayList<String> goods) {
        this.goods = goods;
    }


    private int c = 1;

    @Override
    public void run() {
        while (c < 4) {
            String good = "good" + c++;
            goods.add(good);
            System.out.println(Thread.currentThread().getName() + "生产了商品：--" + good);
        }
    }
}
