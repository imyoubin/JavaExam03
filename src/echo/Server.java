package echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        System.out.println("<서버시작>");
        System.out.println("================================");
        System.out.println("[연결을 기다리고 있습니다.]");
        
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.0.90", 10001));
        
        Socket socket = serverSocket.accept();
        System.out.println("[클라이언트가 연결 되었습니다]");
        System.out.println("보낸메세지:");
        
        InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
       
        while (true) {
            String msg = br.readLine();
            if (msg != null) {
                System.out.println("보낸메세지: " + msg);
                break;
            }
        }
      
        br.close();
        isr.close();
        socket.close();
        serverSocket.close();

        System.out.println("================================");
        System.out.println("<서버종료>");
    }
}