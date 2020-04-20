package com.service;

import com.po.User;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/2/20 19:03
 * @Description:
 * @Param：
 * @return ：
 */
public interface UserService {
    Integer testUser() throws Exception;

    //注册
    Map<String,Object> registUser(User user) throws Exception;

    //登录
    Map<String, Object> login(User user) throws  Exception;

    //修改个人信息
    Map<String, Object> updateUser(User user) throws  Exception;

    //修改密码
    Map<String, Object> updatepassword(User user) throws  Exception;

    //删除用户
    Map<String, Object> delectuser(Integer user_id) throws  Exception;
}
