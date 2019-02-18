package mytest;

public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
     Thread t1 = new Thread(new Lock1());
     Thread t2 = new Thread(new Lock2());
     t1.start();
     t2.start();
    }
}

class Lock1 implements Runnable{
    @Override
    public void run() {
        System.out.println("lock1 running");
        while (true){
        synchronized (DeadLock.obj1){
            System.out.println("lock1  lock obj1");
            try {
                Thread.sleep(1000);
                synchronized (DeadLock.obj2){
                    System.out.println("lock2 lock obj2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        }
    }
}

class Lock2 implements Runnable{

    @Override
    public void run() {
        System.out.println("lock2 running");
        while (true){
        synchronized (DeadLock.obj2){
            System.out.println("lock2 lock obj2");
            try {
                Thread.sleep(1000);
                synchronized (DeadLock.obj1){
                    System.out.println("lock2 lock obj1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }
}

