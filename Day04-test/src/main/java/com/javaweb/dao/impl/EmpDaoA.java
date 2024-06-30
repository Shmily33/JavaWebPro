package com.javaweb.dao.impl;

import com.javaweb.dao.EmpDao;
import com.javaweb.pojo.Emp;
import com.javaweb.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/06/29/下午8:28
 * @Description:
 */
@Repository//("daoA")
public class EmpDaoA implements EmpDao {

    // 获取员工列表
    @Override
    public List<Emp> listEmp() {
        // 1、加载并解析emp.html
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
