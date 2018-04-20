package dierji.Network.tcpChat.Demo02;

import java.io.*;
import java.net.Socket;

/**
 * 创建客户端: 发送数据,接受数据
 * 写出数据: 输出流
 * 读取数据: 输入流
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8888);

        //控制台输入流
        new Thread(new Send(client)).start();//一条路径

        new Thread(new Receive(client)).start();
        //输入流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while (true) {
            System.out.println(dis.readUTF());
        }
    }
}

