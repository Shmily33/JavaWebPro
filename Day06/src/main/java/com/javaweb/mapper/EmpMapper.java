package com.javaweb.mapper;

import com.javaweb.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/01/15:08
 * @Description:
 */
@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    public List<Emp> list(String name);
}
