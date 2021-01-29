package com.hegong.service;

import com.hegong.dao.FlowerDao;
import com.hegong.domain.Classify;
import com.hegong.domain.Commodity;
import com.hegong.domain.User;
import com.hegong.domain.YouLike;

import java.util.ArrayList;
import java.util.List;

public class FlowerService {

    FlowerDao cd = new FlowerDao();
    public List<Classify> getClassifyMsg(){
        List<String> c_names = new ArrayList<>();
        return cd.selectAll();
    }


    public List<Classify> getSelectMsg(String key) {
        return cd.selectOnes(key);
    }

    FlowerDao flowerDao = new FlowerDao();
    public List<YouLike> getLikeShopMsg() {
        return flowerDao.selectLikeAll();
    }
    public int getTypesCount(){
        return  flowerDao.typesCount();
    }

    public List<Commodity> getBuyCarList() {
        List<Commodity> commodityList = flowerDao.getCommodityList();
        for (Commodity c : commodityList) {
            int id = c.getId();
            int count = flowerDao.selectCount(id);
            c.setCount(count);
        }
        return commodityList;
    }

    public boolean isUser(String username, String pwd) {
        User user = flowerDao.seletcUser(username);
        if (user != null) {
            String true_pwd = user.getPwd();
            if (true_pwd.equals(pwd)) {
                return true;
            }
        }
        return false;
    }
}
