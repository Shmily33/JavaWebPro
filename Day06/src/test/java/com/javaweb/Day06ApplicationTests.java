package com.javaweb;

import com.javaweb.mapper.UserMapper;
import com.javaweb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day06ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
   public void testListUser(){
        for (User user : userMapper.list()) {
            System.out.println(user.toString());
        }
    }

}
