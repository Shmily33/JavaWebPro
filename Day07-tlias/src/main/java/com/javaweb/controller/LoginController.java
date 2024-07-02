package com.javaweb.controller;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.Result;
import com.javaweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午9:30
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录：{}", emp);
        Emp e = empService.login(emp);

        return e != null ? Result.success() : Result.error("用户名或密码错误");

    }

}
