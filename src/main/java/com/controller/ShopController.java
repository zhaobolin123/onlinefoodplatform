package com.controller;

import com.po.Shop;
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
public class ShopController {
    @Autowired
    private ShopService shopService;


    //添加订单
    @RequestMapping(value = "addShop",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addShop(Shop shop) throws Exception{
        Map<String,Object> map = shopService.addShop(shop);
        return map;
    }

    //查询是否拥有店铺
    @RequestMapping(value = "selectshopforbusiness",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectshopforbusiness(Integer business_id) throws Exception{
        Map<String,Object> map = shopService.selectshopforbusiness(business_id);
        return map;
    }
//    //查询订单根据状态
//    @RequestMapping(value = "selectOrderByState",method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String,Object> selectOrderByState(Order order) throws Exception{
//        Map<String,Object> map = orderService.selectOrderByState(order);
//        return map;
//}
//
//    //修改订单状态
//    @RequestMapping(value = "updatestate",method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String,Object> updatestate(Order order) throws Exception{
//        Map<String,Object> map = orderService.updatestate(order);
//        return map;
//    }
}
