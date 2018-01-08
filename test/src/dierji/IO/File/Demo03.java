package dierji.IO.File;

import java.io.File;

public class Demo03 {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 判断信息
     */
    public static void test2() {
        String path = "/Users/wyh/Desktop/liuyifei/liu1.jpg";
        File src = new File(path);
        //是否存在
        System.out.println(src.exists());
        //是否可读/可写
        System.out.println(src.canWrite());

        if (src.isFile()){
            System.out.println("文件");
        } else {
            System.out.println("文件夹");
        }
    }
    public static void test1() {
        File src = new File("/Users/wyh/Desktop/liuyifei/liu1.jpg");
        //上级目录 没有就是null
        System.out.println(src.getParent());
    }
}
