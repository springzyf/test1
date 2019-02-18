package jdk8;

public class NormalPerson implements Person {

    @Override
    public void run() {
        System.out.println("在操场跑圈呢！");
    }

    @Override
    public void breathe() {
        System.out.println("学生的呼吸");
    }
}
