package com.runa.demo;

import com.runa.demo.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private Teacher teacher;

    @Test
    public void contextLoads() {
        System.out.println(teacher);
    }

}
