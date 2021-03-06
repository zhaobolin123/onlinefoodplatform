package com.mapper;

import com.dto.OrderDTO;
import com.po.Order;
import com.po.OrderDishes;

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
    int addOrder(OrderDTO orderDTO);

    //根据状态查询订单
    List<Order> selectOrderByState(Order order);

    //修改订单状态
    void updatestate(Order order);

    //根据order_id查询订单列表
    Order selectOrderById(Integer order_id);
}
