package dierji.httpServer.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    private ServerSocket server;

    public static void main(String[] args) {
        Server4 server = new Server4();
        server.start();

    }

    /**
     * 启动方法
     */
    public void start() {
        server = null;
        try {
            server = new ServerSocket(8888);
            receive();
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
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);
            String requestInfo = new String(data,0,len).trim();
            System.out.println(requestInfo);

            //响应
            Response response = new Response(client);
            response.println("<html>" +
                    "<head>" +
                    "<title>1象印</title>" +
                    "</head>" +
                    "<body>Hello Tomcat</body>" +
                    "</html>");
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








