package tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
    /*
    <1>创建Socket对象，并指明服务器的IP地址（或主机名）和端口号
    <2>调用Socket实例的getOutputStream()方法，向服务器发送内容
    <3>调用Socket实例的getInputStream()方法，接收服务器发送来的信息
    <4>关闭所有资源
     */

    @Test
    public void test1() {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write("初次访问服务器");
            pw.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("我是客户端，接收到服务器发来的信息为：" + line);
            }
            socket.shutdownInput();
            br.close();
            inputStream.close();
            pw.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名字" + inetAddress.getHostName());
            System.out.println("IP" + inetAddress.getHostAddress());
            System.out.println("IP数组:" + Arrays.toString(inetAddress.getAddress()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            URL url = new URL("https://www.cnblogs.com/rocomp/p/4790340.html");
            InputStream in = url.openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            bf.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
