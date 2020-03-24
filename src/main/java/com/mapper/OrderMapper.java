package com.mapper;

import com.po.Order;

import java.util.List;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface OrderMapper {

    //添加订单
    void addOrder(Order order);

    //根据状态查询订单
    List<Order> selectOrderByState(Order order);

    //修改订单状态
    void updatestate(Order order);
}
