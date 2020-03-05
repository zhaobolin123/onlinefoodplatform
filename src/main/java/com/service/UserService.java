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
    Map<String,Object> registUser(String params) throws Exception;

}
