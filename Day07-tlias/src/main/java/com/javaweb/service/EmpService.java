package com.javaweb.service;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:15
 * @Description:
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize,
                  String name, Short gender,
                  LocalDate begin,
                  LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp query(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
