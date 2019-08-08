package thread.productAndConsumer;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/8/2 20:32
 */
public class Consumer implements Runnable {

    private final String lock;

    private ArrayList<String> goods;

    public Consumer(String lock, ArrayList<String> goods) {
        this.lock = lock;
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (goods.isEmpty()) {
                    //商品为空不消费
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //消费商品
                String good = goods.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费了商品：--" + good);
                //通知生产
                lock.notifyAll();
            }
        }
    }
}
