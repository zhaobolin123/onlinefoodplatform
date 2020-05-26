package com.mapper;

import com.po.Business;

/**
* Author: 赵博林
* @Date 2020/3/16 19:48
* @Description: 
* @Param: 
* @return : 
*/
public interface BusinessMapper {

    //注册商家
    void addbusiness(Business business);

    //判断是否注册
    int isRegist(String business_phone);

    //商家登录
    Business businesslogin(Business business);

    //修改商家信息
    void updatebusinessinfo(Business business);

    //根据id查询商家信息
    Business selectById(Integer business_id);
}
