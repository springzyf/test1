package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketStart {
    public static void main(String[] args){
        ServerSocket serverSocket;
        int count = 0;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("服务器已启动，等待连接...");
            //多线程，循环启动服务器serverSocket.accept方法阻塞，等待客户端socket连接
            while (true){
                Socket socket = serverSocket.accept();
                count++;
                new SererThread(socket).start();
                System.out.println("客户端连接的IP："+socket.getInetAddress().getHostAddress());
                System.out.println("客户端连接数："+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
