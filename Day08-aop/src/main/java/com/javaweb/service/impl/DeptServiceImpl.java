package com.javaweb.service.impl;

import com.javaweb.aop.MyLog;
import com.javaweb.mapper.DeptMapper;
import com.javaweb.pojo.Dept;
import com.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:15
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @MyLog
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //    @Transactional(rollbackFor = Exception.class) // spring 事务管理
    @MyLog
    @Transactional
    @Override
    public void delete(Integer id) throws Exception {

            deptMapper.deleteById(id); // 根据id删除部门数据
            int i = 1 / 0; // 运行时异常
//        if (true) {
//            throw new Exception("出错了");
//        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept query(Integer id) {
        return deptMapper.queryById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
