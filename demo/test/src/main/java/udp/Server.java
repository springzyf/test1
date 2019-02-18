package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    /*
    1、服务器端实现步骤
           ① 创建DatagramSocket，指定端口号
           ② 创建DatagramPacket
           ③ 接受客户端发送的数据信息
           ④ 读取数据
     */
    public  static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket(10086);
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            System.out.println("服务器已启动。。。");
            socket.receive(packet);
            String info = new String(data,0,packet.getLength());
            System.out.println("我是服务器，客户端告诉我："+info);

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎访问服务器".getBytes();
            DatagramPacket packet1 = new DatagramPacket(data2,data2.length,address,port);
            socket.send(packet1);
            socket.close();
        }catch (Exception e){

        }
    }

}
