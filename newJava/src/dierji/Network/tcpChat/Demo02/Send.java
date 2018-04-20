package dierji.Network.tcpChat.Demo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {

    //控制台的输入流
    private BufferedReader console;
    //管道的输出流
    private DataOutputStream dos;
    //控制线程
    private boolean isRunning = true;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            //出现错误就关闭当前管道
            isRunning = false;
            CloseUtil.closeAll(dos,console);
        }
    }

    //1.从控制台接收数据
    private String getMessageFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
        }
        return "";
    }

    /**
     *
     * 2.发送数据
     */
    public void send() {
        String msg = this.getMessageFromConsole();
        if (msg != null && !msg.equals("")) {
            try {
                dos.writeUTF(msg);
                dos.flush();//强制刷新
            } catch (IOException e) {
                //出现错误就关闭当前管道
                isRunning = false;
                CloseUtil.closeAll(dos,console);
            }
        }

    }

    @Override
    public void run() {
        //线程体
        while (isRunning) {
            send();
        }
    }
}

