package dierji.IOTest.byteIO;

import java.io.*;

/**
 * 字符缓冲流 + 新增方法 (不能发生多态)
 */
public class BufferedCharDemo {
    //继续看153 40秒
    public static void main(String[] args) {
        File src = new File("/Users/wanyunhao/Desktop/JavaTest/newJava/src/dierji/IOTest/byteIO/Demo01.java");
        File dest = new File("/Users/wanyunhao/Desktop/JavaTest/study/wyh01.txt");
        //选择流
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {

            reader = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            //读取操作
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();//换行符号
                writer.append("wyh" + "帅的一匹" + 18);
                writer.newLine();//换行符号

            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

