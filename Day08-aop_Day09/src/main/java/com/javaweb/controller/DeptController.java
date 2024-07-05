package com.javaweb.controller;

import com.javaweb.pojo.Dept;
import com.javaweb.pojo.Result;
import com.javaweb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午2:16
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping ("/depts")
public class DeptController {

    //    private static Logger log = LoggerFactory.getLogger(DeptController.class); -> @Slf4j
    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET) // 指定请求方式GET
    @GetMapping
    public Result list() {
        log.info("查询全部的部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception { // 拼接的路径参数@PathVariable
        log.info("根据id删除部门:{}", id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result query(@PathVariable Integer id) { // 拼接的路径参数@PathVariable
        log.info("根据id查询部门:{}", id);
        Dept dept = deptService.query(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) { // 拼接的路径参数@PathVariable
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }



}
