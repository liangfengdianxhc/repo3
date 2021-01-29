package com.hegong.web.servlet;

import com.hegong.service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/countTypesServlet")
public class CountTypesServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlowerService flowerService = new FlowerService();
        //查询数据库中总共有几类商品，用作前端页面的显示行数
        int typesCount = flowerService.getTypesCount();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
