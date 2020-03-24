package com.service;

import com.po.Order;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface OrderService {
    //添加订单
    Map<String,Object> addOrder(Order order) throws Exception;

    //修改订单状态
    Map<String, Object> updatestate(Order order) throws  Exception;

    //查询订单根据状态
    Map<String, Object> selectOrderByState(Order order) throws  Exception;


}
