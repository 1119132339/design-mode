package com.design.mode.proxy.sta;

import com.design.mode.utils.DateUtils;

import java.util.Date;

public class OrderServiceStaticProxy implements OrderService{

    private OrderService orderService;

    public OrderServiceStaticProxy(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        String yyyy = DateUtils.format(new Date(), "yyyy");
        // 模拟动态切换数据库
        DynamicDataSourceEntry.set(Integer.valueOf(yyyy));
        int order1 = orderService.createOrder(order);

        after();
        return order1;
    }

    private void before(){
        System.out.println("proxy before method");
    }
    private void after(){
        System.out.println("proxy after method");
    }






}
