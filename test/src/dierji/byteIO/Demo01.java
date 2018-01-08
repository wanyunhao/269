package dierji.byteIO;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) {
        File src = new File("/Users/wanyunhao/Desktop/JavaTest/source/a.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //操作不断读取,缓冲区
            byte[] car = new byte[10];
            //接受实际读取的大小
            int length = 0;
            //循环读取
            while (-1 != (length = is.read(car))) {
                //输出 字节数组转成字符串
                String info = new String(car,0,length);
                System.out.println(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        } finally {
            //释放资源
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输入流文件失败");
                }
            }
        }
    }
}

