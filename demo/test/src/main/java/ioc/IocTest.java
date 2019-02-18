package ioc;

import org.junit.Test;

public class IocTest {
    @Test
    public void getBean() throws Exception {
        String file = SimpleIoc.class.getClassLoader().getResource("spring-ioc.xml").getFile();
        SimpleIoc ioc = new SimpleIoc(file);
//        Teacher teacher = (Teacher) ioc.getBean("teacher");
//        System.out.println(teacher);
        Student student = (Student) ioc.getBean("student");
        System.out.println(student);
    }
}
