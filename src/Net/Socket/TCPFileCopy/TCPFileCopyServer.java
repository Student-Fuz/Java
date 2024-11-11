package Net.Socket.TCPFileCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileCopyServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务器启动，在9999端口监听...");

            // 接收客户端连接
            try (Socket socket = serverSocket.accept()) {
                System.out.println("客户端连接成功：" + socket.getInetAddress().getHostAddress());

                // 接收图片文件数据并保存到指定目录
                try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/received_file.txt"))) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                    System.out.println("图片接收并保存成功");
                }

                // 发送确认信息到客户端
                try (OutputStream outputStream = socket.getOutputStream()) {
                    outputStream.write("收到图片".getBytes());
                    outputStream.flush();
                }
            }

            //try (Socket socket = serverSocket.accept()){
            //    // 发送确认信息到客户端
            //    try (OutputStream outputStream = socket.getOutputStream()) {
            //        outputStream.write("收到图片".getBytes());
            //        outputStream.flush();
            //    }
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


