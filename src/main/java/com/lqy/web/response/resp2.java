package com.lqy.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp2")
public class resp2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username")=="zf") {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("哈哈哈还好还还还好");
            writer.write("<h2>show me!!<h2>");
        }else{
            //读取输入流 response输出流
            FileInputStream fis=  new FileInputStream("/Users/aotu/Desktop/which-programming-language-should-i-learn-first-infographic.png");
            ServletOutputStream os = response.getOutputStream();
            //
            IOUtils.copy(fis,os);

            fis.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
