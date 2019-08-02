package thread.productAndConsumerOneToOne;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/8/2 20:33
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> goods = new ArrayList<>();//goods
        String lock = "lock";
        new Thread(new Product(lock, goods), "Product-1").start();//Product
        new Thread(new Product(lock, goods), "Product-2").start();
        new Thread(new Product(lock, goods), "Product-3").start();
        new Thread(new Consumer(lock, goods), "Consumer-1").start();//Consumer
        new Thread(new Consumer(lock, goods), "Consumer-2").start();
        new Thread(new Consumer(lock, goods), "Consumer-3").start();
    }
}
