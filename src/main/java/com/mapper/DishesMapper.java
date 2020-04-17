package com.mapper;

import com.po.Dishes;

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

}
