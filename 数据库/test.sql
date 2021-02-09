/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2021-02-09 14:30:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('2', '人事部', '张俊鹏');
INSERT INTO `dept` VALUES ('6', '管理部', '齐开凯');
INSERT INTO `dept` VALUES ('7', '财务部', '海洋');
INSERT INTO `dept` VALUES ('11', '卫生部', '闯闯');
INSERT INTO `dept` VALUES ('12', 'BOSS部', '的瓦');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `empno` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `sal` int(11) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `pwd` varchar(11) DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_ibfk_1` (`deptid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`deptid`) REFERENCES `dept` (`id`),
  CONSTRAINT `emp_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `roleinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('2', '李磊磊', '10017', '男', '8000', '2020-10-13', '111111', 'OIP.jfif', '2', '3');
INSERT INTO `emp` VALUES ('8', '琪琪', '10021', '男', '3000', '2018-01-18', '111111', 'OIP.jfif', '7', '2');
INSERT INTO `emp` VALUES ('9', '王闯', '10018', '女', '7000', '2021-1-1', '111111', 'OIP.jfif', '2', '3');
INSERT INTO `emp` VALUES ('10', '齐凯', '10019', '男', '4000', '2025-1-1', '111111', 'OIP.jfif', '2', '3');
INSERT INTO `emp` VALUES ('11', '海洋', '10029', '男', '1200', '1991-07-02', '111111', '1609225866097.jpg', '6', '2');
INSERT INTO `emp` VALUES ('13', '3饿', '100011', '男', '10000', '2021-02-09', '111111', 'OIP.jfif', '6', '3');
INSERT INTO `emp` VALUES ('14', 'sss', '10029', '男', '100000', '2021-02-08', '111111', 'OIP.jfif', '7', '3');
INSERT INTO `emp` VALUES ('15', '1111', '10036', '男', '1000', '2021-02-17', '111111', '1609225866097.jpg', '6', '3');

-- ----------------------------
-- Table structure for `privileges`
-- ----------------------------
DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges` (
  `role_id` int(11) DEFAULT NULL,
  `right_id` int(11) DEFAULT NULL,
  KEY `role_id` (`role_id`),
  KEY `right_id` (`right_id`),
  CONSTRAINT `privileges_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roleinfo` (`id`),
  CONSTRAINT `privileges_ibfk_2` FOREIGN KEY (`right_id`) REFERENCES `right` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privileges
-- ----------------------------
INSERT INTO `privileges` VALUES ('1', '1');
INSERT INTO `privileges` VALUES ('1', '3');
INSERT INTO `privileges` VALUES ('1', '4');
INSERT INTO `privileges` VALUES ('1', '5');
INSERT INTO `privileges` VALUES ('1', '6');
INSERT INTO `privileges` VALUES ('1', '7');
INSERT INTO `privileges` VALUES ('1', '8');
INSERT INTO `privileges` VALUES ('1', '9');
INSERT INTO `privileges` VALUES ('1', '10');
INSERT INTO `privileges` VALUES ('1', '11');
INSERT INTO `privileges` VALUES ('1', '12');
INSERT INTO `privileges` VALUES ('1', '13');
INSERT INTO `privileges` VALUES ('2', '3');
INSERT INTO `privileges` VALUES ('2', '4');
INSERT INTO `privileges` VALUES ('2', '5');
INSERT INTO `privileges` VALUES ('2', '6');
INSERT INTO `privileges` VALUES ('2', '7');
INSERT INTO `privileges` VALUES ('2', '8');
INSERT INTO `privileges` VALUES ('2', '9');
INSERT INTO `privileges` VALUES ('2', '11');
INSERT INTO `privileges` VALUES ('2', '12');
INSERT INTO `privileges` VALUES ('2', '13');
INSERT INTO `privileges` VALUES ('3', '3');
INSERT INTO `privileges` VALUES ('3', '4');
INSERT INTO `privileges` VALUES ('3', '6');
INSERT INTO `privileges` VALUES ('3', '8');
INSERT INTO `privileges` VALUES ('3', '9');
INSERT INTO `privileges` VALUES ('3', '12');
INSERT INTO `privileges` VALUES ('3', '13');

-- ----------------------------
-- Table structure for `right`
-- ----------------------------
DROP TABLE IF EXISTS `right`;
CREATE TABLE `right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of right
-- ----------------------------
INSERT INTO `right` VALUES ('1', '添加部门', 'DeptService/add');
INSERT INTO `right` VALUES ('2', '删除部门', 'DeptService/del');
INSERT INTO `right` VALUES ('3', '编辑部门', 'DeptService/load');
INSERT INTO `right` VALUES ('4', '显示部门', 'DeptService/show');
INSERT INTO `right` VALUES ('5', '添加员工', 'EmpService/add');
INSERT INTO `right` VALUES ('6', '编辑员工', 'EmpService/findById');
INSERT INTO `right` VALUES ('7', '删除员工', 'EmpService/del');
INSERT INTO `right` VALUES ('8', '显示员工', 'EmpService/show');
INSERT INTO `right` VALUES ('9', '加载部门', 'EmpService/loadDept');
INSERT INTO `right` VALUES ('10', '修改部门', 'DeptService/update');
INSERT INTO `right` VALUES ('11', '修改员工', 'EmpService/update');
INSERT INTO `right` VALUES ('12', '全部员工', 'EmpService/countId');
INSERT INTO `right` VALUES ('13', '查找角色', 'EmpService/FindRole');

-- ----------------------------
-- Table structure for `roleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('1', '人事经理', '总管理');
INSERT INTO `roleinfo` VALUES ('2', '人事干员', '员工管理');
INSERT INTO `roleinfo` VALUES ('3', '员工', '只能查看');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '李磊', '123');
INSERT INTO `userinfo` VALUES ('2', '海洋', '124');
INSERT INTO `userinfo` VALUES ('4', '齐凯', '123');
INSERT INTO `userinfo` VALUES ('5', '李安', '124');
