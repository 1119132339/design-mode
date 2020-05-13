package com.design.mode.proxy.dynamic;

public class Test2 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        // 静态代理
        StaticProxy staticProxy = new StaticProxy(bird);
        staticProxy.dosomething();
        // jdk动态代理
        Animal proxy = (Animal) new JDKProxy().getInstance(bird);
        proxy.dosomething();
        // cglib动态代理
        Animal instance = new CglibProxy().getInstance(Bird.class);
        instance.dosomething();
    }
}
