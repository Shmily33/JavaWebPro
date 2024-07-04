package com.javaweb.service.impl;

import com.javaweb.mapper.DeptLogMapper;
import com.javaweb.mapper.DeptMapper;
import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.Dept;
import com.javaweb.pojo.DeptLog;
import com.javaweb.service.DeptLogService;
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

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;


    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //    @Transactional(rollbackFor = Exception.class) // spring 事务管理
    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id); // 根据id删除部门数据
            int i = 1 / 0; // 运行时异常
//        if (true) {
//            throw new Exception("出错了");
//        }
            empMapper.deleteByDeptId(id); // 根据部门id删除该部门下的员工

        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，id是：" + id + "号部门");
            deptLogService.insert(deptLog);
        }

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
