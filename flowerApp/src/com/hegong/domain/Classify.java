package com.hegong.domain;

import java.util.PrimitiveIterator;

public class Classify {
    private int id;
    private String c_name;
    private String content;
    private Double money;
    private String img_url;

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", c_name='" + c_name + '\'' +
                ", content='" + content + '\'' +
                ", money=" + money +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
