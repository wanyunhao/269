package dierji.byteIO;

import yh.utils.FileUtil;

import java.io.*;

public class copyDemo {
    public static void main(String[] args) {
        String src = "/Users/wanyunhao/Desktop/JavaTest/source/101.jpg";
        String dest = "/Users/wanyunhao/Desktop/JavaTest/source/102.jpg";

        try {
            FileUtil.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

