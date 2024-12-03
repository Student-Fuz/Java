package Net.Socket.TCP.Com_2;

// TCPFileCopyClient.java
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("已连接到服务器");

            // 发送消息到服务器
            OutputStream outputStream = socket.getOutputStream();
            //String clientMessage = "hello, server";
            String clientMessage = "你好, 服务端";
            outputStream.write(clientMessage.getBytes());
            System.out.println("消息已发送：" + clientMessage);

            // 接收服务器的回发消息
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int readBytes = inputStream.read(buffer);
            if (readBytes != -1) {
                String serverMessage = new String(buffer, 0, readBytes);
                System.out.println("收到服务器消息：" + serverMessage);
            }

            // 关闭连接
            System.out.println("客户端已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
