package com.mapper;

import com.po.User;

/**
 * @Author: 赵博林
 * @Date:2020/2/20 18:53
 * @Description:
 * @Param：
 * @return ：
 */
public interface UserMapper {
    Integer testuser();

    //注册账号
    void registUser(User user);

    //判断是否注册
    int isRegist(String user_phone);

    //登录
    User login(String user_phone);
}
