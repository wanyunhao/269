package dierji.Network.tcpChat.Demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

        while (true) {
            Socket socket = server.accept();
//        Receive receive = new Receive(socket);
            //写出数据
            //输入流
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String msg = dis.readUTF();

                //输出流
                dos.writeUTF("服务器 -->" + msg);
                dos.flush();
            }
        }

    }
}

