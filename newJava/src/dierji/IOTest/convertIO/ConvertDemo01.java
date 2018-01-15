package dierji.IOTest.convertIO;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {
    public static void main(String[] args) {
        try {
            test1();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void test1() throws UnsupportedEncodingException {
        //解码 字节 --> 字符
        String str = "中国";
        //编码 字符 --> 字节
        byte[] data = str.getBytes();
        //编码与解码字符集相同
        System.out.println(new String(data));
        data = str.getBytes("utf-8");//设定编码字符集
        System.out.println(new String(data));
    }
}

