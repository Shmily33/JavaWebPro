package com.javaweb;

import com.example.HeaderConfig;
import com.example.TokenParser;
import com.javaweb.controller.DeptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Day08AopApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;



    @Test
    public void testGetBean() {
        DeptController bean1= (DeptController) applicationContext.getBean("deptController");
		System.out.println(bean1);

        HeaderConfig bean2 = applicationContext.getBean(HeaderConfig.class);
        System.out.println(bean2);

		DeptController bean3=  applicationContext.getBean("deptController",DeptController.class);
		System.out.println(bean3);

    }

}
