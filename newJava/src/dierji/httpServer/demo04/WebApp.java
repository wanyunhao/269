package dierji.httpServer.demo04;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContext context;

    static {

        //指定XML 加处理器
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser sax = factory.newSAXParser();
            WebHandler webHandler = new WebHandler();
            sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("dierji/httpServer/demo04/web.xml"),webHandler);
            context = new ServletContext();
            Map<String,String> servlet = context.getServlet();
            for (Entity entity:webHandler.getEntityList()) {
                servlet.put(entity.getName(),entity.getCls());
            }

            Map<String,String> mapping = context.getMapping();
            for (Mapping map:webHandler.getMappingList()) {
                List<String> urls = map.getUrlPattern();
                for (String url:urls) {
                    mapping.put(url,map.getName());
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

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

