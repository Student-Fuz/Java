## UDP网络通信编程

应用案例一
UDPReceiverA.java UDPSenderB.javacom.hspedu.udp 包

1. 编写一个接收端A,和一个发送端B
2. 接收端A在 9999端口等待接收数据(receive)
3. 发送端A向接收端B 发送 数据"helo,明天吃火锅~"
4. 接收端B接收到 发送端A发送的数据，回复"好的，明天见”，再退出
5. 发送端接收 回复的数据，再退出