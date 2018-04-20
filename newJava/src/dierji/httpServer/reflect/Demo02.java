package dierji.httpServer.reflect;

import dierji.httpServer.demo03.Servlet;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clz = Class.forName("dierji.httpServer.demo03.LoginServlet");
        Servlet servlet = (Servlet)clz.newInstance();
        
    }
}

