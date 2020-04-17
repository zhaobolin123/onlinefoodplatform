package com.service.impl;

import com.mapper.DishesMapper;
import com.po.Dishes;
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

}
