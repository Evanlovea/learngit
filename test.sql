/*
Navicat MySQL Data Transfer

Source Server         : evan
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-02 19:54:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminname` varchar(20) NOT NULL,
  `adminpwd` varchar(20) NOT NULL,
  PRIMARY KEY (`adminname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员信息表';

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('evan', '123456');
INSERT INTO `admininfo` VALUES ('jack', '123456');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` varchar(20) NOT NULL COMMENT '课程号',
  `courseName` varchar(20) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('2', 'math');
INSERT INTO `course` VALUES ('3', 'os');
INSERT INTO `course` VALUES ('5', 'chinese');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `stuId` varchar(20) NOT NULL,
  `courseId` varchar(20) NOT NULL,
  `grade` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`stuId`,`courseId`),
  KEY `stuId` (`stuId`),
  KEY `sc_ibfk_2` (`courseId`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `stuinfo` (`stuId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生选课表';

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('2016', '2', '90');
INSERT INTO `sc` VALUES ('2016', '3', '50');
INSERT INTO `sc` VALUES ('2017', '3', '60');
INSERT INTO `sc` VALUES ('2018', '2', '70');

-- ----------------------------
-- Table structure for `stuinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo` (
  `stuId` varchar(20) NOT NULL COMMENT '学生学号',
  `stuName` varchar(20) NOT NULL COMMENT '学生姓名',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- ----------------------------
-- Records of stuinfo
-- ----------------------------
INSERT INTO `stuinfo` VALUES ('2016', 'evani', '1234');
INSERT INTO `stuinfo` VALUES ('2017', 'mark', '12345');
INSERT INTO `stuinfo` VALUES ('2018', 'zd', '1234');

-- ----------------------------
-- Table structure for `teacherinfo`
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `teacherId` varchar(20) NOT NULL COMMENT '教工号',
  `teacherName` varchar(20) NOT NULL COMMENT '教师姓名',
  `tno` varchar(20) NOT NULL COMMENT '所教课程号',
  `tPassword` varchar(20) NOT NULL COMMENT '教工登录密码',
  PRIMARY KEY (`teacherId`),
  KEY `tno` (`tno`),
  CONSTRAINT `tno` FOREIGN KEY (`tno`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师信息表';

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('0102', 'dasfd', '2', '12456');
INSERT INTO `teacherinfo` VALUES ('0103', 'ease', '3', '123456');
INSERT INTO `teacherinfo` VALUES ('0104', 'efads', '5', 'das');
