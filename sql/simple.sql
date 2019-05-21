/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 101.132.146.171
 Source Database       : simple

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : utf-8

 Date: 05/21/2019 16:25:22 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
  `goods_title` varchar(64) DEFAULT NULL COMMENT '商品标题',
  `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `goods_detail` longtext COMMENT '商品介绍详情',
  `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品单价',
  `goods_stock` int(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods`
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES ('1', ' iPhone X', ' 当天发/12分期/送大礼 Apple/苹果 iPhone X移动联通4G手机中移动', '/img/iphone.jpg', ' 当天发/12分期/送大礼 Apple/苹果 iPhone X移动联通4G手机中移动', '7268.00', '1000', '2018-07-12 19:06:20', '2018-07-12 19:06:20'), ('2', 'xiaomi 8', ' 小米8现货【送小米耳机】Xiaomi/小米 小米8手机8plus中移动8se', '/img/xiaomi.jpg', ' 小米8现货【送小米耳机】Xiaomi/小米 小米8手机8plus中移动8se', '2799.00', '1000', '2018-07-12 19:06:20', '2018-07-12 19:06:20'), ('3', '荣耀 10', ' 12期分期/honor/荣耀10手机中移动官方旗舰店正品荣耀10手机playv10 plαy', '/img/rongyao.jpg', ' 12期分期/honor/荣耀10手机中移动官方旗舰店正品荣耀10手机playv10 plαy', '2699.00', '1000', '2018-07-12 19:06:20', '2018-07-12 22:32:20'), ('4', 'oppo find x', ' OPPO R15 oppor15手机全新机限量超薄梦境r15梦镜版r11s find x', '/img/oppo.jpg', ' OPPO R15 oppor15手机全新机限量超薄梦境r15梦镜版r11s find x', '4999.00', '1000', '2018-07-12 19:06:20', '2018-07-12 19:06:20');
COMMIT;

-- ----------------------------
--  Table structure for `miaosha_order`
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_order`;
CREATE TABLE `miaosha_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_userid_goodsid` (`user_id`,`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `miaosha_order`
-- ----------------------------
BEGIN;
INSERT INTO `miaosha_order` VALUES ('43', '100002', '-662425600', '1'), ('44', '100002', '688140288', '2');
COMMIT;

-- ----------------------------
--  Table structure for `operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `user_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_action` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `operation_log`
-- ----------------------------
BEGIN;
INSERT INTO `operation_log` VALUES ('1', '101', '0:0:0:0:0:0:0:1', '用户下单', '2019-05-21 03:04:42'), ('2', '101', '0:0:0:0:0:0:0:1', '用户下单', '2019-05-21 03:05:19');
COMMIT;

-- ----------------------------
--  Table structure for `seckill_goods`
-- ----------------------------
DROP TABLE IF EXISTS `seckill_goods`;
CREATE TABLE `seckill_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `seckil_price` decimal(10,2) DEFAULT NULL COMMENT '秒杀价',
  `stock_count` int(11) DEFAULT NULL COMMENT '秒杀数量',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `seckill_goods`
-- ----------------------------
BEGIN;
INSERT INTO `seckill_goods` VALUES ('1', '1', '6888.00', '94', '2018-07-12 19:06:20', '2018-08-15 19:06:20'), ('2', '2', '2699.00', '95', '2018-07-17 22:32:20', '2018-08-15 19:06:20'), ('3', '3', '2599.00', '93', '2018-07-14 00:59:20', '2018-08-15 19:06:20'), ('4', '4', '4999.00', '97', '2018-07-17 09:06:20', '2018-08-15 19:06:20');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100003 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('100001', 'demo', 'demo', 'ADMIN'), ('100002', 'name', '$2a$10$j1c3z1oxC0vcRF1dfl75/u21UKaxecOJuNoPUrkk5IhownxhHJ0g6', 'ROLE_ADMIN');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
