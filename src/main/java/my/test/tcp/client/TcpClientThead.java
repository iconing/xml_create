package my.test.tcp.client;

import java.io.*;
import java.net.Socket;

public class TcpClientThead implements Runnable{
    private String ip;
    private int port;
    private String reqStr;

    public TcpClientThead(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    public void run() {
        try {
            Socket socket = new Socket(ip, port);
            System.out.println(Thread.currentThread().getName() + ": begin request ....");
            System.out.println("send data: " + this.reqStr);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println(reqStr);
            pw.flush();
//            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            TcpUtil.readDtaString(is);

            System.out.println(Thread.currentThread().getName() + ": .... end request ");
            System.out.println("");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setReqStr(String reqStr) {
        this.reqStr = reqStr;
    }
}
