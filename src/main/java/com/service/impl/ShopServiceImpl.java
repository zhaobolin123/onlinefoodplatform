package com.service.impl;

import com.mapper.ShopMapper;
import com.po.Shop;
import com.service.ShopService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.*;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
@Service("ShopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    //添加店铺
    @Override
    public Map<String, Object> addShop(Shop shop) throws Exception {
        Map<String,Object> map = new HashMap<>();
        double num = Math.random()*10;
        String dinstance;
        DecimalFormat df = new DecimalFormat( "0.000" );

        if (StringUtils.isEmpty(shop.getShop_name()) || Objects.equals("", shop.getShop_name())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(shop.getBusiness_id()) || Objects.equals("", shop.getBusiness_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                    dinstance = df.format(num);
                    shop.setDistance(dinstance);
                    shopMapper.addShop(shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //查询是否拥有店铺
    @Override
    public Map<String, Object> selectshopforbusiness(Integer business_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(business_id) || Objects.equals("", business_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Shop isShop = shopMapper.selectshopforbusiness(business_id);
                map.put("isShop",isShop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据状态查询店铺列表
    @Override
    public Map<String, Object> selectshopbystate(Integer shop_state) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Shop> shoplist = new ArrayList<Shop>();
        if (StringUtils.isEmpty(shop_state) || Objects.equals("", shop_state)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                shoplist = shopMapper.selectshopbystate(shop_state);
                map.put("shoplist",shoplist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //模糊随机返回店铺
    @Override
    public Map<String, Object> selectshoprandom(String shop_name) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Shop> shoplist = new ArrayList<Shop>();
        try {
            shoplist = shopMapper.selectshoprandom(shop_name);
            map.put("shoplist",shoplist);
        } catch (Exception e) {
            e.printStackTrace();
            return ResUtil.error(map,"005","异常,请联系管理员！");
        }

        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改店铺信息
    @Override
    public Map<String, Object> updateshopinfo(Shop shop) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(shop.getShop_id()) || Objects.equals("", shop.getShop_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                shopMapper.updateshopinfo(shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

//    //查询订单根据状态
//    @Override
//    public Map<String, Object> selectOrderByState(Order order) throws Exception {
//        Map<String,Object> map = new HashMap<>();
//        List<Order> orderlist = new ArrayList<Order>();
//
//        if (StringUtils.isEmpty(order.getUser_id()) || Objects.equals("", order.getUser_id())) {
//                return ResUtil.error(map,"001","传入参数不能为空!");
//        }
//        else if (StringUtils.isEmpty(order.getState()) || Objects.equals("", order.getState())) {
//            return ResUtil.error(map,"001","传入参数不能为空!");
//        }
//        else{
//            try {
//                orderlist = orderMapper.selectOrderByState(order);
//                map.put("order",orderlist);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return ResUtil.error(map,"005","异常,请联系管理员！");
//            }
//        }
//        return ResUtil.error(map,"000",ResUtil.SUCCESS);
//    }

}
