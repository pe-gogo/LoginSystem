package com.lqy.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class ServletDemo implements Servlet{


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //转型拿对象
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        //get还是post
        String method = hsr.getMethod();
        //get/post处理逻辑
        if (method.equals("GET")) {
            doGet(servletRequest, servletResponse);
        } else {
            doPost(servletRequest, servletResponse);
        }
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post...");
    }
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse){
        System.out.println("get...");
    }
}
