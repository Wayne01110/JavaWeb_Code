package com.Wayne.web.serlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servletUserServlet")
public class ServletUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1。接收用户名
        String username = request.getParameter("username");

        //2。调用service查询User对象

        boolean flag = true;

        //3. 响应标记
        response.getWriter().write("" + flag);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
