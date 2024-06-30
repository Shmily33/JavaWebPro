package com.javaweb.service.impl;

import com.javaweb.dao.EmpDao;
import com.javaweb.dao.impl.EmpDaoA;
import com.javaweb.pojo.Emp;
import com.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/06/29/下午8:32
 * @Description:
 */
@Service // 将当前类交给IOC容器管理，成为其中的bean
public class EmpServiceA implements EmpService {

    @Autowired // 运行时，IOC会提供该类型的bean对象
    private EmpDao empDao ;

    // 获取员工列表
    @Override
    public List<Emp> listEmp() {
        // 1、调用Dao获取数据
        List<Emp> empList = empDao.listEmp();

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
        return empList;
    }
}
