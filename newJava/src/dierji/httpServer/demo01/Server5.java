package dierji.httpServer.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {
    private ServerSocket server;

    public static void main(String[] args) {
        Server5 server = new Server5();
        server.start();

    }

    /**
     * 启动方法
     */
    public void start() {
        server = null;
        try {
            server = new ServerSocket(8888);
            while (true) {
                receive();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            Socket client = server.accept();
            //请求
            Request req = new Request(client.getInputStream());
            //响应
            Response response = new Response(client);
            response.println("<html>" +
                    "<head>" +
                    "<title>1象印</title>" +
                    "</head><body>");
            response.println(req.getParamter("user"));
            response.println("</body></html>");
            response.pushToClient(200);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {

    }
}








