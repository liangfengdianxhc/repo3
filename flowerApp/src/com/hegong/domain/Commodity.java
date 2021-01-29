package com.hegong.domain;

public class Commodity {
    private int id;
    private int count;
    private String name;
    private String imgUrl;


    private int price;

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                '}';
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
