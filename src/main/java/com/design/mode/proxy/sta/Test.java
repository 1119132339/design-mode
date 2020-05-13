package com.design.mode.proxy.sta;

public class Test {
    public static void main(String[] args) {
        // 需要代理的对象
        OrderService orderService = new OrderServiceImpl();
        // 代理类
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(orderService);

        Order order = new Order("1", "orderInfo");
        proxy.createOrder(order);

    }
}
