package com.service.impl;

import com.mapper.DishesMapper;
import com.mapper.ShopMapper;
import com.po.Dishes;
import com.po.Shop;
import com.service.DishesService;
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
@Service("DishesService")
public class DishesServiceImpl implements DishesService {

    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private ShopMapper shopMapper;

    //根据菜品id查询菜品
    @Override
    public Map<String, Object> selectDishesById(Integer dishes_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Dishes dishes;

        if (StringUtils.isEmpty(dishes_id) || Objects.equals("", dishes_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                dishes = dishesMapper.selectDishesById(dishes_id);
                map.put("dishes",dishes);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据店铺id查询菜品列表
    @Override
    public Map<String, Object> selectDishesList(Integer shop_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Dishes> disheslist;
        Shop shop;

        if (StringUtils.isEmpty(shop_id) || Objects.equals("", shop_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                disheslist = dishesMapper.selectDishesList(shop_id);
                shop = shopMapper.selectshopbyid(shop_id);
                map.put("disheslist",disheslist);
                map.put("shop",shop);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //添加菜品
    @Override
    public Map<String, Object> addDishes(Dishes dishes) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(dishes.getDishname()) || Objects.equals("", dishes.getDishname())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(dishes.getShop_id()) || Objects.equals("", dishes.getShop_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                dishesMapper.addDishes(dishes);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改菜品信息
    @Override
    public Map<String, Object> updatedishesinfo(Dishes dishes) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(dishes.getDishes_id()) || Objects.equals("", dishes.getDishes_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                dishesMapper.updatedishesinfo(dishes);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //删除菜品
    @Override
    public Map<String, Object> delectdishes(Integer dishes_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(dishes_id) || Objects.equals("", dishes_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                dishesMapper.delectdishes(dishes_id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
