package tcp;

import java.io.*;
import java.net.Socket;

public class SererThread extends Thread {
    Socket socket = null;

    public SererThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while ((line =bufferedReader.readLine())!=null){
                System.out.println("我是服务器，我接受到的消息是："+line);
            }
            socket.shutdownInput();

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("欢迎访问我的服务器");
            pw.flush();
            socket.shutdownOutput();

            bufferedReader.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
