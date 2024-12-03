package Net.Socket.TCP.Com_1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // ServerSocket 是 Java 中用于服务器端的套接字类，它在指定的端口（这里是 9999）上监听连接请求。
        // ServerSocket 绑定到指定端口，等待来自客户端的连接。
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务器已启动，等待客户端连接...");

            // accept() 方法会阻塞当前线程，直到有客户端连接到服务器。
            // 一旦连接成功，它会返回一个 Socket 对象，用于与客户端通信。
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

            // 服务器使用 InputStream 从客户端读取数据。
            // buffer 是一个字节数组，用来暂存从客户端接收到的数据。
            // read() 方法会阻塞直到数据到达，然后将数据存入 buffer 中，并返回实际读取的字节数。
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int readBytes = inputStream.read(buffer);
            if (readBytes != -1) {
                String message = new String(buffer, 0, readBytes);
                System.out.println("收到客户端消息：" + message);
            }

            // 关闭套接字，释放与客户端的连接。
            socket.close();
            System.out.println("服务器已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}