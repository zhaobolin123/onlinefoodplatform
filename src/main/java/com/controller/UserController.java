package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
