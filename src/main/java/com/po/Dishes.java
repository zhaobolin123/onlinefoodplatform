package com.po;

/**
* Author: 赵博林
* @Date 2020/3/12 19:55
* @Description: 
* @Param: 
* @return : 
*/
public class Dishes {
    private Integer dishes_id;
    private Integer shop_id;
    private String dishname;
    private Integer sales_volume;
    private Double score;
    private String dishes_pic;
    private Double dishes_price;
    private String material;

    public Integer getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Integer dishes_id) {
        this.dishes_id = dishes_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDishes_pic() {
        return dishes_pic;
    }

    public void setDishes_pic(String dishes_pic) {
        this.dishes_pic = dishes_pic;
    }

    public Double getDishes_price() {
        return dishes_price;
    }

    public void setDishes_price(Double dishes_price) {
        this.dishes_price = dishes_price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
