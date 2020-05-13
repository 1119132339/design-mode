package com.design.mode.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Bird bird;

    public Object getInstance(Bird bird){
        //生成$Proxy0的class文件，也就是代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        this.bird = bird;
        Class<? extends Bird> clazz = bird.getClass();
        // 这里生成代理对象
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理");
        before();
        Object invoke = method.invoke(bird, args);
        after();
        return invoke;
    }
    private void before(){
        System.out.println("jdk before");
    }
    private void after(){
        System.out.println("jdk after");
    }

}
