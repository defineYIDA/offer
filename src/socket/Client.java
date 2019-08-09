package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/9 21:28
 */
public class Client {
    public static void main(String[] args) {
        Socket cilent;
        cilent = new Socket();
        /*try {
            cilent = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        SocketAddress add = new InetSocketAddress("localhost", 8080);
        try {
            cilent.connect(add);
            OutputStream out = cilent.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            String msg;
            while (scanner.hasNext() && !"exit".equals(msg = scanner.next())) {
                //注意编解码一致，其实不写也行
                out.write(msg.getBytes());
                out.flush();
            }
            //记得关闭连接
            cilent.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
