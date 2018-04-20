package dierji.httpServer.demo03;

import java.util.Map;

public class WebApp {
    private static ServletContext context;

    static {
        context = new ServletContext();
        Map<String,String> mapping = context.getMapping();
        mapping.put("/login","login");
        mapping.put("/log","login");
        mapping.put("/reg","register");

        Map<String,String> servlet = context.getServlet();
        servlet.put("login","dierji.httpServer.demo03.LoginServlet");
        servlet.put("register","dierji.httpServer.demo03.RegisterServlet");
    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (url == null || url.trim().equals("")) {
            return null;
        }
//        return context.getServlet().get(context.getMapping().get(url));
        //根据字符串(完整路径)创建对象
        String name = context.getServlet().get(context.getMapping().get(url));
        return (Servlet)Class.forName(name).newInstance();
    }
}

