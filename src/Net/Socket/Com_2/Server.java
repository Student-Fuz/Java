package Net.Socket.Com_2;

// TCPFileCopyServer.java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务器已启动，等待客户端连接...");

            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

            // 接收客户端发送的数据
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int readBytes = inputStream.read(buffer);
            if (readBytes != -1) {
                String clientMessage = new String(buffer, 0, readBytes);
                System.out.println("收到客户端消息：" + clientMessage);
            }

            // 发送回消息到客户端
            OutputStream outputStream = socket.getOutputStream();
            //String serverMessage = "hello, client";
            String serverMessage = "你好, 客户端";
            outputStream.write(serverMessage.getBytes());
            System.out.println("发送消息给客户端：" + serverMessage);


            // 关闭连接
            socket.close();
            System.out.println("服务器已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
