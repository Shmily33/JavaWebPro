package com.javaweb.service.impl;

import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageBean;
import com.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:15
 * @Description:
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Short gender,
                         LocalDate begin,
                         LocalDate end) {
        Long count = empMapper.count();
        Integer start = (page - 1) * pageSize; // 计算页码的起始查询位置
        List<Emp> empList = empMapper.page(start, pageSize,name, gender, begin, end);
        return new PageBean(count, empList);
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
}
