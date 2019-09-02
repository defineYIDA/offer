package singlton;

/**
 * 题2：单例模式
 * 考查：设计模式/多线程:同步锁，线程安全/静态构造函数
 * 分析：
 * 当前解法，使用了静态构造函数的特性；采用内部类(嵌套类型)的方法实现按需实例
 */
public class Singlton6 {
    private Singlton6() {
    }
    public static Singlton6 getInstance(){
        return Nested.singlton6;
    }
    private static class Nested{
        private static Singlton6 singlton6;
        static {
            singlton6=new Singlton6();
        }
    }

    public static void main(String[] args){
        System.out.println(Singlton6.getInstance());
    }
}
