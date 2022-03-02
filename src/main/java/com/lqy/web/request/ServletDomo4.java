package com.lqy.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/demo4")
public class ServletDomo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getMethod().equals("POST")){
            System.out.println("P");
        }else
        System.out.println("G");
        String value =req.getParameter("username");
        System.out.println(value);

        //解决乱码
        byte[]bytes = value.getBytes(StandardCharsets.ISO_8859_1);
        value    = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(value);

//        String value []=req.getParameterValues("username");
//        for(String name:value){
//            System.out.println(name);
//        }



//        if(req.getMethod().equals("GET")) {
//            Map<String, String[]> parameterMap = req.getParameterMap();
//            for(String key:parameterMap.keySet()){
//                System.out.print(key+":");
//                String []a=parameterMap.get(key);
//                for(String value:a){
//                    System.out.println(value);
//                }
//            }
//        }else{
//            System.out.println("post...");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
