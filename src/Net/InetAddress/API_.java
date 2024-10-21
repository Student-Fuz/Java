package Net.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) {

        try{
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println("Local Host Address: " + localHost);
        }   catch (UnknownHostException e) {
            System.err.println("Host not found:" + e.getMessage());
        }

    }
}
