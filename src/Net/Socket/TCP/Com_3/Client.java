package Net.Socket.TCP.Com_3;

// TCPFileCopyClient.java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("已连接到服务器");

            // 使用字符流发送消息到服务器
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String clientMessage = "hello, server";
            writer.write(clientMessage);
            writer.newLine(); // 换行符用于标记消息结束
            writer.flush(); // 刷新缓冲区，确保消息发送
            System.out.println("消息已发送：" + clientMessage);

            // 使用字符流读取服务器的回发消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = reader.readLine();
            System.out.println("收到服务器消息：" + serverMessage);

            // 关闭连接
            System.out.println("客户端已关闭连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
