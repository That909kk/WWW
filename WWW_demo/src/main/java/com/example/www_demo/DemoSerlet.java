package com.example.www_demo;

import com.example.www_demo.beans.LoginBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name="DemoSerlet",value="/doLogin")
public class DemoSerlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object us = req.getParameter("user");
        Object pwd = req.getParameter("pwd");
        LoginBean bean = new LoginBean();
        int result = 0;
        try {
            result = bean.LoginwithMariaDB(us,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = resp.getWriter();
        if (result==0){
            out.println("<h1>Vui Long Du Nhap Tai Khoan va Mat khau</h1>");
        }
        if (result==1)
            out.println("<h1>Chao Mung" + us + "Dang Nhap Thanh Cong!</h1>");
        if (result==-1)
            out.println("<h1>Tai Khoan Khong Ton Tai</h1>");
        if (result==2)
            out.println("<h1>Sai Mat Khau</h1>");

    }
}
