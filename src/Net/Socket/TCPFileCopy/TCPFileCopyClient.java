package Net.Socket.TCPFileCopy;

import java.io.*;
import java.net.Socket;

public class TCPFileCopyClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9999)) {
            System.out.println("已连接到服务器...");

            // 发送图片文件数据到服务器
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/sent_file.txt"));
                 BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
                bos.flush();
                System.out.println("图片发送完成");
            }

            // 接收服务器的确认信息
            try (InputStream inputStream = socket.getInputStream()) {
                byte[] responseBuffer = StreamUtils.streamToByteArray(inputStream);
                String response = new String(responseBuffer);
                System.out.println("服务器回应：" + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

