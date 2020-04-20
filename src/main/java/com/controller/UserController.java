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
        System.out.println("我是测试代码");
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

    //修改个人信息
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateUser(User user) throws Exception{
        Map<String,Object> map = userService.updateUser(user);
        return map;
    }

    //修改密码
    @RequestMapping(value = "updatepassword",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatepassword(User user) throws Exception{
        Map<String,Object> map = userService.updatepassword(user);
        return map;
    }

    //删除用户
    @RequestMapping(value = "delectuser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delectuser(Integer user_id) throws Exception{
        Map<String,Object> map = userService.delectuser(user_id);
        return map;
    }
}
