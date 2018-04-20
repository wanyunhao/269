package dierji.Network.tcpChat.Demo01;

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
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        //输入流
        DataInputStream dis = new DataInputStream(client.getInputStream());

        while (true) {
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();

            System.out.println(dis.readUTF());
        }
    }
}

