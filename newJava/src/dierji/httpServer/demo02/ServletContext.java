package dierji.httpServer.demo02;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 */

public class ServletContext {
    //为每一个servlet取个别名
    //login->loginservlet
    private Map<String,Servlet> servlet;

    //映射
    //url->login
    //  /log --> login
    //  /login --> login
    private Map<String,String> mapping;

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, Servlet> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, Servlet> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}

