package com.javaweb.mapper;

import com.javaweb.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:12
 * @Description:
 */
@Mapper
public interface DeptMapper {

    @Select("select * from tlias.dept")
    List<Dept> list();

    @Delete("delete from tlias.dept where id =#{id}")
    void deleteById(Integer id);

    @Insert("insert into tlias.dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);

    @Select("select * from tlias.dept where id = #{id}")
    Dept queryById(Integer id);

    @Update("update tlias.dept set name = #{name} where id =#{id}")
    void update(Dept dept);


}
