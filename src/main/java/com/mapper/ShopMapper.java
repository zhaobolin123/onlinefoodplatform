package com.mapper;

import com.po.Order;
import com.po.Shop;

import java.util.List;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface ShopMapper {

    //添加店铺
    void addShop(Shop shop);

    //查询是否拥有店铺
    Integer selectshopforbusiness(Integer business);

    //根据状态查询订单
    List<Order> selectOrderByState(Order order);

    //修改订单状态
    void updatestate(Order order);
}
