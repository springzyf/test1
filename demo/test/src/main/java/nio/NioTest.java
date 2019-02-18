package nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioTest {


    @Test
    public void read1() throws IOException {
        //创建随机访问文件
        RandomAccessFile file = new RandomAccessFile("a.txt","rw");
        //获取通道
        FileChannel channel = file.getChannel();
        //创建缓冲区
        ByteBuffer bf = ByteBuffer.allocate(48);
        //从通道中将数据读取到缓冲区
        channel.read(bf);
        //将buffer由写模式切换成读模式
        bf.flip();
        System.out.println( (char) bf.get());
        System.out.println( (char) bf.get());
        System.out.println( (char) bf.get());
        bf.clear();
        channel.close();
    }

    @Test
    public void write1() throws IOException {
        RandomAccessFile file = new RandomAccessFile("a.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("hello world".getBytes());
        //无论是将缓冲区的数据写入通道，还是将缓冲区的数据读取出来，都需要调用flip()方法。
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        channel.close();
    }
}
