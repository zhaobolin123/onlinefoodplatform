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

    //根据状态查询店铺列表
    @RequestMapping(value = "selectshopbystate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectshopbystate(Integer shop_state) throws Exception{
        Map<String,Object> map = shopService.selectshopbystate(shop_state);
        return map;
    }

    //模糊随机返回店铺
    @RequestMapping(value = "selectshoprandom",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectshoprandom(String shop_name) throws Exception{
        Map<String,Object> map = shopService.selectshoprandom(shop_name);
        return map;
    }

    //修改店铺信息
    @RequestMapping(value = "updateshopinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateshopinfo(Shop shop) throws Exception{
        Map<String,Object> map = shopService.updateshopinfo(shop);
        return map;
    }
}
