package thread.productAndConsumerOneToOne;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/8/2 20:32
 */
public class Product implements Runnable {

    private final String lock;

    private ArrayList<String> goods;

    public Product(String lock, ArrayList<String> goods) {
        this.lock = lock;
        this.goods = goods;
    }

    private int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (!goods.isEmpty()) {
                    //商品不为空，不生成
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 15)
                    break;
                //生产
                String good = "good" + i++;
                goods.add(good);
                System.out.println(Thread.currentThread().getName() + "生产了商品：--" + good);
                //通知消费
                lock.notifyAll();
            }
        }
    }
}
