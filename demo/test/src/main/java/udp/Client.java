package udp;

import java.io.IOException;
import java.net.*;

public class Client {
    /*
    ① 定义发送信息
           ② 创建DatagramPacket，包含将要发送的信息
           ③ 创建DatagramSocket
           ④ 发送数据
     */
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 10086;
            byte[] data = "账号：admin ，密码：abc".getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] data2 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(data2,data2.length);
            socket.receive(packet1);
            String info = new String(data2,0,packet1.getLength());
            System.out.println("我是客户端，收到服务器返回的信息:"+info);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

