package com.design.mode.proxy.dynamic;

import com.design.mode.proxy.sta.DynamicDataSourceEntry;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy2   implements InvocationHandler ,Serializable {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invo");
        before(args[0]);
        Object object = method.invoke(target,args);
        after();
        return object;
    }
    private void before(Object obj){
        try {
            System.out.println("Proxy before method.");
//            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
//            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
//            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】 数据源处理数据。 ");
//            DynamicDataSourceEntry.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void after(){
        System.out.println("Proxy after method.");
    }

}
