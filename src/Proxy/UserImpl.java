package Proxy;

/**
 * @Author: zl
 * @Date: 2019/8/24 16:19
 */
public class UserImpl implements User {
    @Override
    public void work() {
        System.out.println("coding");
    }
    @Override
    public void play() {
        System.out.println("play");
    }
}
