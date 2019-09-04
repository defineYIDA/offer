package thread.AQS;

import java.util.concurrent.Semaphore;

/**
 * @Author: zl
 * @Date: 2019/9/3 1:44
 */
public class SemaphoreTest {
    private static final int tokenCount = 3;
    public static void main(String[] args) {
        final Semaphore tokens = new Semaphore(tokenCount); // 令牌发放者
        for(int i=0;i<10;i++)
            new Request(tokens).start();
    }

    static class Request extends Thread {
        private Semaphore tokens;

        public Request(Semaphore tokens) {
            this.tokens = tokens;
        }
        @Override
        public void run() {
            try {
                tokens.acquire();// 申请访问令牌
                System.out.println(Thread.currentThread().getName()+":访问资源...");
                Thread.sleep(3000);
                tokens.release();// 访问完毕归还令牌
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
