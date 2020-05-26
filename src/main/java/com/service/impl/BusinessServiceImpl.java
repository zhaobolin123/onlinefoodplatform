package com.service.impl;

import com.mapper.BusinessMapper;
import com.po.Business;
import com.po.Order;
import com.service.BusinessService;
import com.service.OrderService;
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
* Author: 赵博林
* @Date 2020/3/16 19:49
* @Description:
* @Param:
* @return :
*/
@Service("BusinessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    //注册商家
    @Override
    public Map<String, Object> addbusiness(Business business) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(business.getBusiness_phone()) || Objects.equals("", business.getBusiness_phone())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(business.getBusiness_password()) || Objects.equals("", business.getBusiness_password())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                if (0!=businessMapper.isRegist(business.getBusiness_phone())){
                    return ResUtil.error(map,"002","手机号已被注册！");
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowdayTime = dateFormat.format(new Date());
                Date nowDate = dateFormat.parse(nowdayTime);
                business.setBusiness_time(nowDate);

                businessMapper.addbusiness(business);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    @Override
    public Map<String, Object> businesslogin(Business business) throws Exception {
        Map<String,Object> map = new HashMap<>();

        if (StringUtils.isEmpty(business.getBusiness_phone()) || Objects.equals("",business.getBusiness_phone())) {
                return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else if (StringUtils.isEmpty(business.getBusiness_password()) || Objects.equals("",business.getBusiness_password())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                if(null== businessMapper.businesslogin(business)){
                    return ResUtil.error(map,"003","账号或密码错误！");
                }
                else{
                    Business businessmap = businessMapper.businesslogin(business);
                    map.put("business",businessmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }

    @Override
    public Map<String, Object> updatebusinessinfo(Business business) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Business businessInfo;

        if (StringUtils.isEmpty(business.getBusiness_id()) || Objects.equals("",business.getBusiness_id())) {
            return ResUtil.error(map,"001","传入参数不能为空!");
        }
        else{
            try {
                businessMapper.updatebusinessinfo(business);
                businessInfo = businessMapper.selectById(business.getBusiness_id());
                map.put("businessInfo", businessInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return ResUtil.error(map,"005","异常,请联系管理员！");
            }
        }
        return ResUtil.error(map,"000",ResUtil.SUCCESS);
    }
}
