package com.design.mode.proxy.dynamic;

import com.design.mode.proxy.sta.Order;
import com.design.mode.proxy.sta.OrderService;
import com.design.mode.proxy.sta.OrderServiceImpl;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // 需要代理的对象
        OrderService orderService = new OrderServiceImpl();
        Order order = new Order("1", "orderInfo");


        // 代理类
//        OrderServiceDynamicProxy proxy = new OrderServiceDynamicProxy();
//        OrderService instance = (OrderService) proxy.getInstance(orderService);

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 代理类
        OrderServiceDynamicProxy2 proxy = new OrderServiceDynamicProxy2();
        OrderService instance = (OrderService) proxy.getInstance(orderService);

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = null;
//        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(proxy);
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        FileOutputStream outputStream = new FileOutputStream(new File("d:/OrderServiceDynamicProxy2.class"));
//        outputStream.write(bytes);




        instance.createOrder(order);

    }
}
