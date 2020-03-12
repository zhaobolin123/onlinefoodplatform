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

//    //修改个人信息
//    Map<String, Object> updateUser(User user) throws  Exception;



}
