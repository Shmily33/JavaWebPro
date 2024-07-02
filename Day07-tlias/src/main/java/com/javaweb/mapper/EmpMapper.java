package com.javaweb.mapper;

import com.javaweb.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from tlias.emp where id = #{id}")
    Emp queryById(Integer id);


    void update(Emp emp);

    @Select("select * from tlias.emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
