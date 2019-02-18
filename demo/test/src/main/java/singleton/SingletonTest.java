package singleton;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class SingletonTest {
    /**
     * 循环创建启动线程测试单例模式创建了几个对象
     */
    @Test
    public void test1(){
        while (true)
        new Thread(() -> SingletonDemo.getInstance()).start();
    }

    @Test
    public void test2(){
        SingletonDemoTwo instance = SingletonDemoTwo.INSTANCE;
        instance.doSomeThings();
    }

    @Test
    public void test3() throws ParseException {
//        Calendar calendar = Calendar.getInstance();
//        String s = "2018-12-13 08:40:00";
//        Date date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s );
//        calendar.setTime(date);
//        System.out.println(date.getTime());
        long s = 1546012800000l;
        Date date = new Date(s);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(date));
//        String s = "jiliang";
//        String[] split = s.split(",");
//        System.out.println(Arrays.toString(split));
    }
}
