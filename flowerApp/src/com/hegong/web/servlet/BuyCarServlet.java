package com.hegong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hegong.dao.FlowerDao;
import com.hegong.domain.Commodity;
import com.hegong.service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buyCarServlet")
public class BuyCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlowerService flowerService = new FlowerService();
        //查询数据库中总共有几类商品，用作前端页面的显示行数
        int typesCount = flowerService.getTypesCount();
        response.setCharacterEncoding("UTF-8");
        List<Commodity> commodities = flowerService.getBuyCarList();
        System.out.println(commodities);
        ObjectMapper mapper = new ObjectMapper();
        
        mapper.writeValue(response.getWriter(),commodities);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
