package com.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: gs_wang
 * @Date: 2024/07/01/15:04
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emp {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private short gender;
    private String image;
    private short job;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deptId;

}
