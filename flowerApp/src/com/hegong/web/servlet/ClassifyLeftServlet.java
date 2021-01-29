package com.hegong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hegong.domain.Classify;
import com.hegong.service.FlowerService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/classifyLeftServlet")
public class ClassifyLeftServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        FlowerService cs = new FlowerService();
        List<Classify> classifyLeft = cs.getClassifyMsg();
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("utf-8");
        mapper.writeValue(response.getWriter(),classifyLeft);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
