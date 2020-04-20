package com.mapper;

import com.po.Dishes;
import com.po.Shop;

import java.util.List;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface DishesMapper {

    //根据菜品id查询菜品
    Dishes selectDishesById(Integer dishes_id);

    //根据店铺id查询菜品列表
    List<Dishes> selectDishesList(Integer shop_id);

    //添加菜品
    void addDishes(Dishes dishes);

    //修改菜品信息
    void updatedishesinfo(Dishes dishes);

    //删除菜品
    void delectdishes(Integer dishes_id);
}
