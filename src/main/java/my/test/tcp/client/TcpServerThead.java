package my.test.tcp.client;

import java.io.*;
import java.net.Socket;

public class TcpServerThead implements Runnable{
    private Socket client;
    private String responseStr;

    public TcpServerThead(Socket client, String responseStr) {
        this.client = client;
        this.responseStr = responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running ...");
            System.out.println(client.getLocalAddress().getHostAddress() + " is running ...");
            String str = TcpUtil.readDtaString(client.getInputStream());

            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            System.out.println("send data: " + responseStr);
            pw.println(responseStr);
            pw.flush();

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
