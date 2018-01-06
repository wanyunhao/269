package dierji.other.property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用properties 读取配置文件
 */
public class Demo03 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("/Users/wyh/Desktop/lujing/db.properties"));
        System.out.println(properties.getProperty("user"));
    }
}
