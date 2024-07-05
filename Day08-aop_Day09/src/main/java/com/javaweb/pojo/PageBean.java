package com.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午4:09
 * @Description: 分页查询结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total; // 总记录数
    private List rows; // 结果列表

}
