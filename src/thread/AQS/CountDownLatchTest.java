package thread.AQS;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zl
 * @Date: 2019/9/3 1:45
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":二级表生成");
                    Thread.sleep(10000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":二级表生成");
                    Thread.sleep(10000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("等待二级表生成完成");
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + ":汇总统计");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }
}
