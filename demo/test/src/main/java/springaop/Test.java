package springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
        Subject o = (Subject) ac.getBean("canLogin");
        o.login();
    }
}
