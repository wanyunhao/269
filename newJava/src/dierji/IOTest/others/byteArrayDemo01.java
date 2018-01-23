package dierji.IOTest.others;

import java.io.*;

public class byteArrayDemo01 {
    public static void main(String[] args) throws IOException{
        read(write());
    }

    /**
     * 输出流 操作与文件输出流有些不同, 有新增方法, 不能使用多态
     */

    public static byte[] write() throws IOException {
        //目的地
        byte[] dest;
        //选择流 不同点
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //写出

        String string = "操作与文件输入流操作一致";
        byte[] info = string.getBytes();
        bos.write(info,0,info.length);

        //获取数据
        dest = bos.toByteArray();
        //释放资源
        bos.close();
        return dest;
    }

    //输入流 操作与文件输入流操作一致
    public static void read(byte[] src) throws IOException {
//        String string = "操作与文件输入流操作一致";
//        byte[] src = string.getBytes();

        //选择流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));

        //操作
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush,0,len));
        }
        is.close();
    }
}

