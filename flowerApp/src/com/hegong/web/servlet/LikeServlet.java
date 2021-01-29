package com.hegong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hegong.dao.FlowerDao;
import com.hegong.domain.YouLike;
import com.hegong.service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/likeServlet")
public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlowerService classifyService = new FlowerService();
        List<YouLike> youLikes = classifyService.getLikeShopMsg();
        System.out.println(youLikes);
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("utf-8");
        mapper.writeValue(response.getWriter(),youLikes);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
