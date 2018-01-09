package dierji.IOTest.charIO;


import java.io.*;

public class Demo01 {
    public static void main(String[] args) {
        File src = new File("/Users/wanyunhao/Desktop/JavaTest/study/xixi.txt");
        //选择流

        Reader reader = null;
        try {
            reader = new FileReader(src);
            //读取操作
            char[] flush = new char[10];
            int len = 0;
            while ((len = reader.read(flush)) >= 0) {
                //字符数组转成字符串
                String string = new String(flush,0,len);
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

