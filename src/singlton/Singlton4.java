package singlton;

/**
 * 题2：单例模式
 * 考查：设计模式/多线程:同步锁，线程安全/静态构造函数
 * 分析：
 * 当前解法，考虑了多线程加同步锁，
 */
public class Singlton4 {
    private volatile static Singlton4 Singlton4;

    private Singlton4() {}

    public static Singlton4 getInstance() {
        // 第一次创建时才加锁
        if (Singlton4 == null) {
            synchronized (Singlton4.class) {
                if (Singlton4 == null) {
                    Singlton4 = new Singlton4();
                }
            }
        }
        return Singlton4;
    }
}
