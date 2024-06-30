# 笔记文档地址：[https://www.yuque.com/bwywb/yg8g4f/pcnsmmwa7chc67q6](https://www.yuque.com/bwywb/yg8g4f/pcnsmmwa7chc67q6)
# Day01
## 1 HTML-CSS
# Day02
## 1 JavaScript
## 2 Vue
## 2.1 案例
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719044025898-dd06b379-8ac9-415f-88ba-5221afe694ef.png#averageHue=%23faf9f8&clientId=u5a596626-61a7-4&from=paste&height=474&id=ykk85&originHeight=592&originWidth=1229&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=103906&status=done&style=none&taskId=u030dfa9d-f27c-4d9c-9626-c34485332bd&title=&width=983.2)
## 3 Ajax
## 4 Vue-ElementUI
## 4.1 案例
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719061520929-89489198-4060-4609-9187-27b89ebe2aa0.png#averageHue=%23f9f7f6&clientId=uddbcafc8-c6a8-4&from=paste&height=476&id=u4c2baca0&originHeight=595&originWidth=1202&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=160210&status=done&style=none&taskId=ub308404d-6da0-46dc-8ce1-92451945d96&title=&width=961.6)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719061895172-7b7c82b4-0a76-440f-ad04-42a03b72edeb.png#averageHue=%23f9f5ed&clientId=uddbcafc8-c6a8-4&from=paste&height=478&id=u4bcbebca&originHeight=598&originWidth=1195&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=77047&status=done&style=none&taskId=ueab7cec3-2a31-47c6-8f04-9e33731d7e0&title=&width=956)
### 效果：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719066435043-e2fc60e4-07fe-4be1-b294-b7546e61d75a.png#averageHue=%23fbfaf9&clientId=uc0aa0b06-cc87-4&from=paste&height=799&id=ud4d4505f&originHeight=999&originWidth=1911&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=186735&status=done&style=none&taskId=u4b2d2749-6c41-42b4-9d93-2628d77df4a&title=&width=1528.8)
### ps:
1、仓库没有node_modules文件，clone下来先npm i安装一下相关引入
2、先运行start.bat文件，axios调用了相关接口
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719067250246-5efbcd05-57f4-45dc-be89-4f562dd315ab.png#averageHue=%2321201f&clientId=uc0aa0b06-cc87-4&from=paste&height=152&id=udeba2d0b&originHeight=190&originWidth=874&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=19833&status=done&style=none&taskId=ufb52ce36-6be2-4283-924c-ea6e17af5e9&title=&width=699.2)
# Day03
## 1 Maven相关知识
# Day04、Day04-test
## 1 SpringBoot快速入门
## 2 SpringBootWeb请求、响应
## 3 案例
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719658499769-b2b8edce-449a-4a42-94c6-05445ce9ab0e.png#averageHue=%23f8f2f0&clientId=u5b6df6d4-e367-4&from=paste&height=487&id=uf4ceebe5&originHeight=609&originWidth=1261&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=170494&status=done&style=none&taskId=u60298639-5f19-4415-aceb-f3e61e0f4b9&title=&width=1008.8)
### 3.1 tips:
#### 3.1.1 Maven添加阿里云镜像[https://www.yuque.com/bwywb/yg8g4f/amxuo4rqkl5vzgq8](https://www.yuque.com/bwywb/yg8g4f/amxuo4rqkl5vzgq8)
#### 3.1.2 防止中文路径名报错
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719660839548-23b0b1fc-5bfe-4e36-a262-4364d1abf0bd.png#averageHue=%23282a2e&clientId=u34b0b673-2ac9-4&from=paste&height=539&id=ua7929a73&originHeight=674&originWidth=1920&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=181403&status=done&style=none&taskId=uea5be86b-6891-472d-aa35-190b3aeb5e8&title=&width=1536)
#### 未解耦前逻辑代码

```java
package com.javaweb.controller;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.Result;
import com.javaweb.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gs_wang
 * @Date: 2024/06/29/下午7:04
 * @Description:
 */
@RestController
public class EmpController {

    @RequestMapping("/listEmp")
    public Result list() {
        // 1、加载并解析emp.html
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 2、对数据进行转换处理-gender, job
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            } else {
                emp.setGender("——");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            } else {
                emp.setJob("——");
            }

        });

        // 3、响应数据
        return Result.success(empList);

    }

}

```
#### MVC解耦
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719664730161-471578f5-a771-4ab4-930c-34cdd329b874.png#averageHue=%232c2e32&clientId=u9a9b1079-76df-4&from=paste&height=566&id=uc1a895c0&originHeight=708&originWidth=735&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=63738&status=done&style=none&taskId=uc7cb4495-e0d8-4088-96d5-90cf915ec29&title=&width=588)
#### 效果
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719661313050-e3f62b4b-2172-4ae3-aed5-017cb8f5a0e5.png#averageHue=%23fbfafa&clientId=u34b0b673-2ac9-4&from=paste&height=620&id=u5592f3be&originHeight=775&originWidth=1920&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=103257&status=done&style=none&taskId=u401ed3aa-d97c-4ef1-b62a-b4125d09b51&title=&width=1536)
# Day05
## 1 MySQL相关知识

