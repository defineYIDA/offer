package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: zl
 * @Date: 2019/7/20 17:29
 */
public class CreateThreadWay3 {

    public static void main(String[] args) throws Exception{
        //extends Runnable, Future<V>
        // return type V
        FutureTask<Integer> ft = new FutureTask<>(new CallableTest());
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        System.out.println("子线程的返回值：" + ft.get());
        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }));
    }

}
class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}