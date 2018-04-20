package dierji.httpServer.demo01;

import dierji.Network.tcpChat.Demo02.CloseUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求与相应 一个线程对象
 */
public class Dispatcher implements Runnable{
    public Socket client;
    private Request request;
    private Response response;
    private int code = 200;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            this.request = new Request(client.getInputStream());
            this.response = new Response(client.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            code = 500;
            return;
        }
    }

    @Override
    public void run() {

        Servlet servlet = new Servlet();
        servlet.servlet(request,response);
        response.pushToClient(code);
        CloseUtil.closeSocket(client);
    }
}

