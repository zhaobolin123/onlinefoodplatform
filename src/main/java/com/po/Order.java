package com.po;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public class Order {
    private Integer order_id;
    private Integer user_id;
    private Integer dishes_id;
    private Integer state;
    private Integer number;
    private String remark;
    private Integer tableware_number;
    private String consignee_phone;
    private String consignee_address;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Integer dishes_id) {
        this.dishes_id = dishes_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTableware_number() {
        return tableware_number;
    }

    public void setTableware_number(Integer tableware_number) {
        this.tableware_number = tableware_number;
    }

    public String getConsignee_phone() {
        return consignee_phone;
    }

    public void setConsignee_phone(String consignee_phone) {
        this.consignee_phone = consignee_phone;
    }

    public String getConsignee_address() {
        return consignee_address;
    }

    public void setConsignee_address(String consignee_address) {
        this.consignee_address = consignee_address;
    }
}
