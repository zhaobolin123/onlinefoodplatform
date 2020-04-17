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
    Shop selectshopforbusiness(Integer business);

    //根据店铺id查询店铺
    Shop selectshopbyid(Integer shop_id);

    //根据状态查询店铺列表
    List<Shop> selectshopbystate(Integer shop_state);

    //模糊随机返回店铺
    List<Shop> selectshoprandom(String shop_name);

    //修改店铺信息
    void updateshopinfo(Shop shop);
}
