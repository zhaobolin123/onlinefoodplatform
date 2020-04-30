package com.controller;

import com.dto.OrderDTO;
import com.po.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Map<String,Object> addOrder(@RequestBody OrderDTO orderDTO) throws Exception{
        Map<String,Object> map = orderService.addOrder(orderDTO);
        return map;
    }

    //查询订单根据状态
    @RequestMapping(value = "selectOrderByState",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectOrderByState(Order order) throws Exception{
        Map<String,Object> map = orderService.selectOrderByState(order);
        return map;
    }

    //修改订单状态
    @RequestMapping(value = "updatestate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatestate(Order order) throws Exception{
        Map<String,Object> map = orderService.updatestate(order);
        return map;
    }

    //根据order_id查询订单列表
    @RequestMapping(value = "selectOrderById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectOrderById(Integer order_id) throws Exception{
        Map<String,Object> map = orderService.selectOrderById(order_id);
        return map;
    }
}
