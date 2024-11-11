package Net.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) {
        try{

            /*使用InetAddress类的静态方法
            getLocalHost()*/

            // 1. 获取本机的InetAddress对象
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localHost);             // Local Host Address: DESKTOP-SM9CKFK/113.54.133.13 DESKTOP-SM9CKFK设备名称

            // 2. 根据指定主机名 获取InetAddress对象
            InetAddress host1 = InetAddress.getByName("DESKTOP-SM9CKFK");
            System.out.println("Host1 = " + host1);

            // 3. 根据域名返回InetAddress对象, 比如www.baidu.com
            InetAddress host2 = InetAddress.getByName("www.baidu.com");
            System.out.println("Host of www.baidu.com = " + host2);

            // 4. 通过InetAddress对象，获取对应地址
            String hostAddress = host2.getHostAddress();
            System.out.println("Host2 对应的ip = " + hostAddress);

            // 5. 通过InetAddress对象，获取对应主机名或者域名
            String hostName = host2.getHostName();
            System.out.println("Host2 对应的主机名 = " + hostName);


        }   catch (UnknownHostException e) {
            System.err.println("Host not found:" + e.getMessage());
        }

    }
}
