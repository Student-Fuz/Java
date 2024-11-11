package Net.Socket.Com_3;

// TCPFileCopyServer.java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务器已启动，等待客户端连接...");

            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

            // 使用字符流读取客户端消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = reader.readLine(); // 读取一行客户端消息
            System.out.println("收到客户端消息：" + clientMessage);

            // 使用字符流发送消息给客户端
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String serverMessage = "hello, client";
            writer.write(serverMessage);
            writer.newLine(); // 换行符用于标记消息结束
            writer.flush(); // 刷新缓冲区，确保消息发送

            // 关闭连接
            socket.close();
            System.out.println("服务器已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
