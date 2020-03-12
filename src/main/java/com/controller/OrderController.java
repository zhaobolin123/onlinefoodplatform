package com.controller;

import com.po.Order;
import com.service.OrderService;
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
public class OrderController {
    @Autowired
    private OrderService orderService;


    //添加订单
    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addOrder(Order order) throws Exception{
        Map<String,Object> map = orderService.addOrder(order);
        return map;
    }

}
