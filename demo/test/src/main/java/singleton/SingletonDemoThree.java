package singleton;

/**
 * 懒汉式单例模式之双重null判断
 */
public class SingletonDemoThree {
    //加入volatile关键字，防止JVM指令重排序产生错误
    private static volatile SingletonDemoThree instance;
    private SingletonDemoThree(){}

    public SingletonDemoThree getInstance() {
        //在锁之前判断，因为锁比较浪费资源，所以在锁之前判断
        if (instance == null) {
            synchronized (SingletonDemoThree.class) {
                if (instance == null) {
                    instance = new SingletonDemoThree();
                    return instance;
                }
            }
        }
        return instance;
    }
}
