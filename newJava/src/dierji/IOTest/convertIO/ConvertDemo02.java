package dierji.IOTest.convertIO;

import java.io.*;

/**
 * 转换刘 : 字节转为字符
 * 1.输出流 OutputStreamWriter
 * 2.输入流 InputStreamReader
 */
public class ConvertDemo02 {
    //打开看155
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            new File("/Users/wanyunhao/Desktop/JavaTest/study/wyh01.txt")),"GBK"));

//        BufferedWriter bw = new BufferedWriter()
        String info = null;
        while (null != (info = br.readLine())) {
            System.out.println(info);
        }
        br.close();
    }
}

