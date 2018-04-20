package dierji.Network.tcpChat.Demo02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {

    //输入流
    private DataInputStream dis;
    //线程标识
    private Boolean isRunning = true;

    public Receive() {
    }

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }

    public String receive() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
        return "";
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(receive());
        }
    }
}

