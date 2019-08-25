package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zl
 * @Date: 2019/8/24 16:26
 */
public class DynamicProxy implements InvocationHandler {
    private User user;

    public DynamicProxy(User user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开电脑");
        method.invoke(user, args);
        System.out.println("关闭电脑");
        return null;
    }
}
