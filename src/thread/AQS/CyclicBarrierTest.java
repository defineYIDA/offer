package thread.AQS;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: zl
 * @Date: 2019/9/3 1:44
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3);
        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":计算完成");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + ":入库");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":计算完成");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + ":入库");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        try {
            Thread.sleep(10000);// 等待
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":计算完成");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + ":入库");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
