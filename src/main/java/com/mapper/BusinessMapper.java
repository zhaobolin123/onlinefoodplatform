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
//    //根据id查询User
//    User selectuserbyid(Integer user_id);
//
//    //修改密码
//    void updatepassword(User user);
}
