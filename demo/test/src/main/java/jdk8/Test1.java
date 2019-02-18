package jdk8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test1 {

    @Test
    public void test1() {
        Person p = new NormalPerson();
        p.breathe();
    }

    @Test
    public void test2(){
        FunctionalInterfaceTest f = (a,b) -> a+b;
        int i = f.test1(5, 8);
        System.out.println(i);
    }

    @Test
    public void test3(){
        LocalDate d= LocalDate.of(1999,9,9);
        LocalTime m = LocalTime.now();
        System.out.println(m);
        System.out.println(d);

    }

    @Test
    public void test4(){
        Integer[] s = {1,3,33,2};
        Arrays.sort(s, (Integer s1, Integer s2) -> (s2-s1));
        List<Integer> list = Arrays.asList(s);
        list.forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<Production> ps = new ArrayList<>();
        Production p1 = new Production("巧克力",22.0);
        Production p2 = new Production("棒棒糖",5.00);
        ps.add(p1);
        ps.add(p2);
        double sss = ps.stream().mapToDouble(p -> p.getPrice()).sum();
        System.out.println(sss);
//        Production collect = ps.stream().max((q1,q2)-> (int) (q1.getPrice()-q2.getPrice())).get();
//        System.out.println(collect);
    }

    @Test
    public void test6(){
        //构造方法的引用
        AppleFactory factory = Apple::new;
        Apple apple = factory.buy("苹果", 3.5);
        System.out.println(apple.getName());

    }

    @Test
    public void test7(){
            for(int i=0;i<99;i++){
                method2();
            }
    }

    public static void method2(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread t3 = new Thread(runnable,"t3");
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void method1(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("方法1执行");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("方法2执行");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("方法3执行");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }


    /*

        public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }
    EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("ImageViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });


     */


}
