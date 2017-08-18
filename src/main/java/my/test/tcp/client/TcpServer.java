package my.test.tcp.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private static String responseStr = "00000125FBS3006        " +
                                        "11111111222222" +
                                        "111111" +
                                        "3333333333333333333300000" +
                                        "交易处理成功" +
                                        "55555555555555555555555555555555555555555555555555555555555555555555555555";
    private static String ip = "10.126.1.101";

    public static void run(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);

        while (true) {
            Socket socket = ss.accept();

            TcpServerThead tcpServerThead = new TcpServerThead(socket, responseStr);
            tcpServerThead.setResponseStr(responseStr);

            new Thread(tcpServerThead).start();

        }
    }

    public static void main(String[] args) throws IOException {
        run(12014);
//        run(12015);
    }
}
