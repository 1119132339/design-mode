package com.design.mode.proxy.dynamic;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public Animal getInstance(Class<?> clazz){
        // 输出生成的代理类 方便理解原理
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "c:/");
        // 创建 增强器  类似JDK的proxy类
        Enhancer enhancer = new Enhancer();
        // 设置目标类
        enhancer.setSuperclass(clazz);
        // 设置回调函数  也就是实现了MethodInterceptor接口的类
        enhancer.setCallback(this);
        // 创建代理类
        Animal o = (Animal) enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理");
        before();
        Object o1 = methodProxy.invokeSuper(o, objects);
        after();
        return o1;
    }

    private void before(){
        System.out.println("cglib Proxy before method.");
    }
    private void after(){
        System.out.println("cglib Proxy after method.");
    }
}
