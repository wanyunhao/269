package dierji.byteIO;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        //建立联系 File对象 目的地
        File dest = new File("/Users/wanyunhao/Desktop/JavaTest/source/a.txt");
        //2. 选择流
        OutputStream os = null;

        try {
            //以追加形式写出文件  appen必须为true  否则就是覆盖
            os = new FileOutputStream(dest,true);
            //操作
            String str = "wuyanzu wuyanzu";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data,0,data.length);
            os.flush();//强制刷新
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件写出失败");
            e.printStackTrace();
        } finally {
            //释放资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    System.out.println("关闭输出流失败");
                    e.printStackTrace();
                }
            }
        }


    }
}

