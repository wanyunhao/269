package dierji.httpServer.demo02;

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


        try {
            Servlet servlet = WebApp.getServlet(request.getUrl());
            if (servlet == null) {
                this.code = 404;//找不到对应的处理
            } else {
                servlet.servlet(request,response);
            }
            response.pushToClient(code);
        } catch (Exception e) {
//            e.printStackTrace();
            this.code = 500;
        }

        response.pushToClient(500);
        CloseUtil.closeSocket(client);
    }
}

