package singleton;

/**
 * 饿汉式单例模式之枚举方式
 */
public enum  SingletonDemoTwo {
    INSTANCE;

    public void doSomeThings(){
        System.out.println("枚举方法实现");
    }
}
