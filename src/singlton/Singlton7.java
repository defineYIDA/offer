package singlton;

/**
 * @Author: zl
 * @Date: 2019/8/27 23:01
 */
public class Singlton7 {
    private volatile static Singlton7 singlton;
    private static class sync {

    }
    public static Singlton7 getInstance() {
        if (singlton == null) {
            synchronized (Singlton7.class) {
                if (singlton == null) {
                    singlton = new Singlton7();
                }
            }
        }
        return singlton;
    }
}
