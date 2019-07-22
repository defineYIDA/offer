package thread;

import java.util.concurrent.CountDownLatch;

/**
 * 解法一：原子变量作为信号灯
 */
public class OrderPrint {
    private volatile int now = 1;
    //就是多个线程调用如下三个方法
    //例如：thread1-->second，thread2-->first，thread3-->third
    //不管线程的启动顺序如何，方法执行顺序必须是：first()-->second()-->third()
    public void frist() {
        while (now != 1) {}
        for (int i = 0; i < 100; i++)
            System.out.println("one");
        now = 2;
    }
    public void second() {
        while (now != 2) {}
        for (int i = 0; i < 100; i++)
            System.out.println("two");
        now = 3;
    }
    public void third() {
        for (int i = 0; i < 100; i++)
            System.out.println("three");
    }
    public static void main(String[] args) {
        OrderPrint op = new OrderPrint();
        //thread1
        new Thread(()->{
            op.second();
        }).start();
        new Thread(()->{
            op.frist();
        }).start();
        new Thread(()->{
            op.third();
        }).start();
    }
}

/**
 * 解法二：
 */
class OrderPrint1 {
    private CountDownLatch countDownLatchA = new CountDownLatch(1);
    private CountDownLatch countDownLatchB = new CountDownLatch(1);

    public void frist() {
        for (int i = 0; i < 100; i++)
            System.out.println("one");
        countDownLatchA.countDown();
    }
    public void second() {
        try {
            countDownLatchA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++)
            System.out.println("two");
        countDownLatchB.countDown();
    }
    public void third() {
        try {
            countDownLatchB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++)
            System.out.println("three");
    }
    public static void main(String[] args) {
        OrderPrint1 op = new OrderPrint1();
        //thread1
        new Thread(()->{
            op.second();
        }).start();
        new Thread(()->{
            op.frist();
        }).start();
        new Thread(()->{
            op.third();
        }).start();
    }
}

/**
 * 解法三：
 */
class OrderPrint2 {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object obj = new Object();

    public void frist() {
        synchronized (obj) {
            for (int i = 0; i < 100; i++)
                System.out.println("one");
            firstFinished = true;
            obj.notifyAll();
        }
    }
    public void second() {
        synchronized (obj) {
            while (!firstFinished) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 100; i++)
                System.out.println("two");
            obj.notifyAll();
            secondFinished = true;
        }
    }
    public void third() {
        synchronized (obj) {
            while (!secondFinished) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 100; i++)
                System.out.println("three");
        }
    }
    public static void main(String[] args) {
        OrderPrint2 op = new OrderPrint2();
        //thread1
        new Thread(()->{
            op.second();
        }).start();
        new Thread(()->{
            op.frist();
        }).start();
        new Thread(()->{
            op.third();
        }).start();
    }
}
