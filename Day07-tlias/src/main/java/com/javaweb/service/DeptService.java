package com.javaweb.service;

import com.javaweb.pojo.Dept;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:15
 * @Description:
 */
public interface DeptService {
    // 查询全部部门数据
    List<Dept> list();

    // 根据id删除部门
    void delete(Integer id);

    // 新增部门
    void add(Dept dept);

    // 根据id查询部门
    Dept query(Integer id);

    void update(Dept dept);
}
