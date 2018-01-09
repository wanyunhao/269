package dierji.other.property;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //类相对路径
//        properties.load(Demo04.class.getResourceAsStream("/dierji/other/property/db.properties"));
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dierji/other/property/db.properties"));
        System.out.println(properties.getProperty("user"));
    }
}
