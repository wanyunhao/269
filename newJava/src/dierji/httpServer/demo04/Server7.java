package dierji.httpServer.demo04;

import dierji.Network.tcpChat.Demo02.CloseUtil;

import java.io.IOException;
import java.net.ServerSocket;

public class Server7 {
    private ServerSocket server;

    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    private boolean isShutDown = false;


    public static void main(String[] args) {
        Server7 server = new Server7();
        server.start();
    }

    public void start() {
        this.start(8888);
    }
    /**
     * 启动方法
     */
    public void start(int port) {
        server = null;
        try {
            server = new ServerSocket(port);
            receive();
        } catch (IOException e) {
//            e.printStackTrace();
            stop();
        }
    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            while (!isShutDown) {

                new Thread(new Dispatcher(server.accept())).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {
        isShutDown = true;
        CloseUtil.closeServerSocket(server);
    }
}








