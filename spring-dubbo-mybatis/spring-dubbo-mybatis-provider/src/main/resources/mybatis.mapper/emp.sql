/*
Navicat MySQL Data Transfer

Source Server         : 192.168.16.200
Source Server Version : 50560
Source Host           : 192.168.16.200:3306
Source Database       : willow

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-15 21:41:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emp_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emp_age` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
 
