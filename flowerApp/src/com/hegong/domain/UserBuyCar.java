package com.hegong.domain;

public class UserBuyCar {
    private int id;
    private String shop_name;
    private String shop_imgUrl;
    private int shop_count;

    @Override
    public String toString() {
        return "UserBuyCar{" +
                "id=" + id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_imgUrl='" + shop_imgUrl + '\'' +
                ", shop_count=" + shop_count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_imgUrl() {
        return shop_imgUrl;
    }

    public void setShop_imgUrl(String shop_imgUrl) {
        this.shop_imgUrl = shop_imgUrl;
    }

    public int getShop_count() {
        return shop_count;
    }

    public void setShop_count(int shop_count) {
        this.shop_count = shop_count;
    }
}
