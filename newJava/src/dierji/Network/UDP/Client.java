package dierji.Network.UDP;

import yh.utils.YHByteUtil;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    //继续看 189 03:30
    public static void main(String[] args) throws IOException {
        //1. 创建服务器 + 端口号
        DatagramSocket client = new DatagramSocket(6666);

        //2. 准备数据
        double num = 89.123;
        byte[] data = YHByteUtil.getBytes(num);

        //3. 打包
        DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8889));
        //4. 发送
        client.send(packet);

        //5. 释放
        client.close();
    }



    public static byte[] getBytes(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();

        data = bos.toByteArray();
        dos.close();
        return data;
    }

}

