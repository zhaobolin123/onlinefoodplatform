package com.po;

import java.util.Date;

/**
 * @Author: 赵博林
 * @Date:2020/3/16 19:34
 * @Description:
 * @Param：
 * @return ：
 */
public class Business {
    private Integer business_id;

    private String business_phone;

    private String business_password;

    private String contact_number;

    private String business_nickname;

    private String business_pic;

    private Integer isshop;

    private Date business_time;

    private Integer state;

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_phone() {
        return business_phone;
    }

    public void setBusiness_phone(String business_phone) {
        this.business_phone = business_phone;
    }

    public String getBusiness_password() {
        return business_password;
    }

    public void setBusiness_password(String business_password) {
        this.business_password = business_password;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getBusiness_nickname() {
        return business_nickname;
    }

    public void setBusiness_nickname(String business_nickname) {
        this.business_nickname = business_nickname;
    }

    public String getBusiness_pic() {
        return business_pic;
    }

    public void setBusiness_pic(String business_pic) {
        this.business_pic = business_pic;
    }

    public Integer getIsshop() {
        return isshop;
    }

    public void setIsshop(Integer isshop) {
        this.isshop = isshop;
    }

    public Date getBusiness_time() {
        return business_time;
    }

    public void setBusiness_time(Date business_time) {
        this.business_time = business_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
