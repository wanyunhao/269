package dierji.IO.File;

import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 */
public class FileDemo02 {
    public static void main(String[] args) {
        String parentPath = "/Users/wyh/Desktop/liuyifei";
        String name = "liu1.jpg";
        //相对路径
        File src = new File(parentPath,name);
        src = new File(new File(parentPath),name);
        System.out.println(src.getPath());

        //没有盘符  以user.dir构建
        src = new File("test.txt");
        System.out.println(src.getName());
        System.out.println(src.getPath());//如果是绝对的 返回绝对路径 如果是相对的 返回相对路径
        System.out.println(src.getAbsolutePath());
    }
}
