package singleton;

/**
 * 懒汉式单例模式之静态内部类懒汉式，线程安全
 * 静态内部类在没有显示调用的时候是不会进行加载的
 */
public class SingletonDemo {
    private static class Temp {
        private static final SingletonDemo singleton = new SingletonDemo();
    }
    private SingletonDemo(){}
    public static SingletonDemo getInstance(){
        return Temp.singleton;
    }
}
