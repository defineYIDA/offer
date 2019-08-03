package thread;

/**
 * @Author: zl
 * @Date: 2019/8/3 10:42
 */
public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    String lock = "lock";

    boolean printfEven = false;

    boolean printfOdd = false;

    int i = 1;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero()  {
        while (true) {
            synchronized (lock) {
                while (printfEven || printfOdd) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i > n) {
                    break;
                }
                System.out.println(0);
                if (i % 2 == 0) {
                    printfEven = true;
                } else {
                    printfOdd = true;
                }
                lock.notifyAll();
            }
        }
    }

    public void even()  {
        while (true) {
            synchronized (lock) {
                while (!printfEven) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i > n) {
                    break;
                }
                System.out.println("e" + i);
                printfEven = false;
                i++;
                lock.notifyAll();
            }
        }
    }

    public void odd()  {
        while (true) {
            synchronized (lock) {
                while (!printfOdd) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i > n) {
                    break;
                }
                System.out.println("o" + i);
                printfOdd = false;
                i++;
                lock.notifyAll();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(4);
        new Thread(()->{
            zeroEvenOdd.even();
        }).start();
        new Thread(()->{
            zeroEvenOdd.odd();
        }).start();
        new Thread(()->{
           zeroEvenOdd.zero();
        }).start();
    }
}
