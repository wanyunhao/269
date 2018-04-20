package dierji.Network.tcpChat.Demo01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器先读取 后输出
 * 写出数据: 输出流
 * 读取数据: 输入流
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        //写出数据
        //输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String msg = dis.readUTF();

        //输出流
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("服务器 -->" + msg);
        dos.flush();
    }
}

