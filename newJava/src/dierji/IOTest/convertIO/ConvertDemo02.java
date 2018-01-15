package dierji.IOTest.convertIO;

import java.io.*;

/**
 * 转换刘 : 字节转为字符
 * 1.输出流 OutputStreamWriter
 * 2.输入流 InputStreamReader
 */
public class ConvertDemo02 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream("/Users/wanyunhao/Desktop/JavaTest/study/wyh01.txt")));

    }
}

