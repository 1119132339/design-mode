package com.design.mode.proxy.dynamic;

import com.design.mode.proxy.sta.DynamicDataSourceEntry;
import com.design.mode.utils.DateUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke");
        before();
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(){
        System.out.println("proxy before method");
    }
    private void after(){
        System.out.println("proxy after method");
    }

}
