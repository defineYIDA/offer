package singlton;

/**
 * 题2：单例模式
 * 考查：设计模式/多线程/静态构造函数
 * 分析：
 * 当前解法，使用了静态构造函数的特性；缺点是在调用其他静态方法时会过早的实例
 */
public class Singlton5 {
    public static void main(String[] args) {
        System.out.println(Instance);
    }
    private Singlton5(){

    }

    public static Singlton5 Instance;

    /**
     * 静态构造函数,当静态属性被调用时调用
     */
    static {
        Instance=new Singlton5();
    }

    public static Singlton5 getInstance(){
        return Instance;
    }

    public static void func()
    {

    }

}
