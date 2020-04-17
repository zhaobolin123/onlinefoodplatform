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

    //修改店铺信息
    Map<String, Object> updateshopinfo(Shop shop) throws  Exception;

    //根据状态查询店铺列表
    Map<String, Object> selectshopbystate(Integer shop_state) throws  Exception;

    //模糊随机返回店铺
    Map<String, Object> selectshoprandom(String shop_name) throws  Exception;

    //查询是否拥有店铺
    Map<String, Object> selectshopforbusiness(Integer business_id) throws  Exception;

    //根据店铺id查询店铺
    Map<String, Object> selectshopbyid(Integer shop_id) throws  Exception;
}
