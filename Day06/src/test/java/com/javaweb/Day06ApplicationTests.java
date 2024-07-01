package com.javaweb;

import com.javaweb.mapper.EmpMapper;
import com.javaweb.mapper.UserMapper;
import com.javaweb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day06ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Test
   public void testListUser(){
        for (User user : userMapper.list()) {
            System.out.println(user.toString());
        }
    }



    @Test
    public void testDeleteEmp(){
        empMapper.delete(16);
    }

    @Test
    public void testEmpList(){
        System.out.println(empMapper.list("张"));
    }

}
