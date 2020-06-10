/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c0-s2-ply-demo

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-06-10 17:38:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for game_score
-- ----------------------------
DROP TABLE IF EXISTS `game_score`;
CREATE TABLE `game_score` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL COMMENT '玩家id',
  `name` varchar(50) default NULL COMMENT '玩家姓名',
  `game` varchar(255) default NULL COMMENT '游戏名',
  `level` int(255) default NULL COMMENT '游戏进度关数',
  `score` int(255) default NULL COMMENT '成绩(关数,得分...)',
  `data` varchar(2000) default NULL COMMENT '游戏存档数据',
  `uptime` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '成绩更新时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_game_name` USING BTREE (`name`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game_score
-- ----------------------------
INSERT INTO `game_score` VALUES ('1', null, '武松', '推箱子', null, '3', null, '2020-06-10 17:25:33');
