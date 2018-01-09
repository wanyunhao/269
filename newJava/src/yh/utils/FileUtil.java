package yh.utils;

import java.io.*;

/**
 * 文件操作和拷贝
 */
public class FileUtil {
    /**
     * 文件的拷贝
     * 源文件路径
     * 目标文件路径
     */
    public static void copyFile(String srcPath, String destPath) throws IOException {
        copyFile(new File(srcPath),new File(destPath));
    }
    /**
     * 文件的拷贝
     * 源文件路径
     * 目标文件路径
     */
    public static void copyFile(File src, File dest) throws IOException {
        //判断不是文件 或者为空
        if (!src.isFile()) {
            throw new IOException(dest.getAbsolutePath() + "只能拷贝文件");
        }
        //如果目标为已经存在的文件夹 不能建立与文件夹同名的文件
        if (dest.isDirectory()) {
            throw new IOException(dest.getAbsolutePath() + "不能建立与文件夹同名的文件");
        }
        //选择流
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        //3.文件拷贝 循环 + 读取 + 写出
        byte[] flush = new byte[1024];
        int len = 0;
        //读取
        while ((len = is.read(flush)) >= 0) {
            //写出
            os.write(flush,0,len);
        }
        os.flush();
        //关闭流
        os.close();
        is.close();
    }

    /**
     * 文件夹拷贝
     * @param srcPath 源file路径
     * @param destPath 目标file路径
     */
    public static void copyDir(String srcPath,String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src,dest);
    }

    /**
     * 文件夹拷贝
     * @param src 源file对象
     * @param dest 目标file对象
     */
    public static void copyDir(File src,File dest) {

        if (src.isDirectory()) {//文件夹
            dest = new File(dest,src.getName());
        }
        copyDirDetail(src,dest);
    }
    /**
     * 拷贝文件夹的细节
     * @param src
     * @param dest
     */
    public static void copyDirDetail(File src,File dest) {
        if (src.isFile()) {
            try {
                FileUtil.copyFile(src,dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //文件夹
        else if (src.isDirectory()) {
            //确保目标文件夹存在
            dest.mkdirs();
            //获取下一级目录或者文件
            for (File sub:src.listFiles()) {
                copyDirDetail(sub,new File(dest,sub.getName()));
            }
        }
    }
}

