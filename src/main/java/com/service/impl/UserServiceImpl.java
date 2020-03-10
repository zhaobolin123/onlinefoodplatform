package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.po.User;
import com.service.UserService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //注册
    @Override
    public Map<String, Object> registUser(User user) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(user.getUser_phone()) || Objects.equals("", user.getUser_phone())) {
            if (StringUtils.isEmpty(user.getUser_password()) || Objects.equals("", user.getUser_password())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        }
        else{
            try {
                if (0!=userMapper.isRegist(user.getUser_phone())){
                    return ResUtil.error(map,"002","手机号已被注册！");
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                user.setUser_time(nowDate);

                userMapper.registUser(user);
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //登录
    @Override
    public Map<String, Object> login(String user_phone) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(user_phone) || Objects.equals("",user_phone)) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                    User user = userMapper.login(user_phone);
                    map.put("user",user);
            } catch (Exception e) {
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
