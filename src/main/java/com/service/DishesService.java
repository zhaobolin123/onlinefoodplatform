package com.service;

import com.po.Business;
import com.po.Dishes;
import com.po.Shop;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/16 19:48
* @Description:
* @Param:
* @return :
*/
public interface DishesService {
    //根据菜品id查询菜品
    Map<String,Object> selectDishesById(Integer dishes_id) throws Exception;

    //根据店铺id查询菜品列表
    Map<String,Object> selectDishesList(Integer shop_id) throws Exception;

    //添加菜品
    Map<String,Object> addDishes(Dishes dishes) throws Exception;

    //修改菜品信息
    Map<String, Object> updatedishesinfo(Dishes dishes) throws  Exception;

    //删除菜品
    Map<String,Object> delectdishes(Integer dishes_id) throws Exception;
}
