package com.diyiji;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        reader = new FileReader("/Users/wanyunhao/Desktop/ttt/a.txt");
        char c = (char)reader.read();
        char d = (char)reader.read();
        System.out.println(c);
        System.out.println(d);

    }
}
