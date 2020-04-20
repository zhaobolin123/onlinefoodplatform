package com.controller;

import com.po.Dishes;
import com.po.Shop;
import com.service.DishesService;
import com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 20:07
* @Description:
* @Param:
* @return :
*/
@Controller
public class DishesController {
    @Autowired
    private DishesService dishesService;

    //根据菜品id查询菜品
    @RequestMapping(value = "selectDishesById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectDishesById(Integer dishes_id) throws Exception{
        Map<String,Object> map = dishesService.selectDishesById(dishes_id);
        return map;
    }

    //根据店铺id查询菜品列表
    @RequestMapping(value = "selectDishesList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectDishesList(Integer shop_id) throws Exception{
        Map<String,Object> map = dishesService.selectDishesList(shop_id);
        return map;
    }

    //添加菜品
    @RequestMapping(value = "addDishes",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addDishes(Dishes dishes) throws Exception{
        Map<String,Object> map = dishesService.addDishes(dishes);
        return map;
    }

    //修改菜品信息
    @RequestMapping(value = "updatedishesinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatedishesinfo(Dishes dishes) throws Exception{
        Map<String,Object> map = dishesService.updatedishesinfo(dishes);
        return map;
    }

    //删除菜品
    @RequestMapping(value = "delectdishes",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delectdishes(Integer dishes_id) throws Exception{
        Map<String,Object> map = dishesService.delectdishes(dishes_id);
        return map;
    }
}
