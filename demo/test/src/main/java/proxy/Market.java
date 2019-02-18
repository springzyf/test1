package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Market implements InvocationHandler {

    private Object real;

    //真实实现类通过构造方法传入
    public Market(Object real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy 代理的对象,method 方法，args参数
        System.out.println("快来啊，大减价。。。");
        //此处调用真实类的方法
        method.invoke(real,args);
        System.out.println("卖完了...");
        return null;
    }
}
