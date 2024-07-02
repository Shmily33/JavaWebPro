package com.javaweb.controller;

import com.javaweb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: gs_wang
 * @Date: 2024/07/02/下午7:45
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}，{}，{}", username, age, image);
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一文件名（不能重复） - uuid(通用唯一识别码)
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID() + extname;

        // 将文件存储在服务器的磁盘目录 D:\Nginx
        image.transferTo(new File("D:\\Nginx\\"+newFileName));

        return Result.success();
    }

}
