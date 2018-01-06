package dierji.other.property;

import java.util.Properties;

/**
 * Properties配置文件的读写
 * 1.key 和 value只能为字符串
 * 2. 存储与读取
 */
public class Demo01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //存储
        properties.setProperty("driver","oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
        properties.setProperty("user","scott");
        properties.setProperty("pwd","tiger");

        String url = properties.getProperty("url","test");
        //如果url为空则打印test  否则打印 jdbc:oracle:thin:@localhost:1521:orcl
        System.out.println(url);

    }
}
