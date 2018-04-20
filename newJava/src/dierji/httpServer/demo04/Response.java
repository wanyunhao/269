package dierji.httpServer.demo04;

import dierji.Network.tcpChat.Demo02.CloseUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {

    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    //流
    BufferedWriter bw;
    //正文
    private StringBuilder content;
    //存储正文长度
    private int len = 0;
    //存储头信息
    private StringBuilder headInfo;

    public Response() {
        headInfo = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
        }
    }
    /**
     * 构建正文
     */
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    /**
     * 构建正文 + 回车
     */
    public Response println(String info) {
        content.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    /**
     * 构建响应头
     */
    private void creatHeadInfo(int code) {
        //1.HTTP协议版本.状态代码.描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 500:
                headInfo.append("SERVER ERROR");
                break;

            default:
                break;
        }
        headInfo.append(CRLF);

        //2.响应头
        headInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=utf-8").append(CRLF);

        //正文长度
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF);

    }

    /**
     * 推送到客户端
     */
    void pushToClient(int code) {
        if (headInfo == null) {
            code = 500;
        }
        System.out.println(code);
        creatHeadInfo(code);
        try {
            //头信息+分隔符
            bw.append(headInfo.toString());
            //正文
            bw.append(content.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        CloseUtil.closeAll(bw);
    }
}

