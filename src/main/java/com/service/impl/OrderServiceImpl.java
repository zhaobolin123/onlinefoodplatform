package com.service.impl;

import com.mapper.DishesMapper;
import com.mapper.OrderMapper;
import com.mapper.ShopMapper;
import com.mapper.UserMapper;
import com.po.Dishes;
import com.po.Order;
import com.po.Shop;
import com.po.User;
import com.service.OrderService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private ShopMapper shopMapper;

    //添加订单
    @Override
    public Map<String, Object> addOrder(Order order) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(order.getUser_id()) || Objects.equals("", order.getUser_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(order.getDishes_id()) || Objects.equals("", order.getDishes_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                orderMapper.addOrder(order);
                Dishes dishes = dishesMapper.selectDishesById(order.getDishes_id());
                dishes.setSales_volume(dishes.getSales_volume()+order.getNumber());
                dishesMapper.updatedishesinfo(dishes);
                Shop shop = shopMapper.selectshopbyid(dishes.getShop_id());
                shop.setShop_sales(shop.getShop_sales()+order.getNumber());
                shopMapper.updateshopinfo(shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改订单状态
    @Override
    public Map<String, Object> updatestate(Order order) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(order.getOrder_id()) || Objects.equals("", order.getOrder_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else
        if (StringUtils.isEmpty(order.getState()) || Objects.equals("", order.getState())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                orderMapper.updatestate(order);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //查询订单根据状态
    @Override
    public Map<String, Object> selectOrderByState(Order order) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Order> orderlist = new ArrayList<Order>();

        if (StringUtils.isEmpty(order.getUser_id()) || Objects.equals("", order.getUser_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                orderlist = orderMapper.selectOrderByState(order);
                map.put("order",orderlist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据order_id查询订单列表
    @Override
    public Map<String, Object> selectOrderById(Integer order_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Order order;
        User user;
        Dishes dishes;
        Shop shop;

        if (StringUtils.isEmpty(order_id) || Objects.equals("", order_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                order = orderMapper.selectOrderById(order_id);
                map.put("order",order);
                user = userMapper.selectuserbyid(order.getUser_id());
                map.put("user",user);
                dishes = dishesMapper.selectDishesById(order.getDishes_id());
                map.put("dishes",dishes);
                shop = shopMapper.selectshopbyid(dishes.getShop_id());
                map.put("shop",shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
