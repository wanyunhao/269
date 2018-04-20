package dierji.httpServer.demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String,List<String>> parameterMapValues;

    //内部

    public static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValues = new HashMap<String,List<String>>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        try {
            byte[] data = new byte[20480];
            int len = is.read(data);
            requestInfo = new String(data,0,len);
        } catch (IOException e) {
            return;
        }
        //分析头信息
        parseRequestInfo();
    }

    /**
     * 分析请求信息
     */
    private void parseRequestInfo () {
        if (requestInfo == null ||(requestInfo.trim()).equals("")) {
            return;
        }

        String paramString = "";//接受请求参数

        //1.获取请求方式
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
        int index = requestInfo.indexOf("/");
        this.method = firstLine.substring(0,index).trim();
        String urlString = firstLine.substring(index,firstLine.indexOf("HTTP/")).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlString;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else if(this.method.equalsIgnoreCase("get")) {
            //是否存在参数
            if (urlString.contains("?")) {
                String[] urlArray = urlString.split("\\?");
                this.url = urlArray[0];
                //接收请求参数
                paramString = urlArray[1];
            } else {
                this.url = urlString;
            }
        }


        //不存在
        if (paramString.equals("")) {
            return;
        }
        //2.将请求封装到Map
        parseParams(paramString);
    }

    private void parseParams(String paramString) {
        //分割  将字符串转成数组
//        String[] array = paramString.split("&");
        StringTokenizer token = new StringTokenizer(paramString,"&");
        while (token.hasMoreTokens()) {
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            if (keyValues.length == 1) {
                keyValues = Arrays.copyOf(keyValues,2);
                keyValues[1] = null;
            }

            String key = keyValues[0].trim();
            String value = keyValues[1] == null?null:decode(keyValues[1].trim(),"utf-8");
            //转换成Map
            if(!parameterMapValues.containsKey(key)) {
                parameterMapValues.put(key,new ArrayList<String>());
            }

            List<String> values = parameterMapValues.get(key);
            values.add(value);
        }
    }

    /**
     * 解决中文
     * @param value
     * @param code
     * @return
     */
    private String decode(String value,String code) {
        try {
            return URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 根据页面的name 获取对应的值
     */
    public String[] getParamterValues(String name) {
        List<String> values = parameterMapValues.get(name);
        if (values == null) {
            return null;
        } else {
            return values.toArray(new String[0]);
        }
    }

    /**
     * 根据页面的name 获取对应的值
     */
    public String getParamter(String name) {
        String[] values = getParamterValues(name);
        if (values == null) {
            return null;
        }
        return values[0];
    }

    public String getUrl() {
        return url;
    }
}

