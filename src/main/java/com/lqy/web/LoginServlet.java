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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password =req.getParameter("password");
        SqlSession sqlSession=test.getSession();
        UserMapper um= sqlSession.getMapper(UserMapper.class);
        User u  =um.select(username,password);
        sqlSession.close();


        //输出数据参数，判断登陆类型
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter wirter = resp.getWriter();
        if(u!=null){
            wirter.write("<h2>登陆成功<h2>");
        }else{
            wirter.write("<h2>登陆失败<h2>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
