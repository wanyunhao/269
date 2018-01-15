package dierji.IOTest.bufferedIO;

import java.io.*;

/**
 * 字节流文件拷贝 + 缓冲流, 提高性能
 */
public class BufferedByteDemo {
    public static void main(String[] args) {

    }

    public static void copyFile(String srcPath, String destPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(destPath);
        if (!src.isFile()) {
            throw new IOException("只能拷贝文件");
        }
        //2.选择流
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));

        //3.文件拷贝  循环+读取+写出
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            os.write(flush,0,len);
        }
        //强制刷出
        os.flush();
        //关闭流
        os.close();
        is.close();
    }
}

