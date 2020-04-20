package com.service;

import com.po.Receiving;
import java.util.Map;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface ReceivingService {

    //添加收货人
    Map<String,Object> addReceiving(Receiving receiving) throws Exception;

    //根据用户id收货人列表
    Map<String,Object> selectReceivingByUserId(Integer user_id) throws Exception;

    //根据收货人id查询收货人
    Map<String,Object> selectreceivingbyid(Integer receiving_id) throws Exception;

    //修改收货人信息
    Map<String,Object> updatereceivinginfo(Receiving receiving) throws Exception;

    //删除收货人
    Map<String,Object> delectreceiving(Integer receiving_id) throws Exception;
}
