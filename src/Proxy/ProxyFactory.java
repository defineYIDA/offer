package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zl
 * @Date: 2019/8/24 16:43
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前面干点啥");
                        /**
                         * 调用方法的invoke方法，不能传入proxy对象不然会递归
                         * Object obj,  被代理对象
                         * Object... args, 参数
                         * Object proxy, 没啥卵用，代表当前对象
                         */
                        Object res = method.invoke(target, args);
                        System.out.println("后面干点啥");
                        return res;
                    }
                }
        );
    }
}