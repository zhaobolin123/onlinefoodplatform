package com.service.impl;

import com.mapper.OrderMapper;
import com.po.Order;
import com.service.OrderService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    //添加订单
    @Override
    public Map<String, Object> addOrder(Order order) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(order.getUser_id()) || Objects.equals("", order.getUser_id())) {
            if (StringUtils.isEmpty(order.getDishes_id()) || Objects.equals("", order.getDishes_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        }
        else{
            try {
                orderMapper.addOrder(order);
            } catch (Exception e) {
                System.out.println(e);
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

}
