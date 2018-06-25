/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_student

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-20 11:02:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `grade` varchar(50) DEFAULT NULL COMMENT '年级',
  `class_name` varchar(100) DEFAULT NULL COMMENT '班级姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `course_name` varchar(100) DEFAULT NULL COMMENT '课程姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------

-- ----------------------------
-- Table structure for `t_elective`
-- ----------------------------
DROP TABLE IF EXISTS `t_elective`;
CREATE TABLE `t_elective` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课ID',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生ID',
  `course_id` int(11) DEFAULT NULL COMMENT '课程ID',
  `score` double DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_elective
-- ----------------------------

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stu_num` int(50) DEFAULT NULL COMMENT '学号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `class_id` int(11) DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `tea_name` varchar(100) DEFAULT NULL COMMENT '教师姓名',
  `tea_num` varchar(100) DEFAULT NULL COMMENT '教师编号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
