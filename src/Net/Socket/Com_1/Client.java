package Net.Socket.Com_1;

// TCPFileCopyClient.java
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // Socket 用于客户端连接服务器。
        // 这里指定服务器地址为 127.0.0.1（本地主机），端口号为 9999。
        // Socket 会尝试连接到指定的 IP 和端口。
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("已连接到服务器");

            // 客户端获取输出流 OutputStream
            // 并将字符串 "hello, server" 以字节形式发送到服务器端。
            // getBytes() 方法将字符串转换为字节数组，以便通过 OutputStream 发送。
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello, server".getBytes());
            System.out.println("消息已发送");

            // 关闭连接
            System.out.println("客户端已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}