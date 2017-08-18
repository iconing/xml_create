package my.test.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    private static String ip = "192.168.68.110";
    private static int port = 12010;
//    private static String ip = "10.126.1.101";
//    private static int port = 12014;
    private static String reqStr =
                "00000125" +
                "3006           " +
                "11111111" +
                "222222" +
                "111111" +
                "33333333333333333333" +
                "44444" +
                "55555555555555555555555555555555555555555555555555555555555555555555555555555555";

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 10; i++) {
        }
            TcpClientThead tct = new TcpClientThead(ip, port);
            tct.setReqStr(reqStr);
            new Thread(tct).start();
    }
}
