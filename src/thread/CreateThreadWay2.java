package thread;

/**
 * @Author: zl
 * @Date: 2019/7/20 17:29
 */
public class CreateThreadWay2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(Thread.currentThread().getName());
            if (i == 20) {
                //一：推荐使用
                new Thread(new runableTest(), "方式一").start();
                //二：
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        printf();
                    }
                }, "方式二").start();
                //三：
                new Thread("方式三"){
                    @Override
                    public void run() {
                        printf();
                    }
                }.start();
                //四：推荐使用
                new Thread(() -> {
                    printf();
                }, "方式四").start();
                //五
                new Thread(CreateThreadWay2::printf, "方式五").start();
            }
        }
    }

    public static void printf () {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
class runableTest implements Runnable{
    @Override
    public void run() {
        CreateThreadWay2.printf();
    }
}
