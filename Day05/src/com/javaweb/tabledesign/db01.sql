/*
 Navicat Premium Data Transfer

 Source Server         : db01
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : db01

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 30/06/2024 20:28:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, 'Java');
INSERT INTO `tb_course` VALUES (2, 'PHP');
INSERT INTO `tb_course` VALUES (3, 'MySQL');
INSERT INTO `tb_course` VALUES (4, 'Hadoop');

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (1, '学工部', '2024-06-30 18:58:36', '2024-06-30 18:58:36');
INSERT INTO `tb_dept` VALUES (2, '教研部', '2024-06-30 18:58:36', '2024-06-30 18:58:36');
INSERT INTO `tb_dept` VALUES (3, '咨询部', '2024-06-30 18:58:36', '2024-06-30 18:58:36');
INSERT INTO `tb_dept` VALUES (4, '就业部', '2024-06-30 18:58:36', '2024-06-30 18:58:36');
INSERT INTO `tb_dept` VALUES (5, '人事部', '2024-06-30 18:58:36', '2024-06-30 18:58:36');

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` tinyint(3) UNSIGNED NOT NULL COMMENT '性别，1 男，2 女',
  `image` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图像url',
  `job` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '职位',
  `entrydate` date NULL DEFAULT NULL COMMENT '入职日期',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `dept_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tb_emp_pk`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
INSERT INTO `tb_emp` VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 1, '2007-02-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 1, '2008-08-18', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 1);
INSERT INTO `tb_emp` VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 2, '2012-11-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2010-01-01', '2024-06-30 19:00:02', '2024-06-30 19:00:02', 2);
INSERT INTO `tb_emp` VALUES (17, 'chenyouliang', '123456', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', '2024-06-30 19:00:02', '2024-06-30 19:00:02', NULL);

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, '黛绮丝', '2000100101');
INSERT INTO `tb_student` VALUES (2, '谢逊', '2000100102');
INSERT INTO `tb_student` VALUES (3, '殷天正', '2000100103');
INSERT INTO `tb_student` VALUES (4, '韦一笑', '2000100104');

-- ----------------------------
-- Table structure for tb_student_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_course`;
CREATE TABLE `tb_student_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` int(11) NOT NULL COMMENT '学生ID',
  `course_id` int(11) NOT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseid`(`course_id`) USING BTREE,
  INDEX `fk_studentid`(`student_id`) USING BTREE,
  CONSTRAINT `fk_courseid` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentid` FOREIGN KEY (`student_id`) REFERENCES `tb_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生课程中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student_course
-- ----------------------------
INSERT INTO `tb_student_course` VALUES (1, 1, 1);
INSERT INTO `tb_student_course` VALUES (2, 1, 2);
INSERT INTO `tb_student_course` VALUES (3, 1, 3);
INSERT INTO `tb_student_course` VALUES (4, 2, 2);
INSERT INTO `tb_student_course` VALUES (5, 2, 3);
INSERT INTO `tb_student_course` VALUES (6, 3, 4);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` tinyint(3) UNSIGNED NOT NULL COMMENT '性别, 1 男  2 女',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `degree` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '白眉鹰王', 1, '18812340001', '初中');
INSERT INTO `tb_user` VALUES (2, '青翼蝠王', 1, '18812340002', '大专');
INSERT INTO `tb_user` VALUES (3, '金毛狮王', 1, '18812340003', '初中');
INSERT INTO `tb_user` VALUES (4, '紫衫龙王', 2, '18812340004', '硕士');

-- ----------------------------
-- Table structure for tb_user_card
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_card`;
CREATE TABLE `tb_user_card`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nationality` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '民族',
  `birthday` date NOT NULL COMMENT '生日',
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `issued` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '签发机关',
  `expire_begin` date NOT NULL COMMENT '有效期限-开始',
  `expire_end` date NULL DEFAULT NULL COMMENT '有效期限-结束',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_card
-- ----------------------------
INSERT INTO `tb_user_card` VALUES (1, '汉', '1960-11-06', '100000100000100001', '朝阳区公安局', '2000-06-10', NULL, 1);
INSERT INTO `tb_user_card` VALUES (2, '汉', '1971-11-06', '100000100000100002', '静安区公安局', '2005-06-10', '2025-06-10', 2);
INSERT INTO `tb_user_card` VALUES (3, '汉', '1963-11-06', '100000100000100003', '昌平区公安局', '2006-06-10', NULL, 3);
INSERT INTO `tb_user_card` VALUES (4, '回', '1980-11-06', '100000100000100004', '海淀区公安局', '2008-06-10', '2028-06-10', 4);

SET FOREIGN_KEY_CHECKS = 1;
