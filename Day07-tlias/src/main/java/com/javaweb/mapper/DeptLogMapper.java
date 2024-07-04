package com.javaweb.mapper;

import com.javaweb.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: gs_wang
 * @Date: 2024/07/04/上午10:47
 * @Description:
 */
@Mapper
public interface DeptLogMapper {

    @Insert("insert into tlias.dept_log(create_time,description) values(#{createTime},#{description})")
    void insert(DeptLog log);

}
