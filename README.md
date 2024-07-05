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
# Day06
## 1 MyBatis相关知识
# Day07（综合案例）
## 1 展示
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719900003428-af3bdac5-2996-4a88-b1b3-56961f84bb9b.png#averageHue=%23d2b7a9&clientId=u00ef7868-d0cb-4&from=paste&height=474&id=u6229eb04&originHeight=593&originWidth=1223&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=151503&status=done&style=none&taskId=uaaf96a05-f00c-445a-a965-5f92f7ab03b&title=&width=978.4)
## 2 环境搭建
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719900120598-32372cea-0a19-4c46-93be-a5267e2ecdf4.png#averageHue=%23f4f1ef&clientId=u00ef7868-d0cb-4&from=paste&height=471&id=u2824ac20&originHeight=589&originWidth=1221&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=157552&status=done&style=none&taskId=uee5fdb02-cd84-485c-a0fa-9afe94f97e9&title=&width=976.8)
## 3 开发规范
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719901266499-d3119062-385b-4a26-846c-f90dc29e9089.png#averageHue=%23f7f5f3&clientId=u00ef7868-d0cb-4&from=paste&height=430&id=u9249bfb4&originHeight=537&originWidth=1181&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=142469&status=done&style=none&taskId=u102a8b10-023b-4fa2-b1c3-986b3a03218&title=&width=944.8)
### Restful
传统的繁杂混乱，restful的简洁易维护
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719901374000-175adf57-f279-4de9-a0f9-c176bc07926b.png#averageHue=%23f9f4e6&clientId=u00ef7868-d0cb-4&from=paste&height=459&id=uf224fb3a&originHeight=574&originWidth=1228&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=79841&status=done&style=none&taskId=u63d48b47-7b03-400d-a594-514a5c2c755&title=&width=982.4)
#### 注意事项
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719901524307-b18325f2-e6cf-4e41-9981-1aaddce59687.png#averageHue=%23f3eded&clientId=u00ef7868-d0cb-4&from=paste&height=117&id=ua5e5e0d9&originHeight=146&originWidth=1144&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=15032&status=done&style=none&taskId=uea54682d-07f0-475f-94a9-9408fdc36de&title=&width=915.2)
### 统一响应结果
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719901556155-c4ae4562-d313-435c-80d4-715e8d85bec7.png#averageHue=%23faf9e5&clientId=u00ef7868-d0cb-4&from=paste&height=487&id=u15a80633&originHeight=609&originWidth=698&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=57593&status=done&style=none&taskId=ue6f5cdd7-d131-4fdf-b4f6-f5de78ce7b1&title=&width=558.4)
# Day08
## 1 AOP相关知识
## 2 Spring原理相关知识
# Day09
## 1 Bean相关知识
## 2 Maven高级相关知识
# 开发记录
## 1 private static Logger -> @Slf4j
private static Logger log = LoggerFactory.getLogger(DeptController.class); 为什么要定义成静态的
在Java中，将日志记录器定义为静态的是一种常见的做法，有几个主要的原因：

1. **资源共享和性能考虑：**
    - 静态日志记录器只会在内存中存在一份。这意味着，不论创建多少次该类的实例，它们都会共享同一个日志记录器。这种方式避免了每次创建新对象时都要重新分配日志记录器的内存空间，从而节省了内存。
    - 同时，静态变量的加载是在类加载时进行的，不需要等到对象创建时才初始化，因此在性能上会稍微快一些。
2. **简化日志记录的调用：**
    - 通过静态变量定义日志记录器，可以直接在类的任何地方使用日志记录器，而不需要每次都通过对象实例来获取日志记录器。这样做可以减少代码量，并且更清晰地表达出这个类使用的是哪个日志记录器。
3. **符合日志记录器的最佳实践：**
    - 许多日志框架建议将日志记录器定义为类的静态变量。这种做法不仅在性能上更高效，而且也能保持代码的一致性和清晰度，让其他开发者更容易理解和维护代码。

