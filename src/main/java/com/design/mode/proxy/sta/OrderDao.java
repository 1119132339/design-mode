package com.design.mode.proxy.sta;

import java.io.Serializable;

public class OrderDao  implements Serializable {

    public int inert (Order order){
        System.out.println("orderDao 创建 order成功");
        return 1;
    }
}
