package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test1 {
    public static void main(String[] args){
     Apple apple = new Apple();
        InvocationHandler app = new Market(apple);
     Sell market= (Sell) Proxy.newProxyInstance(Apple.class.getClassLoader(),Apple.class.getInterfaces(),app);
     market.sell();
    }
}
