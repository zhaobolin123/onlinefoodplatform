package com.controller;

import com.po.Business;
import com.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 20:07
* @Description:
* @Param:
* @return :
*/
@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    //注册商家
    @RequestMapping(value = "addbusiness",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addOrder(Business business) throws Exception{
        Map<String,Object> map = businessService.addbusiness(business);
        return map;
    }
    //商家登录
    @RequestMapping(value = "busineslogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> businesslogin(Business business) throws Exception{
        Map<String,Object> map = businessService.businesslogin(business);
        return map;
    }

    //修改商家信息
    @RequestMapping(value = "updatebusinessinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatebusinessinfo(Business business) throws Exception{
        Map<String,Object> map = businessService.updatebusinessinfo(business);
        return map;
    }
}
