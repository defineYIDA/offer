package Proxy;

/**
 * @Author: zl
 * @Date: 2019/8/24 16:21
 */
public class StaticProxy implements User {

    private User user;

    public StaticProxy(User user) {
        this.user = user;
    }

    @Override
    public void work() {
        System.out.println("打开电脑");
        user.work();
        System.out.println("关闭电脑");
    }

    @Override
    public void play() {

    }
}
