package dierji.Network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class URLDemo02 {
    //186看完了
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");//主页:默认资源
        //获取资源
//        InputStream is = url.openStream();
//
//        byte[] flush = new byte[1024];
//        int len = 0;
//        while (-1 != (len = is.read(flush))) {
//            System.out.println(new String (flush,0,len));
//        }
//        is.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/wanyunhao/Desktop/tt.html"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/wanyunhao/Desktop/baidu.html"),"utf-8"));

        String msg = null;
        while ((msg = br.readLine()) != null) {
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

