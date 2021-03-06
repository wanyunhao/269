package dierji.IOTest.byteIO;

import yh.utils.FileUtil;

import java.io.*;

public class copyDemo {
    public static void main(String[] args) {
        copyFile("/Users/wanyunhao/Desktop/JavaTest/study/xixi.txt","/Users/wanyunhao/Desktop/JavaTest/study/wyh01.txt");
    }

    public static void copyFile(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        //选择流
        Writer writer = null;
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            writer = new BufferedWriter(new FileWriter(dest));
            //读取操作
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != reader.read(flush)) {
                writer.write(flush,0,len);
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

