package com.javaweb.controller;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.Result;
import com.javaweb.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/06/29/下午7:04
 * @Description:
 */
@RestController
public class EmpController {

    @RequestMapping("/listEmp")
    public Result list() {
        // 1、加载并解析emp.html
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 2、对数据进行转换处理-gender, job
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            } else {
                emp.setGender("——");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            } else {
                emp.setJob("——");
            }

        });

        // 3、响应数据
        return Result.success(empList);

    }

}
