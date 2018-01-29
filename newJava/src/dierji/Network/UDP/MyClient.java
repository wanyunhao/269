package dierji.Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class MyClient {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器 + 端口号
        DatagramSocket client = new DatagramSocket(6666);

        //2. 准备数据
        String msg = "测试一波";
        byte[] data = msg.getBytes();

        //3. 打包
        DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        //4. 发送
        client.send(packet);

        //5. 释放
        client.close();
    }
}

