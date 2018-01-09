package dierji.IOTest.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writeDemo {
    public static void main(String[] args) throws IOException {
        //152
        File dest = new File("/Users/wanyunhao/Desktop/JavaTest/study/shi.txt");
        //true: 追加 false: 覆盖
        Writer wr = new FileWriter(dest,true);
        String msg = "锄禾日当午\n汗滴禾下土";
        wr.write(msg);
        wr.append("\n谁知盘中餐");
        wr.flush();
    }
}

