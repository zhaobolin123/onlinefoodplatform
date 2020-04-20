package com.service.impl;

import com.mapper.ReceivingMapper;
import com.po.Receiving;
import com.service.ReceivingService;
import com.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.*;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
@Service("ReceivingService")
public class ReceivingServiceImpl implements ReceivingService {

    @Autowired
    private ReceivingMapper receivingMapper;


    //添加收货人
    @Override
    public Map<String, Object> addReceiving(Receiving receiving) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(receiving.getUser_id()) || Objects.equals("", receiving.getUser_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                    receivingMapper.addReceiving(receiving);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据收货人id查询收货人
    @Override
    public Map<String, Object> selectreceivingbyid(Integer receiving_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(receiving_id) || Objects.equals("", receiving_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                Receiving receiving = receivingMapper.selectreceivingbyid(receiving_id);
                map.put("receiving",receiving);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //根据用户id收货人列表
    @Override
    public Map<String, Object> selectReceivingByUserId(Integer user_id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Receiving> receivinglist = new ArrayList<Receiving>();
        if (StringUtils.isEmpty(user_id) || Objects.equals("", user_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                receivinglist = receivingMapper.selectReceivingByUserId(user_id);
                map.put("receivinglist",receivinglist);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //修改收货人信息
    @Override
    public Map<String, Object> updatereceivinginfo(Receiving receiving) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(receiving.getReceiving_id()) || Objects.equals("", receiving.getReceiving_id())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                receivingMapper.updatereceivinginfo(receiving);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    //删除收货人
    @Override
    public Map<String, Object> delectreceiving(Integer receiving_id) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(receiving_id) || Objects.equals("", receiving_id)) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                receivingMapper.delectreceiving(receiving_id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

}
