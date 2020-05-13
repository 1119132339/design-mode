package com.design.mode.proxy.sta;

import java.io.Serializable;

public class OrderServiceImpl implements OrderService, Serializable {
    private OrderDao orderDao;

    public OrderServiceImpl(){
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("ordderService 调用 orderDao 创建订单");
        return orderDao.inert(order);
    }
}
