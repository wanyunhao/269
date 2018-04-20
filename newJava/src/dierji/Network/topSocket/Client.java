package dierji.Network.topSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 创建客户端  必须指定服务器+端口 此时就在连接
 * Socket(String host, int port)
 * 2. 接收数据 + 发送数据
 */

public class Client {
    //190 7分钟
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8888);
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String echo = br.readLine();
//        System.out.println(echo);

        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
    }
}

