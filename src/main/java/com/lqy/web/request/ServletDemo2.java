package com.lqy.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/Demo2",loadOnStartup = -1)
public class ServletDemo2 implements Servlet {

    //会传参给init，我们保存后，用config输出
    ServletConfig servletConfig ;


    //初始化Servlet对象
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("构造函数");
    }
    //返回Servlet配置对象
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }
    //请求处理
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!!");
    }

    //返回Servlet信息
    @Override
    public String getServletInfo() {
        return null;
    }
    //析构函数
    @Override
    public void destroy() {
        System.out.println("析构函数");
    }
}
