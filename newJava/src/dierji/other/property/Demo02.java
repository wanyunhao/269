package dierji.other.property;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties输出到文件
 * 资源配置文件:
 * 1. .properties
 * store(OutputStream out, String comments)
 * store(Writer writer, String comments)
 * 2. .xml
 * storeToXML(outputStream os, String comment); UTF-8字符集
 * storeToXML(OutputStream os, String comment, Stirng encoding)
 */
public class Demo02 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        //存储
        properties.setProperty("driver","oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
        properties.setProperty("user","scott");
        properties.setProperty("pwd","tiger");

        //存储到绝对路径
//        properties.store(new FileOutputStream(new File("/Users/wyh/Desktop/lujing/db.properties")),"db配置");
//        properties.storeToXML(new FileOutputStream(new File("/Users/wyh/Desktop/lujing/db.xml")),"xml配置");
        //使用相对路径  默认当前工程
//        properties.store(new FileOutputStream(new File("db.properties")),"db配置");
        //就存到src目录下了
        properties.store(new FileOutputStream(new File("src/dierji/other/property/db.properties")),"db配置");
    }
}
