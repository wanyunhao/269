package dierji.Network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class SocketDemo {
    public static void main(String[] args) throws UnknownHostException {
        //简便的  继续看186
        InetSocketAddress address = new InetSocketAddress("localhost",9999);
        //原始
        address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
        InetAddress address1 = address.getAddress();
        System.out.println(address1.getHostAddress());//返回地址
        System.out.println(address1.getHostName());//输出计算机名
    }
}

