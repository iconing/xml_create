package my.test.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;

public class TcpUtil {
    
    public static String readDtaString(InputStream is) {
        byte[] buf = null;
        String str1 = "", 
        	   str2 = "",
        	   str3 = "";
        try {
        	buf = new byte[8];
        	is.read(buf, 0, 8);
        	str1 = new String(buf);
        	int dataLen = Integer.parseInt(str1);
        	System.out.println("data leng: " + dataLen);
        	
        	buf = new byte[15];
        	is.read(buf, 0, 15);
        	str2 = new String(buf);
        	System.out.println("serv name: " + str2);
        	
        	buf = new byte[dataLen];
        	is.read(buf, 0, dataLen);
        	str3 = new String(buf);
			System.out.println("recv data" + ": " + str3);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return str1 + str2 + str3;
    }

    public static String readStrFrom(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String temp = "";
        String str = "";
        while ((temp = br.readLine()) != null) {
            str += temp;
        }
        System.out.println("recv data" + ": " + str);
        return str;
    }

    public static void main(String[] args) throws SocketException {
        getIpv4Add();

    }

    public static String getIpv4Add() throws SocketException {
        Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
        if(interfaceList != null){
            while (interfaceList.hasMoreElements()) {
                NetworkInterface nif = interfaceList.nextElement();
                Enumeration<InetAddress> inetAddresses = nif.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof Inet4Address) {
                        System.out.println(inetAddress.getHostAddress());
                        return inetAddress.getHostAddress();
                    }
                }
            }
        }
        return "";
  }
}