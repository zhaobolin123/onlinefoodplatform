package com.po;

public class OrderDishes {
    private Integer orderdishes_id;
    private Integer order_id;
    private Integer dishes_id;
    private Integer orderdishes_number;
    private String dishesname;

    public String getDishesname() {
        return dishesname;
    }

    public void setDishesname(String dishesname) {
        this.dishesname = dishesname;
    }

    public Integer getOrderdishes_id() {
        return orderdishes_id;
    }

    public void setOrderdishes_id(Integer orderdishes_id) {
        this.orderdishes_id = orderdishes_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Integer dishes_id) {
        this.dishes_id = dishes_id;
    }

    public Integer getOrderdishes_number() {
        return orderdishes_number;
    }

    public void setOrderdishes_number(Integer orderdishes_number) {
        this.orderdishes_number = orderdishes_number;
    }
}
