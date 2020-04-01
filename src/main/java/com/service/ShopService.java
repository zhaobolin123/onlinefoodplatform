package com.service;

import com.po.Order;
import com.po.Shop;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface ShopService {
    //添加店铺
    Map<String,Object> addShop(Shop shop) throws Exception;

//    //修改订单状态
//    Map<String, Object> updatestate(Order order) throws  Exception;
//
//    //查询订单根据状态
//    Map<String, Object> selectOrderByState(Order order) throws  Exception;

    //查询是否拥有店铺
    Map<String, Object> selectshopforbusiness(Integer business_id) throws  Exception;


}
