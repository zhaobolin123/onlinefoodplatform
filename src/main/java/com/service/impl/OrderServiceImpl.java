package com.service.impl;

import com.dto.OrderDTO;
import com.mapper.*;
import com.po.*;
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
    @Autowired
    private OrderDishesMapper orderDishesMapper;

    //添加订单
    @Override
    public Map<String, Object> addOrder(OrderDTO orderDTO) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Order order = new Order();
        List<OrderDishes> orderDishesList;

        if (StringUtils.isEmpty(orderDTO.getUser_id()) || Objects.equals("", orderDTO.getUser_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(orderDTO.getShop_id()) || Objects.equals("", orderDTO.getShop_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(orderDTO.getOrderDishesList()) || Objects.equals("", orderDTO.getOrderDishesList())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                orderMapper.addOrder(orderDTO);
                int id = orderDTO.getOrder_id();
                orderDishesList = orderDTO.getOrderDishesList();
                for (OrderDishes orderDishes : orderDishesList){
                    orderDishes.setOrder_id(id);
                    orderDishesMapper.addOrderDishes(orderDishes);
                    Dishes dishes = dishesMapper.selectDishesById(orderDishes.getDishes_id());
                    dishes.setSales_volume(dishes.getSales_volume()+orderDishes.getOrderdishes_number());
                    dishesMapper.updatedishesinfo(dishes);
                    Shop shop = shopMapper.selectshopbyid(dishes.getShop_id());
                    shop.setShop_sales(shop.getShop_sales()+orderDishes.getOrderdishes_number());
                    shopMapper.updateshopinfo(shop);
                }
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
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        List<OrderDishes> orderDisheslist;

        if (StringUtils.isEmpty(order.getUser_id()) || Objects.equals("", order.getUser_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                orderlist = orderMapper.selectOrderByState(order);
                for (Order ordermap : orderlist){
                    orderDisheslist = orderDishesMapper.selectOrderDishes(ordermap.getOrder_id());
                    for (OrderDishes orderDishes : orderDisheslist){
                        String name = dishesMapper.selectDishesById(orderDishes.getDishes_id()).getDishname();
                        orderDishes.setDishesname(name);
                    }
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setOrder_id(ordermap.getOrder_id());
                    orderDTO.setUser_id(ordermap.getUser_id());
                    orderDTO.setShop_id(ordermap.getShop_id());
                    orderDTO.setState(ordermap.getState());
                    orderDTO.setRemark(ordermap.getRemark());
                    orderDTO.setTableware_number(ordermap.getTableware_number());
                    orderDTO.setConsignee_phone(ordermap.getConsignee_phone());
                    orderDTO.setConsignee_address(ordermap.getConsignee_address());
                    orderDTO.setOrderDishesList(orderDisheslist);
                    orderDTO.setShopname(shopMapper.selectshopbyid(orderDTO.getShop_id()).getShop_name());
                    list.add(orderDTO);
                }
                map.put("orderDTO",list);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据order_id查询订单
    @Override
    public Map<String, Object> selectOrderById(Integer order_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Order order;
        User user;
        Dishes dishes;
        Shop shop;
        List<OrderDishes> orderDisheslist;
        List<Dishes> dishesList = new ArrayList<Dishes>();

        if (StringUtils.isEmpty(order_id) || Objects.equals("", order_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                order = orderMapper.selectOrderById(order_id);
                map.put("order",order);
                orderDisheslist = orderDishesMapper.selectOrderDishes(order.getOrder_id());
                map.put("orderDisheslist",orderDisheslist);
                user = userMapper.selectuserbyid(order.getUser_id());
                map.put("user",user);
                for (OrderDishes orderDishes : orderDisheslist){
                    dishes = dishesMapper.selectDishesById(orderDishes.getDishes_id());
                    dishesList.add(dishes);
                }
                map.put("dishesList",dishesList);
                shop = shopMapper.selectshopbyid(order.getShop_id());
                map.put("shop",shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
