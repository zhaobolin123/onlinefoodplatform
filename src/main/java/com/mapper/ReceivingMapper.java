package com.mapper;

import com.po.Receiving;

import java.util.List;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public interface ReceivingMapper {

    //添加收货人
    void addReceiving(Receiving receiving);

    //根据用户id收货人列表
    List<Receiving> selectReceivingByUserId(Integer user_id);

    //根据收货人id查询收货人
    Receiving selectreceivingbyid(Integer receiving_id);

    //修改收货人信息
    void updatereceivinginfo(Receiving receiving);

    //删除收货人
    void delectreceiving(Integer receiving_id);
}
