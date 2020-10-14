/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-01-06 09:00:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', '陈老师', 'chen', '123');
INSERT INTO `admins` VALUES ('2', '王老师', 'wang', '123');

-- ----------------------------
-- Table structure for backs
-- ----------------------------
DROP TABLE IF EXISTS `backs`;
CREATE TABLE `backs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `borrows_id` (`brid`),
  CONSTRAINT `borrows_id` FOREIGN KEY (`brid`) REFERENCES `borrows` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backs
-- ----------------------------

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `birth` varchar(20) DEFAULT NULL,
  `edition` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sort_id` (`sid`),
  CONSTRAINT `sort_id` FOREIGN KEY (`sid`) REFERENCES `sorts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'C++', '1', '5', '李广丽', '清华大学出版社', '第四版');
INSERT INTO `books` VALUES ('2', 'JAVA基础', '1', '10', '梁建武', '清华大学出版社', '第二版');
INSERT INTO `books` VALUES ('3', '高等数学', '2', '10', '林海明', '清华大学出版社', '第一版');
INSERT INTO `books` VALUES ('4', '数据结构', '1', '5', '杨磊', '广海大学出版社', '第二版');
INSERT INTO `books` VALUES ('5', '大学英语1', '4', '5', '李根强', '清华大学出版社', '第二版');
INSERT INTO `books` VALUES ('6', '大学英语3', '4', '5', '程燕', '清华大学出版社', '第二版');
INSERT INTO `books` VALUES ('7', '大学英语2', '4', '5', '罗丽渊', '广海大学出版社', '第五版');
INSERT INTO `books` VALUES ('8', '电子电工技术', '2', '5', '周杰伦', '上海交通大学出版社', '第八版');
INSERT INTO `books` VALUES ('9', '汇编语言', '2', '5', '雪虎', '中国铁道出版社', '第七版');
INSERT INTO `books` VALUES ('10', '大学生心理健康', '1', '5', '卢本伟', '中国铁道出版社', '第十版');
INSERT INTO `books` VALUES ('11', '操作系统', '1', '5', '卢家心', '辽宁出版社', '第二版');
INSERT INTO `books` VALUES ('13', '大学英语4', '3', '5', '林耀东', '辽宁出版社', '第一版');
INSERT INTO `books` VALUES ('14', '应用文', '4', '5', '普营山', '辽宁出版社', '第四版');

-- ----------------------------
-- Table structure for borrows
-- ----------------------------
DROP TABLE IF EXISTS `borrows`;
CREATE TABLE `borrows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`uid`),
  KEY `book_id` (`bid`),
  CONSTRAINT `book_id` FOREIGN KEY (`bid`) REFERENCES `books` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`uid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrows
-- ----------------------------

-- ----------------------------
-- Table structure for reserves
-- ----------------------------
DROP TABLE IF EXISTS `reserves`;
CREATE TABLE `reserves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `bkid` int(11) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `books_id2` (`bkid`),
  KEY `user_id2` (`uid`),
  CONSTRAINT `books_id2` FOREIGN KEY (`bkid`) REFERENCES `books` (`id`),
  CONSTRAINT `user_id2` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserves
-- ----------------------------

-- ----------------------------
-- Table structure for sorts
-- ----------------------------
DROP TABLE IF EXISTS `sorts`;
CREATE TABLE `sorts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sorts
-- ----------------------------
INSERT INTO `sorts` VALUES ('1', '计算机类');
INSERT INTO `sorts` VALUES ('2', '数学类');
INSERT INTO `sorts` VALUES ('3', '英语类');
INSERT INTO `sorts` VALUES ('4', '语文类');
INSERT INTO `sorts` VALUES ('5', '1111');

-- ----------------------------
-- Table structure for sysadmin
-- ----------------------------
DROP TABLE IF EXISTS `sysadmin`;
CREATE TABLE `sysadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysadmin
-- ----------------------------
INSERT INTO `sysadmin` VALUES ('1', '杨老板', 'yang', '123');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '张三', 'zhangsan', '123');
