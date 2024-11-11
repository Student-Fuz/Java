## TCP网络通信编程

### 应用案例4 TCPFileCopy.java

1. 编写一个服务端和一个客户端

2. 服务器端在 9999端口监听

3. 客户端连接到服务端，发送 一张图片 e:\example.png

4. 服务器端接收到 客户端发送的 图片，保存到 src下，发送"收到图片"再退出

5. 客户端接收到服务端发送的"收到图片"， 再退出

6. 该程序要求使用 StreamUtils.java 该程序实现将流转换为字节数组

   

示意图:
说明:使用BufferedInputStream 和 BufferedOutputStream 字节流

