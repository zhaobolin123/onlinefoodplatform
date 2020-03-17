package com.service;

import com.po.Business;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/16 19:48
* @Description:
* @Param:
* @return :
*/
public interface BusinessService {
    //注册商家
    Map<String,Object> addbusiness(Business business) throws Exception;

    //商家登录
    Map<String, Object> businesslogin(Business business) throws  Exception;
//    //修改个人信息
//    Map<String, Object> updateUser(User user) throws  Exception;



}
