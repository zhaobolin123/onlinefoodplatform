package com.controller;

import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 赵博林
 * @Date:2020/2/20 19:11
 * @Description:
 * @Param：
 * @return ：
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testUser() throws Exception{
        userService.testUser();
        return "jsp/index";
    }
    //注册
    @RequestMapping(value = "regist",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> regist(User user) throws Exception{
        Map<String,Object> map = userService.registUser(user);
        return map;
    }

    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(User user) throws Exception{
        Map<String,Object> map = userService.login(user);
        return map;
    }
}
