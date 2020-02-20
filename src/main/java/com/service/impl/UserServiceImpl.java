package com.service.impl;

import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 赵博林
 * @Date:2020/2/20 19:04
 * @Description:
 * @Param：
 * @return ：
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer testUser()throws Exception{
        return userMapper.testuser();
    }
}
