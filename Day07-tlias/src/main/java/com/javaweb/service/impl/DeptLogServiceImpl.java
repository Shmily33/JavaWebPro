package com.javaweb.service.impl;

import com.javaweb.mapper.DeptLogMapper;
import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.DeptLog;
import com.javaweb.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gs_wang
 * @Date: 2024/07/04/上午10:46
 * @Description:
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}

