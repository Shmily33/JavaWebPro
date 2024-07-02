package com.javaweb.mapper;

import com.javaweb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:13
 * @Description:
 */
@Mapper
public interface EmpMapper {

    @Select("select count(*) from tlias.emp")
    public Long count();

    // 分页+员工信息查询
    //@Select("select * from tlias.emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize, String name, Short gender,
                          LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);
}
