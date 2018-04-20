package dierji.Network.topSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.创建服务器 指定端口 ServerSocket(port);
 * 2.接收客户端连接
 * 3.发送数据+接收数据
 */
public class MultiServer {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器,指定端口 ServerSocket(int)
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            //死循环
            //一个accept 一个客户端
            //2. 接收客户端连接 阻塞式
            Socket socket = server.accept();

            System.out.println("客户端建立连接");

            //3.发送数据
            String msg = "欢迎使用";

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}

