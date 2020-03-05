package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.po.User;
import com.service.UserService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public Map<String, Object> registUser(String params) throws Exception {
        Map<String,Object> map = new HashMap<>();
        JSONObject req = JSONObject.parseObject(params);
        User user = new User();
        if (StringUtils.isEmpty(params) || Objects.equals("", params)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                String userphone = req.getString("userphone");
                String password = req.getString("password");
                user.setUser_phone(userphone);
                user.setUser_password(password);
                userMapper.regisgtUser(user);
            } catch (Exception e) {

                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }


}
