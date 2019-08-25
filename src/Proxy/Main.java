package Proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: zl
 * @Date: 2019/8/24 16:22
 */
public class Main {
    public static void main(String[] args) {
        User user = new UserImpl();//被代理对象
        /**
         * 静态代理：通过实现一个接口，代理类持有被代理类的引用
         * 问题：硬编码
         */
        StaticProxy staticProxy = new StaticProxy(user);
        staticProxy.work();
        System.out.println(staticProxy.getClass());
        System.out.println("--------------------------------------------");

        DynamicProxy dynamicProxy = new DynamicProxy(user);
        /**
         * 生成代理实例
         *ClassLoader loader,    被代理对象的类加载器，通过此类加载器将代理类加载入jvm中；
         *Class<?>[] interfaces, 被代理类所实现的所有接口，需要所有的接口的目的是创建新的代理类实现被代理类的所有接口，保证被代理类所有方法都能够
         *                                  被代理。其实代理的核心就是新创建一个类并实例化对象，去集成被代理对象所有功能的同时，再加入某些特性化的功能；
         * InvocationHandler h,   使用动态代理的主要目的就是能够对原方法进行扩展，尤其是对于大部分方法都具有的重复方法(例如记录日志)，
         *                                  可以理解为面向切面编程中的增强.
         * JDK动态代理缺点：只能为接口创建代理，返回的代理对象也只能转到某个接口类型
         */
        User proxy = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), dynamicProxy);
        proxy.work();
        proxy.play();
        System.out.println(proxy.getClass());
        System.out.println("--------------------------------------------");

        UserImpl userPlay = new UserImpl();
        ProxyFactory proxyFactory = new ProxyFactory(userPlay);
        User user1 = (User) proxyFactory.getProxyInstance();
        user1.work();
        user1.play();

    }
}
