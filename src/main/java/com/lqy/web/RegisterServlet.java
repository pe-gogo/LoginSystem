package com.lqy.web;

import com.lqy.mapper.UserMapper;
import com.lqy.poji.User;
import com.lqy.poji.test;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        SqlSession sql = test.getSession();
        UserMapper us = sql.getMapper(UserMapper.class);
        User u = us.selectByUsername(username);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(u==null){
            us.add(user);
            sql.commit();
            pw.write("<h2>成功<h2>");
        }else{
            pw.write("<h2>gun<h2>");
        }
        sql.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
