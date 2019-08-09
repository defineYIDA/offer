package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zl
 * @Date: 2019/8/9 21:29
 */
public class Server {

    private final static int port = 8080;

    public static void main(String[] args) {
        try {
            //bind 端口
            ServerSocket socket = new ServerSocket(port);

            Socket client = socket.accept();

            InputStream in = client.getInputStream();
            byte[] buf = new byte[1024];
            String msg;
            while (in.read(buf) != -1) {
                msg = new String(buf);
                System.out.println(msg);
            }
            socket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
