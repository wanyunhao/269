package dierji.Network.UDP;

import yh.utils.YHByteUtil;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器 + 端口
        DatagramSocket server = new DatagramSocket(8889);
        //2. 创建接收容器
        byte[] content = new byte[1024];
        //3. 封装成包
        DatagramPacket packet = new DatagramPacket(content,content.length);
        //4. 接受数据
        server.receive(packet);
        //5. 处理数据

        System.out.println(YHByteUtil.getDouble(packet.getData()));
        server.close();
    }

    public static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}

