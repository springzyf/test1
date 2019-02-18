package aop;

import org.junit.Test;

public class SimpleAopTest {
    @Test
    public void test1(){
        MethodInvocation methodInvocation = () -> System.out.println("Log start");
        Service service = new ServiceImpl();

        Advice advice = new BeforeAdvice(service,methodInvocation);
        Service service1 = (Service) SimpleAop.getProxy(service,advice);
        service1.Hello();
    }
}
