package singlton;

/**
 * @Author: zl
 * @Date: 2019/8/6 16:56
 */
public class Singlton {
    //DCL 双重检查
    private static volatile Singlton singlton;//Volatile 关键字防止指令重排
    public static Singlton getInstance() {
        if (singlton == null) {
            //synchronized 确保原子性和可见性但是不确保有序性，不会禁止指令重排
            synchronized (Singlton.class) {
                if (singlton == null) {
                    singlton = new Singlton();
                }
            }
        }
        return singlton;
    }
    //静态代码块，饿汉模式
    static {
        singlton = new Singlton();
    }
    //内部类，懒汉模式
    private static class s{
        private static Singlton instance;
        static {
            instance = new Singlton();
        }
    }
}
