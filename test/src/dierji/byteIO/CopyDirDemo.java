package dierji.byteIO;

import yh.utils.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * 150
 */
public class CopyDirDemo {
    public static void main(String[] args) {
        //源目录
        String srcPath = "/Users/wanyunhao/Desktop/JavaTest/study/xixi.txt";
        //目标目录
        String destPath = "/Users/wanyunhao/Desktop/JavaTest/dir";
        try {
            FileUtil.copyFile(srcPath,destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

