package dierji.httpServer.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server3 {
    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        Server3 server = new Server3();
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
            StringBuilder responseContext = new StringBuilder();
            responseContext.append("<html>" +
                    "<head>" +
                    "<title>象印</title>" +
                    "</head>" +
                    "<body>Hello Tomcat</body>" +
                    "</html>");

            //1.HTTP协议版本.状态代码.描述
            StringBuilder response = new StringBuilder();
            response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);

            //2.响应头
            response.append("Server:bjsxt Server/0.0.1").append(CRLF);
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Content-type:text/html;charset=utf-8").append(CRLF);

            //正文长度
            response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);

            //3.正文之前
            response.append(CRLF);

            //4.正文
            response.append(responseContext);

            System.out.println(responseContext);

            //输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
            bw.close();

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

