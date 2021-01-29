package com.hegong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hegong.domain.Classify;
import com.hegong.service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classifyRightServlet")
public class ClassifyRightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        System.out.println(key);
        FlowerService cs = new FlowerService();
        //明确两件事情
        //第一件:根据接收到的参数调用service层得到数据库中有几个这个参数的数据

        //第二件事：根据关键字查询数据库所有包含该关键字的信息
        List<Classify> selectMsg = cs.getSelectMsg(key);
        response.setCharacterEncoding("utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),selectMsg);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
