package com.design.mode.proxy.sta;

import lombok.Data;

@Data
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;

    private Order(){}


    public Order(String id,Object orderInfo){
        this.id = id;
        this.createTime = System.currentTimeMillis();
        this.orderInfo = orderInfo;
    }
}
