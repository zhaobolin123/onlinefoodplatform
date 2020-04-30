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
public interface OrderDishesMapper {

    //添加关联
    void addOrderDishes(OrderDishes orderDishes);

    //根据状态查询订单
    List<OrderDishes> selectOrderDishes(Integer order_id);

}
