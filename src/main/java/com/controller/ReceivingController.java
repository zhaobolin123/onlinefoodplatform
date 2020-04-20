package com.controller;

import com.po.Receiving;
import com.service.ReceivingService;
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
public class ReceivingController {
    @Autowired
    private ReceivingService receivingService;


    //添加收货人
    @RequestMapping(value = "addReceiving",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addReceiving(Receiving receiving) throws Exception{
        Map<String,Object> map = receivingService.addReceiving(receiving);
        return map;
    }

    //根据用户id收货人列表
    @RequestMapping(value = "selectReceivingByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectReceivingByUserId(Integer user_id) throws Exception{
        Map<String,Object> map = receivingService.selectReceivingByUserId(user_id);
        return map;
    }

    //根据收货人id查询收货人
    @RequestMapping(value = "selectreceivingbyid",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectreceivingbyid(Integer receiving_id) throws Exception{
        Map<String,Object> map = receivingService.selectreceivingbyid(receiving_id);
        return map;
    }

    //修改收货人信息
    @RequestMapping(value = "updatereceivinginfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updatereceivinginfo(Receiving receiving) throws Exception{
        Map<String,Object> map = receivingService.updatereceivinginfo(receiving);
        return map;
    }

    //删除收货人
    @RequestMapping(value = "delectreceiving",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delectreceiving(Integer receiving_id) throws Exception{
        Map<String,Object> map = receivingService.delectreceiving(receiving_id);
        return map;
    }

}
