/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 25/10/2019 15:04:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hk_app_user_config
-- ----------------------------
DROP TABLE IF EXISTS `hk_app_user_config`;
CREATE TABLE `hk_app_user_config` (
  `userId` int(11) NOT NULL DEFAULT '0',
  `notify` int(11) DEFAULT '0',
  `reverse1` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `reverse2` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Procedure structure for test
-- ----------------------------
DROP PROCEDURE IF EXISTS `test`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test`(IN a int)
begin
declare b int;
set b = 3;
set a = 7;
select a;
end;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