综上所述，将日志记录器定义为静态变量是一种良好的编程实践，可以提高性能、减少资源消耗，并且使代码更加清晰和易于维护。
## 2 Nginx启动不了
#### 1、要解压放在无中文的路径下
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719903425694-0e9839b7-ea10-4e32-be53-09fdee7dbcb9.png#averageHue=%23edf1f3&clientId=u97436040-4541-4&from=paste&height=62&id=u46de7c98&originHeight=77&originWidth=627&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=6233&status=done&style=none&taskId=ud1d3e8c0-7f8c-46a8-8d40-5792f487936&title=&width=501.6)
#### 2、以管理员身份启动
## 3 @RequestMapping
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719905403040-d57c9c8f-f707-4a59-81bc-f9cf6b35a51e.png#averageHue=%23fbf8f8&clientId=ueab90846-c17f-4&from=paste&height=484&id=ubc1938e2&originHeight=605&originWidth=1210&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=169641&status=done&style=none&taskId=u413008f0-56db-471b-9875-00384d4f8f1&title=&width=968)
## 4 分页查询
## 4.1 语法
```sql
-- 参数1：起始索引 => (页码-1)*每页展示记录数
-- 参数2：查询返回记录数 => 每页展示记录

select * from emp limit 0,5;

-- 查询第一页
select * from emp limit 0,5;

-- 查询第二页
select * from emp limit 5,5;

-- 获取总记录数
select count(*) from emp
```
## 4.2 分析
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719907548870-439ccb07-1c99-49a4-94f3-c83cd7511ec3.png#averageHue=%23fbf7f5&clientId=ueab90846-c17f-4&from=paste&height=478&id=ue85d9750&originHeight=597&originWidth=1244&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=87201&status=done&style=none&taskId=uc3af2113-e776-46c6-9507-4f23f989195&title=&width=995.2)
## 4.3 查询
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719907738942-cc57e914-f78a-4cfc-9532-60e2f064af16.png#averageHue=%23f9f2ee&clientId=ueab90846-c17f-4&from=paste&height=489&id=u82ac6422&originHeight=611&originWidth=1229&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=104402&status=done&style=none&taskId=u129f0385-d617-44d1-9054-d8ba94984d6&title=&width=983.2)
### PageHelper
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719909043363-64ff36b3-bbdb-4889-b397-cf9f5cdbc7ca.png#averageHue=%23fbf4f1&clientId=ueab90846-c17f-4&from=paste&height=486&id=u9fa36c19&originHeight=607&originWidth=1275&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=231696&status=done&style=none&taskId=u58e1c322-1583-4a58-87f4-b0990951a4f&title=&width=1020)
## 5 批量删除
```sql
delete from emp where id in (1,2,3)
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719917516467-e9d1e7dd-b50d-40f6-885e-cf3cb365af7d.png#averageHue=%23f7ecdb&clientId=u12192fb0-cddf-4&from=paste&height=366&id=ub58e0ea7&originHeight=457&originWidth=1233&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=49154&status=done&style=none&taskId=u8a261561-3131-461b-8d57-9180103f9b3&title=&width=986.4)
## 6 文件上传
### 6.1 简介
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719920252291-9a2a1a40-c197-48d1-844a-2a1296b4e038.png#averageHue=%23f8f6f2&clientId=ud7996747-c205-4&from=paste&height=494&id=ufc360231&originHeight=618&originWidth=1200&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=154409&status=done&style=none&taskId=ucaf26f4c-7306-4855-a524-986be092972&title=&width=960)
### 6.2 格式
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719920400573-0bd14b7f-8c49-4347-bd9a-6f277b7e7518.png#averageHue=%232d3035&clientId=ud7996747-c205-4&from=paste&height=538&id=u11323a56&originHeight=673&originWidth=823&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=82718&status=done&style=none&taskId=u59a54959-52ad-4831-88f3-568fbdda45e&title=&width=658.4)
### 6.3 本地存储
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719921048637-e9f4c73c-78cd-4bf9-bc1d-d65c123e7feb.png#averageHue=%23f8f8ea&clientId=ud7996747-c205-4&from=paste&height=445&id=uf4c4254b&originHeight=556&originWidth=1253&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=193580&status=done&style=none&taskId=ub66372b4-20a1-41db-ad2e-bfeffbac71d&title=&width=1002.4)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719921062101-df9507b2-5406-46c4-81a7-aa18a3cd8218.png#averageHue=%23faf7ee&clientId=ud7996747-c205-4&from=paste&height=400&id=u3a90e04d&originHeight=500&originWidth=1196&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=179000&status=done&style=none&taskId=u2f1ff673-cbe5-4cb1-ae43-e9c2392e013&title=&width=956.8)
#### 代码
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719922676699-d376e9fd-af6b-446c-ad7a-0749e908acfc.png#averageHue=%23f9fbdc&clientId=ud7996747-c205-4&from=paste&height=170&id=u210e2d4e&originHeight=212&originWidth=595&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=26120&status=done&style=none&taskId=u77c8ddea-4bb7-4236-bed9-08cd4928532&title=&width=476)
```java
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
```
### 6.4 阿里云OSS
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719922719776-ca6e8794-e232-4db0-95cf-e9001193a261.png#averageHue=%23f7f4f1&clientId=ud7996747-c205-4&from=paste&height=322&id=u9c94a4fa&originHeight=402&originWidth=1204&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=227138&status=done&style=none&taskId=u4ffc5de1-2be4-4a38-a84b-4c62d9c218f&title=&width=963.2)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719922750465-ecf5fe34-fa2b-4ced-b0ef-5e3982c421e8.png#averageHue=%23fbf8f5&clientId=ud7996747-c205-4&from=paste&height=474&id=u644c1df5&originHeight=592&originWidth=1214&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=58233&status=done&style=none&taskId=uf9f5e13d-6c9d-4955-af10-ca92cfd0275&title=&width=971.2)
## 7 配置文件
### 7.1 参数配置化
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925757153-a0afd9a2-054f-42d5-994f-2b77063a577d.png#averageHue=%23fcf5f1&clientId=ud7996747-c205-4&from=paste&height=468&id=u0fddd2f6&originHeight=585&originWidth=1108&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=110057&status=done&style=none&taskId=u4ff97231-f2f9-4ef9-ada4-8a25889b130&title=&width=886.4)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925765648-1f3cd131-b285-4059-848c-dcc3c51666d6.png#averageHue=%23fdfbfb&clientId=ud7996747-c205-4&from=paste&height=460&id=ud0fa5fbb&originHeight=575&originWidth=1234&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=201246&status=done&style=none&taskId=u2f730c5f-328b-4c99-a0e6-ca034420e7e&title=&width=987.2)
### 7.2 yml文件
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925836706-cf9c68fa-ecec-4784-8239-854a5bbe5131.png#averageHue=%23fcf7f5&clientId=ud7996747-c205-4&from=paste&height=467&id=ucf2b187b&originHeight=584&originWidth=1243&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=117714&status=done&style=none&taskId=u4d422578-c929-46e4-b390-a801b0843a7&title=&width=994.4)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925829206-ea3c125e-b830-4408-8ef3-11a132f0cf5e.png#averageHue=%23f9f7f7&clientId=ud7996747-c205-4&from=paste&height=473&id=u37388674&originHeight=591&originWidth=1209&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=44431&status=done&style=none&taskId=u27c935ae-26d4-4ee9-9417-7c04ba6d020&title=&width=967.2)
##### 数据格式
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925851800-bf596a01-0adb-4e1d-aa6c-9ca9032447f6.png#averageHue=%23fcfcef&clientId=ud7996747-c205-4&from=paste&height=406&id=ue11d721d&originHeight=507&originWidth=1151&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=30240&status=done&style=none&taskId=ua55d5a05-c2fa-4876-8635-347aea0f320&title=&width=920.8)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925866014-168a8ac6-f198-4a6d-a704-442c611d98d4.png#averageHue=%23fbf8f6&clientId=ud7996747-c205-4&from=paste&height=464&id=u7c76206a&originHeight=580&originWidth=1208&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=242361&status=done&style=none&taskId=uadea0fec-d5bc-4e8b-8544-d29d71efd36&title=&width=966.4)
### 7.3@ConfigurationProperties
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719925903328-a35d8fac-9f72-458a-b8eb-825341c9f936.png#averageHue=%23faf5f5&clientId=ud7996747-c205-4&from=paste&height=381&id=u010a24d6&originHeight=476&originWidth=1194&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=33966&status=done&style=none&taskId=u85951d43-6792-4d8d-977a-a8eff45ae32&title=&width=955.2)
## 8 登录认证
### 8.1 登录功能
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719926919069-c0e7d3f9-cc19-47cd-b565-597d74f94460.png#averageHue=%23faf2e6&clientId=ud7996747-c205-4&from=paste&height=465&id=BgAaT&originHeight=581&originWidth=1204&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=69167&status=done&style=none&taskId=ubd77c93b-234b-4efd-bb46-2b5a578b35f&title=&width=963.2)

### 8.2 登录校验
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719927634244-96cfbaf0-a240-4803-9617-39521f5c015e.png#averageHue=%23f9f1e2&clientId=ud7996747-c205-4&from=paste&height=469&id=nVpYN&originHeight=586&originWidth=1215&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=73025&status=done&style=none&taskId=uda26ec3b-fdb9-4606-aec3-154aba929a2&title=&width=972)
#### 8.2.1 会话技术
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719927813040-409c68f5-ee71-43c7-8c9f-802f34d9e858.png#averageHue=%23f8f5e9&clientId=ud7996747-c205-4&from=paste&height=479&id=B30IQ&originHeight=599&originWidth=1225&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=86873&status=done&style=none&taskId=u72532d7d-6c05-42e3-abea-514114724b8&title=&width=980)
##### 跟踪方案对比
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719927845412-8a937f21-58f5-419e-90fa-09a7dc7a70f9.png#averageHue=%23f8eddc&clientId=ud7996747-c205-4&from=paste&height=470&id=R0B1Q&originHeight=588&originWidth=1171&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=119386&status=done&style=none&taskId=u5dda2110-1adc-4e75-aba4-12e92a5d26b&title=&width=936.8)
#### 8.2.2 JWT令牌
[https://jwt.io/](https://jwt.io/)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719988547886-17ae77d7-4fa7-45ad-a3ed-ab8fb86322c8.png#averageHue=%23f8f3f1&clientId=u3ee269e9-b473-4&from=paste&height=686&id=ZywAl&originHeight=858&originWidth=1829&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=142792&status=done&style=none&taskId=u7b69d56f-4865-4b6c-b2fb-511005dfbf8&title=&width=1463.2)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719988645097-b71a607e-c3ad-4201-af70-145da60a9330.png#averageHue=%23faf8e7&clientId=u3ee269e9-b473-4&from=paste&height=456&id=hk3zW&originHeight=570&originWidth=1175&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=59399&status=done&style=none&taskId=u3481923a-8280-411e-8111-d40d2dc5c8b&title=&width=940)
```java
 @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "javaweb") // 签名算法
                .setClaims(claims) // 自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser().setSigningKey("javaweb")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxOTk5MzI1Nn0.AowPp5e0jtTVG9CoPali7NnNKDWjhg8T_LenGNbNx1c")
                .getBody();
        System.out.println(claims);
    }
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719990058266-08043ca7-a4ba-464f-b47a-f467d51a80d4.png#averageHue=%23f6f2f2&clientId=u3ee269e9-b473-4&from=paste&height=132&id=GJxqp&originHeight=165&originWidth=1172&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=15299&status=done&style=none&taskId=ue691bc70-5088-4cb9-aa7b-ff4ba60ec18&title=&width=937.6)
#### 8.2.3 过滤器(Filter)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719990701603-5fd6866e-6bb5-4f95-b165-73fcf5b64415.png#averageHue=%23f9f4e6&clientId=u3ee269e9-b473-4&from=paste&height=468&id=vt3o3&originHeight=585&originWidth=1202&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=64582&status=done&style=none&taskId=u22d5d089-32b9-4fe4-a718-1f8b28f0bd5&title=&width=961.6)
##### 快速入门
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719990729353-4414db92-7da1-4f06-8115-88d639db428f.png#averageHue=%23fbf6f5&clientId=u3ee269e9-b473-4&from=paste&height=482&id=kzmzQ&originHeight=602&originWidth=1256&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=153181&status=done&style=none&taskId=u985fc170-f96e-4020-b4be-a5146ed6653&title=&width=1004.8)
##### 执行流程
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719991332816-83f124c4-acfb-4534-b4ba-5410fada34f0.png#averageHue=%23f9f4e8&clientId=u3ee269e9-b473-4&from=paste&height=500&id=nOawe&originHeight=625&originWidth=1293&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=107130&status=done&style=none&taskId=u3e846a09-7a18-43bf-9c89-4762bd09a92&title=&width=1034.4)
##### 拦截路径
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719991447583-f174fe83-23a1-448f-b480-840a19165e2c.png#averageHue=%23eac6c6&clientId=u3ee269e9-b473-4&from=paste&height=285&id=ppcnA&originHeight=356&originWidth=1163&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=48486&status=done&style=none&taskId=u284c023e-3177-43c7-b59b-71de4057aac&title=&width=930.4)
##### 过滤器链![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719991674612-8732a4b8-3314-4da0-95f6-a2b4ef6f0f9c.png#averageHue=%23f9f1e1&clientId=u3ee269e9-b473-4&from=paste&height=676&id=sTSGb&originHeight=845&originWidth=1689&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=125974&status=done&style=none&taskId=u43ccb8fa-2b8a-489c-9f01-8216df4450a&title=&width=1351.2)
##### 登录校验
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719991538820-4b146a2f-006d-4a69-8d75-ac9a711d2e5e.png#averageHue=%23faf3de&clientId=u3ee269e9-b473-4&from=paste&height=450&id=ZtE3H&originHeight=563&originWidth=1174&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=73382&status=done&style=none&taskId=u25db3fc3-4982-46ff-a719-be0ea6e3e90&title=&width=939.2)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719991560531-a63f0695-044c-475d-b5fb-f01756f6eb0f.png#averageHue=%23f1ebe7&clientId=u3ee269e9-b473-4&from=paste&height=467&id=oI047&originHeight=584&originWidth=1213&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=74390&status=done&style=none&taskId=ubdd189f4-8ea6-45b8-bd84-9512480afb9&title=&width=970.4)
#### 8.2.4 拦截器(Interceptor)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719995062684-605709d6-dc9d-488e-8e63-f5bea2b38583.png#averageHue=%23f9f5e7&clientId=u3ee269e9-b473-4&from=paste&height=680&id=eGTjJ&originHeight=850&originWidth=1725&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=108263&status=done&style=none&taskId=u01f71f8d-0b90-43e1-8223-9d1a2340702&title=&width=1380)
##### 快速入门
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719995101170-a812a523-441f-4dcf-8ea5-671c1a8f1634.png#averageHue=%23faf8f8&clientId=u3ee269e9-b473-4&from=paste&height=502&id=pWoTy&originHeight=628&originWidth=1250&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=174689&status=done&style=none&taskId=ub3aba85f-d410-4a67-bf98-1237d26719b&title=&width=1000)
##### 拦截路径
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719995691471-52762fe2-a2b7-4da2-8841-fd588d9d961e.png#averageHue=%23f0d7d7&clientId=u12cd807b-1b7d-4&from=paste&height=460&id=RREN4&originHeight=575&originWidth=1211&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=91077&status=done&style=none&taskId=uee0ef0d3-133e-495d-b5ff-1dcc1d64baf&title=&width=968.8)
##### 执行流程
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719995749741-6c0209ee-557d-4597-9296-14fe995aee27.png#averageHue=%23f4edec&clientId=u12cd807b-1b7d-4&from=paste&height=470&id=Efk6q&originHeight=587&originWidth=1197&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=78563&status=done&style=none&taskId=u8347acfc-1749-47bf-8083-b19f2c39ad4&title=&width=957.6)
##### 登录校验
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719995804830-34872a73-3423-42ec-b837-84ebc1909ae7.png#averageHue=%23f1ebe8&clientId=u12cd807b-1b7d-4&from=paste&height=491&id=FmZOr&originHeight=614&originWidth=1216&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=71985&status=done&style=none&taskId=uff9a001f-19ec-44b9-8c0f-bdb296bbd70&title=&width=972.8)
## 9 异常处理
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719996782332-1a23d9af-4d9e-4440-8620-bbaa2a045715.png#averageHue=%23f9f8f8&clientId=u12cd807b-1b7d-4&from=paste&height=319&id=ua50a26d5&originHeight=399&originWidth=824&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=33839&status=done&style=none&taskId=uc925b016-41f0-4a7a-9d6e-ac6f2b13414&title=&width=659.2)
### 全局异常处理器
![image.png](https://cdn.nlark.com/yuque/0/2024/png/35244370/1719996800977-391e8dc2-bb95-439f-8f13-56cbf88fe905.png#averageHue=%23fbf2ec&clientId=u12cd807b-1b7d-4&from=paste&height=476&id=u108a0fbc&originHeight=595&originWidth=1208&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=47901&status=done&style=none&taskId=ucc4e09d5-154c-49b7-a514-eee1cb9facb&title=&width=966.4)
