package aop;

import java.lang.reflect.Proxy;

public class SimpleAop {
     public static Object getProxy(Object bean,Advice advice){
         return Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(),advice);
     }
}
