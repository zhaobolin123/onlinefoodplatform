package com.service;

import com.po.Business;
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



}
