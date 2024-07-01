package com.javaweb.mapper;

import com.javaweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/01/下午2:13
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from tb_user")
    public List<User> list();
}
