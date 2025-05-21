package echo;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        System.out.println("<클라이언트 시작>");
        System.out.println("================================");
        System.out.println("[서버에 연결을 요청합니다.]");

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.90", 10001));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        
        String name = "임유빈";
       
        bw.write(name);
        bw.newLine();
        bw.flush();

        System.out.println("받은메세지: " + name);
        System.out.println("================================");
        System.out.println("<클라이언트 종료>");

        bw.close();
        socket.close();
    }
}