package com.hegong.test;

import com.hegong.dao.FlowerDao;
import com.hegong.domain.Classify;
import com.hegong.domain.Commodity;
import com.hegong.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlowerServiceTest {
    FlowerDao cd = new FlowerDao();
    @Test
    public void test1(){

        List<Classify> classifies = cd.selectAll();
        List<String> c_names = new ArrayList<>();
        for (Classify cf :classifies ) {
            System.out.println(cf.getC_name());
        }

    }
    @Test
    public void test2(){

        List<Classify> classifies = cd.selectOnes("玫瑰花束");
        System.out.println(classifies);

    }
    @Test
    public void test3(){

        List<Commodity> classifies = cd.getCommodityList();
        System.out.println(classifies);

    }
    @Test
    public void test4(){
        List<Commodity> commodityList = cd.getCommodityList();
        for (Commodity c : commodityList) {
            int id = c.getId();
            int count = cd.selectCount(id);
            c.setCount(count);
        }
        System.out.println(commodityList);

    }
    @Test
    public void test5(){
        System.out.println(isUser());
    }



    public boolean isUser() {
        FlowerDao flowerDao = new FlowerDao();
        User user = flowerDao.seletcUser("1881275172");
        if (user != null) {
            String true_pwd = user.getPwd();
            if (true_pwd.equals("123456")) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
