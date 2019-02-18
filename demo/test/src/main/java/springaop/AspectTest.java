package springaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectTest {
//
//    public void beforeLogin(){
//        System.out.println("登陆前的准备工作");
//    }
//
//    public void afterLogin(){
//        System.out.println("登陆完成，将登陆信息保存");
//    }

    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("登陆前的准备工作");
        point.proceed();
        System.out.println("登陆完成，将登陆信息保存");
    }
}
