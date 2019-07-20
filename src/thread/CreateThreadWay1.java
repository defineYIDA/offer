package thread;

/**
 * @Author: zl
 * @Date: 2019/7/20 17:27
 */
public class CreateThreadWay1 extends Thread {
    @Override
    public void run() {
        //targe执行体
        for(int i = 0; i < 100; i++) {
            System.out.println(getName());
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
            if (i == 20) {
                new CreateThreadWay1().start();
                new CreateThreadWay1().start();
            }
        }
    }
}
