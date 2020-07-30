/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/07/2019 19:39:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `brand_id` bigint(20) NULL DEFAULT NULL,
  `count` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `uid` bigint(20) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for order_products
-- ----------------------------
DROP TABLE IF EXISTS `order_products`;
CREATE TABLE `order_products`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_products
-- ----------------------------
INSERT INTO `order_products` VALUES (57, 1, '联想威6 i5 8g', 1152542168435392512, 4999, 24, '联想威6 i5 8g');
INSERT INTO `order_products` VALUES (56, 1, '一只手机', 1152496388785831936, 3500, 1, '华为p30');
INSERT INTO `order_products` VALUES (55, 1, '电脑', 1152494947249684480, 5000, 4, '惠普暗影精灵');
INSERT INTO `order_products` VALUES (54, 1, '电脑', 1152483229735845888, 5000, 4, '惠普暗影精灵');
INSERT INTO `order_products` VALUES (53, 1, '一只手机', 1152482829305643008, 6000, 3, '小米mi9');
INSERT INTO `order_products` VALUES (52, 1, '一只手机', 1152482645548990464, 6000, 3, '小米mi9');
INSERT INTO `order_products` VALUES (51, 1, '电脑', 1152480231672512512, 5000, 4, '惠普暗影精灵');
INSERT INTO `order_products` VALUES (50, 1, '一只手机', 1152479919620489216, 999, 7, '华为mate20');
INSERT INTO `order_products` VALUES (49, 1, '一只手机', 1152479060320845824, 999, 7, '华为mate20');
INSERT INTO `order_products` VALUES (48, 1, '一只手机', 1152476800962527232, 3500, 1, '华为p30');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL,
  `pay_status` bit(1) NOT NULL,
  `post_status` bit(1) NOT NULL,
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_price` double NULL DEFAULT NULL,
  `uid` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (28, 'jnu', 'sbj', 1152494947249684480, b'1', b'0', '120', 5000, 1, '2019-07-20 16:26:22');
INSERT INTO `orders` VALUES (26, 'jnu', 'lyj', 1152482829305643008, b'1', b'0', '119', 6000, 7, '2019-07-20 15:38:13');
INSERT INTO `orders` VALUES (27, 'jnu', 'lyj', 1152483229735845888, b'1', b'0', '119', 5000, 7, '2019-07-20 15:39:49');
INSERT INTO `orders` VALUES (25, 'jnu', 'lyj', 1152482645548990464, b'1', b'0', '119', 6000, 7, '2019-07-20 15:37:29');
INSERT INTO `orders` VALUES (24, 'jnu', 'lyj', 1152480231672512512, b'1', b'1', '119', 5000, 7, '2019-07-20 15:27:54');
INSERT INTO `orders` VALUES (23, 'jnu', 'sbj', 1152479919620489216, b'1', b'0', '120', 999, 1, '2019-07-20 15:26:40');
INSERT INTO `orders` VALUES (22, 'jnu', 'sbj', 1152479060320845824, b'1', b'0', '120', 999, 1, '2019-07-20 15:23:15');
INSERT INTO `orders` VALUES (21, 'jnu', 'sbj', 1152476800962527232, b'1', b'1', '120', 3500, 1, '2019-07-20 15:14:16');
INSERT INTO `orders` VALUES (29, 'jnu', 'sbj', 1152496388785831936, b'1', b'0', '120', 3500, 1, '2019-07-20 16:32:06');
INSERT INTO `orders` VALUES (30, 'jnu', 'wyc', 1152542168435392512, b'1', b'0', '110', 4999, 9, '2019-07-20 19:34:01');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `brand_id` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `sold` bigint(20) NULL DEFAULT NULL,
  `stock` bigint(20) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 199 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (9, b'1', 5, 'AMD锐龙5 3500U 8G 512G FHD IPS 指纹解锁）冰河银', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 14499, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (10, b'1', 5, 'i5版 冰河银', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 3488, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (11, b'1', 5, 'i7版 冰河银', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 3588, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (12, b'1', 5, 'i5 8G 512G MX250 FHD IPS 指纹解锁', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 3588, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (13, b'1', 5, 'i3 8G 256G FHD IPS 指纹解锁', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 5999, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (14, b'1', 5, 'AMD R5 3500U 8G 256G PCIe FHD IPS 指纹Office', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 5999, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (15, b'1', 5, 'AMD锐龙7 3700U 8G 512G FHD IPS 指纹解锁', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 9099, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (16, b'1', 5, 'AMD锐龙5 8G 512G FHD IPS 正版Office', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 11099, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (17, b'1', 5, 'AMD锐龙5 8G 256G FHD IPS 正版Office', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 8099, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (18, b'1', 5, 'i5-8250U 8G 512G MX150 2G独显 FHD IPS', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 8509, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (19, b'1', 5, 'i5-8250U 8G 256G MX150 2G独显 FHD IPS', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 6499, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (20, b'1', 5, 'i5-8250U 8G 256G MX150 2G独显 IPS', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 7099, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (21, b'1', 5, 'i7-8250U 8G 256G MX150 2G独显 IPS', '荣耀MagicBook 2019 14英寸轻薄窄边框笔记本电脑', 6099, 5, 100, 2, 'rongyao.jpg');
INSERT INTO `product` VALUES (22, b'1', 6, '联想Y7000拯救者i7 16g', '联想Y7000拯救者i7 16g', 6599, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (23, b'1', 6, '联想威6 i5 4g', '联想威6 i5 4g', 3999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (24, b'1', 6, '联想威6 i5 8g', '联想威6 i5 8g', 4999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (25, b'1', 6, '联想威6 i5 8g', '联想威6 i7 4g', 5999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (26, b'1', 6, '联想威6 i5 8g', '联想威6 i7 8g', 6999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (27, b'1', 6, '改Win7系统 i5/8G/1T+128G/2G Win7 64位', '联想(Lenovo) E52-80', 5999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (28, b'1', 6, '改Win7系统 i5/4G/1T+128G/2G/Win7 64位', '联想(Lenovo) E52-80', 4999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (29, b'1', 6, '改Win7系统 i5-7200/8G/1T/2G/Win764专业', '联想(Lenovo) E52-80', 4999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (30, b'1', 6, '改Win7系统 i5-7200/8G/1T/2G/Win7 64位', '联想(Lenovo) E52-80', 4999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (31, b'1', 2, '第八代英特尔酷睿i5-8265U 8G 512G SSD MX250 2G独显 Office 支持手环疾速解锁 Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4299, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (32, b'1', 2, '第八代英特尔酷睿i3-8145U 4G 256G SSD Office 支持手环疾速解锁 Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 2999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (33, b'1', 2, '第八代英特尔酷睿i5-8265U 8G 256G SSD MX250 2G独显 Office 支持手环疾速解锁 Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (34, b'1', 2, '第八代英特尔酷睿i7-8565U 8G 512G SSD MX250 2G独显 Office 支持手环疾速解锁 Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (35, b'1', 2, '第八代英特尔酷睿i5-8265U 8G 256G SSD Office 支持手环疾速解锁 Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3799, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (36, b'1', 2, '第八代英特尔酷睿i5-8250U 8G 512G SSD 2G GDDR5独显 FHD 全键盘 Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (37, b'1', 2, '第八代英特尔酷睿i5-8250U 8G 256G SSD 2G GDDR5独显 FHD 全键盘 Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3799, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (38, b'1', 2, '英特尔酷睿I3-8130U 4G 128G SSD FHD 全键盘', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 2999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (39, b'1', 2, '英特尔酷睿I3-8130U 4G 256G SSD FHD 全键盘', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3199, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (40, b'1', 2, '英特尔八代酷睿I5-8300H 8G 512G SSD GTX1060 6G 72%NTSC高色域 FHD', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 7599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (41, b'1', 2, '第八代英特尔酷睿I7-8750H 16G 512G SSD GTX1060 6G 72%NTSC高色域 FHD', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 7999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (42, b'1', 2, '第八代英特尔酷睿i5-8250U 8G 512G PCIE SSD MX250 2G独显 72%NTSC 指纹识别 Office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 5399, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (43, b'1', 2, '第八代英特尔酷睿i5-8250U 8G 256G SSD FHD 全键盘 Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 3599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (44, b'1', 2, '八代英特尔酷睿i7-8550U 16G 256GSSD MX250 2G独显 72%高色域 FHD 指纹识别 预装Office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 6599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (45, b'1', 2, '第八代英特尔酷睿i7-8550U 16G 512GSSD MX250 2G独显 FHD 指纹识别 预装Office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 6799, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (46, b'1', 2, '第八代英特尔酷睿i7-8550U 8G 512G SSD 2G GDDR5独显 FHD 全键盘 Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4699, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (47, b'1', 2, '第八代英特尔酷睿i5-8250U 8G 256G PCIE SSD MX250 2G独显 72%NTSC 指纹识别 Office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 5199, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (48, b'1', 2, 'i5-8250U 8G 256GSSD MX150 2G独显 72%高色域 FHD 指纹识别 预装office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 5199, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (49, b'1', 2, '八代酷睿i5-8250U 8G 256GSSD GTX1050Max-Q 4G独显 72%高色域', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 5999, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (50, b'1', 2, 'i5-8250U 8G 1T+128G SSD 2G GDDR5独显 FHD 全键盘 正版Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4588, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (51, b'1', 2, '特尔八代酷睿I5-8300H 8G 1T+256G SSD GTX1060 6G 72%NTSC高色域 FHD', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 7599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (52, b'1', 2, '英特尔八代酷睿I7-8750H 8G 1T+256G SSD GTX1050Ti 4G 72%NTSC高色域 FHD', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 7299, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (53, b'1', 2, 'i5-8250U 4G 1T+128G SSD 2G GDDR5独显 FHD 全键盘 正版Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4188, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (54, b'1', 2, '英特尔八代酷睿I5-8300H 8G 1T+256G SSD GTX1050TI 4G 72%NTSC高色域 FHD', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 6499, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (55, b'1', 2, 'i7-8550U 16G 256GSSD MX150 2G独显 FHD 指纹识别 预装office', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 6599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (56, b'1', 2, 'i5-8250U 8G 1T+128G SSD 2G GDDR5独显 FHD 全键盘 正版Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4599, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (57, b'1', 2, '第八代英特尔酷睿i7-8550U 8G 512G SSD FHD 正版Office Win10', '小米(MI)RedmiBook 14英寸全金属超轻薄笔记本电脑', 4199, 5, 100, 2, 'xiaomi.jpg');
INSERT INTO `product` VALUES (58, b'1', 6, 'i7-8750H 8G 512G GTX1060 72%NTSC黑', '联想(Lenovo)拯救者Y7000', 7499, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (59, b'1', 6, 'i5-8300H 8G 512G GTX106072%NTSC 黑', '联想(Lenovo)拯救者Y7000', 6169, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (60, b'1', 6, 'i5-8300H 8G 512G GTX1050Ti72%NTSC', '联想(Lenovo)拯救者Y7000', 5999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (61, b'1', 6, 'i7-9750H 8G 512G SSD GTX1050 3G IPS', '联想(Lenovo)拯救者Y7000', 8999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (62, b'1', 6, 'i5-9300H8G 512G SSD 1660Ti 72%NTSC', '联想(Lenovo)拯救者Y7000', 7499, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (63, b'1', 6, 'i5-9300H 8G 512G SSD GTX1050 3G IPS', '联想(Lenovo)拯救者Y7000', 5699, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (64, b'1', 6, 'i5-9300H 8G 512G SSD GTX1650', '联想(Lenovo)拯救者Y7000', 6099, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (65, b'1', 6, 'i5-9300H 8G 1T SSD GTX1650 72%NTSC', '联想(Lenovo)拯救者Y7000', 6799, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (66, b'1', 6, 'i7-9750H 8G 1T SSD GTX1650 72%NTSC', '联想(Lenovo)拯救者Y7000', 7799, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (67, b'1', 6, 'i7-9750H 8G 1T SSD GTX1650 144Hz', '联想(Lenovo)拯救者Y7000', 8099, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (68, b'1', 6, 'i5-9300H 8G 1T SSD GTX1650 144Hz', '联想(Lenovo)拯救者Y7000', 7099, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (69, b'1', 6, 'i5-9300H 8G 1T SSD GTX1660Ti 144Hz', '联想(Lenovo)拯救者Y7000', 8099, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (70, b'1', 6, 'i7-9750H 16G 1T SSD GTX1660Ti 144Hz', '联想(Lenovo)拯救者Y7000', 9299, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (71, b'1', 6, 'i7-9750H16G 1TSSD GTX1660Ti 72%NTSC', '联想(Lenovo)拯救者Y7000', 8999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (72, b'1', 6, 'i7-9750H16G 1T+1T RTX2060 144Hz', '联想(Lenovo)拯救者Y7000', 10999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (73, b'1', 6, 'i7-9750H32G 2T+1T SSD RTX2080 144HzG-SYNC', '联想(Lenovo)拯救者Y7000', 20999, 5, 100, 2, 'lianxiangzjz.jpg');
INSERT INTO `product` VALUES (74, b'1', 7, '九代i7-9750H 16G 1TSSD GTX1660TiMQ 6G 72色域 144Hz', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 9099, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (75, b'1', 7, '九代i7-9750H 8G 1TSSD GTX1650 4G独显 72色域 144Hz', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 7999, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (76, b'1', 7, 'i7-9750H 8G双通道 512G 1660TiMQ 144Hz 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 8099, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (77, b'1', 7, '九代i7-9750H 8G双通道 128GSSD 1T GTX1660TiMax-Q 6G 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6989, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (78, b'1', 7, '九代i7-9750H 8G双通道 512GSSD GTX1660TiMQ 6G IPS 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 7089, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (79, b'1', 7, '九代i7-9750H 8G双通道 128GSSD 1T GTX1650 4G IPS 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6489, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (80, b'1', 7, '九代i7-9750H 8G双通道 512G GTX1650 4G 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 7489, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (81, b'1', 7, '九代i5-9300H 8G双通道 128GSSD 1T GTX1650 4G', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 5489, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (82, b'1', 7, '九代i5-9300H 8G双通道 512G GTX1650 4G 72色域', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 5689, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (83, b'1', 7, 'i7-8750H 16G 256G SSD+2T GTX1060MQ 6G独显 72%NTSC', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 10299, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (84, b'1', 7, 'i7-8750H 16G 256G PCle固态+2T GTX1060MQ 6G独显 72%NTSC', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 10499, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (85, b'1', 7, 'i7-8750H 8G 128G 1T GTX1060MQ 6G独显 背光键盘 IPS', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 8299, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (86, b'1', 7, 'i7-8750H 8G 512GSSD GTX1050Ti 4G独显 72%NTSC IPS', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6899, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (87, b'1', 7, 'i5-8300H 8G 128GSSD 1T GTX1060MQ 6G独显', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6399, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (88, b'1', 7, 'i5-8300H 8G 128G 1T GTX1050Ti 4G独显 IPS', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6699, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (89, b'1', 7, 'i5-8300H 8G 512G GTX1050Ti 4G独显 72%NTSC', '戴尔DELL游匣G3 英特尔酷睿i5 15.6英寸轻薄游戏笔记本电脑', 6299, 5, 100, 2, 'dell.jpg');
INSERT INTO `product` VALUES (90, b'1', 3, '八代i5 8G 128G SSD 深空灰 苹果笔记本电脑 轻薄本 MVFH2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8899, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (91, b'1', 3, '八代i5 8G 128G SSD 银色 苹果笔记本电脑 轻薄本 MVFK2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8899, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (92, b'1', 3, '八代i5 8G 128G SSD 金色 苹果笔记本电脑 轻薄本 MVFM2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8899, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (93, b'1', 3, '八代i5 8G 256G SSD 深空灰 苹果笔记本电脑 轻薄本 MVFJ2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 10399, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (94, b'1', 3, '八代i5 8G 256G SSD 银色 苹果笔记本电脑 轻薄本 MVFL2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 10399, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (95, b'1', 3, '八代i5 8G 256G SSD 金色 苹果笔记本电脑 轻薄本 MVFN2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 10399, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (96, b'1', 3, 'Core i5 8G 128G SSD 金色 苹果笔记本电脑 轻薄本MREE2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8499, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (97, b'1', 3, 'Core i5 8G 128G SSD 银色 苹果笔记本电脑 轻薄本 MREA2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8499, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (98, b'1', 3, 'Core i5 8G 128G SSD 深空灰 苹果笔记本电脑 轻薄本 MRE82CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 8499, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (99, b'1', 3, 'Core i5 8G 256G SSD 金色 苹果笔记本电脑 轻薄本MREF2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 9899, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (100, b'1', 3, 'Core i5 8G 256G SSD 银色 苹果笔记本电脑 轻薄本MREC2CH/A', 'Apple 2019款 MacBook Air 13.3 Retina屏', 9899, 5, 100, 2, 'apple.jpg');
INSERT INTO `product` VALUES (197, b'1', 4, '全面屏游戏手机 4GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16th (4G)', 2098, 3, 67, 1, '魅族.jpg');
INSERT INTO `product` VALUES (198, b'1', 4, '全面屏手机 6GB+64GB  全网通移动联通电信4G手机 双卡双待', '魅族Note 8 (6G)', 849, 23, 90, 1, '魅族.jpg');
INSERT INTO `product` VALUES (181, b'1', 4, '全面屏手机 8GB+64GB  全网通移动联通电信4G手机 双卡双待', '魅族Note 8 (8G)', 1099, 1, 5, 1, '魅族.jpg');
INSERT INTO `product` VALUES (180, b'1', 4, '全面屏手机 4GB+64GB  全网通移动联通电信4G手机 双卡双待', '魅族Note 8 (4G)', 649, 45, 5, 1, '魅族.jpg');
INSERT INTO `product` VALUES (179, b'1', 4, '龙855全面屏拍照游戏手机 8GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16s (8G)', 2899, 3, 67, 1, '魅族.jpg');
INSERT INTO `product` VALUES (178, b'1', 4, '龙855全面屏拍照游戏手机 6GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16s (6G)', 2699, 1, 90, 1, '魅族.jpg');
INSERT INTO `product` VALUES (177, b'1', 4, '龙855全面屏拍照游戏手机 4GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16s (4G)', 2599, 4, 78, 1, '魅族.jpg');
INSERT INTO `product` VALUES (176, b'1', 4, '8+128G亚特兰蒂斯', '魅族16xs (8G)', 2099, 2, 45, 1, '魅族.jpg');
INSERT INTO `product` VALUES (174, b'1', 4, '6+64G亚特兰蒂斯', '魅族16xs (6G)', 1799, 6, 34, 1, '魅族.jpg');
INSERT INTO `product` VALUES (175, b'1', 4, '8+64G亚特兰蒂斯', '魅族16xs (8G)', 1999, 64, 78, 1, '魅族.jpg');
INSERT INTO `product` VALUES (173, b'1', 4, '4+64G亚特兰蒂斯', '魅族16xs (4G)', 1599, 23, 45, 1, '魅族.jpg');
INSERT INTO `product` VALUES (171, b'1', 3, '6GB+64GB  移动联通4G手机', 'iphone 8 plus (6G)', 5099, 43, 34, 1, '苹果.jpg');
INSERT INTO `product` VALUES (172, b'1', 3, '8GB+64GB  移动联通4G手机', 'iphone 8 plus (8G)', 4899, 2, 67, 1, '苹果.jpg');
INSERT INTO `product` VALUES (170, b'1', 3, '4GB+64GB  移动联通4G手机', 'iphone 8 plus (4G)', 5499, 5, 30, 1, '苹果.jpg');
INSERT INTO `product` VALUES (169, b'1', 3, '8GB+512GB 深空灰色 移动联通电信4G手机', 'iphone X (8G)', 8599, 23, 80, 1, '苹果.jpg');
INSERT INTO `product` VALUES (168, b'1', 3, '8GB+256GB 深空灰色 移动联通电信4G手机', 'iphone X (8G)', 8299, 3, 56, 1, '苹果.jpg');
INSERT INTO `product` VALUES (166, b'1', 3, '6GB+256GB 深空灰色 移动联通电信4G手机', 'iphone X (6G)', 7699, 18, 67, 1, '苹果.jpg');
INSERT INTO `product` VALUES (167, b'1', 3, '6GB+512GB 深空灰色 移动联通电信4G手机', 'iphone X (6G)', 8099, 6, 70, 1, '苹果.jpg');
INSERT INTO `product` VALUES (165, b'1', 3, '6GB+128GB 深空灰色 移动联通电信4G手机', 'iphone X (6G)', 7299, 4, 90, 1, '苹果.jpg');
INSERT INTO `product` VALUES (164, b'1', 3, '4GB+256GB 深空灰色 移动联通电信4G手机', 'iphone X (4G)', 7099, 8, 89, 1, '苹果.jpg');
INSERT INTO `product` VALUES (163, b'1', 3, '8GB+256G 黑色 移动联通电信4G手机', 'iphone 7 (8G)', 3729, 7, 5, 1, '苹果.jpg');
INSERT INTO `product` VALUES (161, b'1', 3, '6GB+128G 黑色 移动联通电信4G手机', 'iphone 7 (6G)', 3129, 5, 1, 1, '苹果.jpg');
INSERT INTO `product` VALUES (162, b'1', 3, '8GB+128G 黑色 移动联通电信4G手机', 'iphone 7 (8G)', 3329, 33, 23, 1, '苹果.jpg');
INSERT INTO `product` VALUES (160, b'1', 3, '4GB+128G 黑色 移动联通电信4G手机', 'iphone 7 (4G)', 2929, 23, 32, 1, '苹果.jpg');
INSERT INTO `product` VALUES (159, b'1', 3, '8GB+256GB深空灰色 移动联通电信4G手机 双卡双待', 'iphone XS (8G)', 9799, 2, 75, 1, '苹果.jpg');
INSERT INTO `product` VALUES (158, b'1', 3, '8GB+128GB深空灰色 移动联通电信4G手机 双卡双待', 'iphone  XS (8G)', 9399, 45, 56, 1, '苹果.jpg');
INSERT INTO `product` VALUES (157, b'1', 3, '6GB+128GB深空灰色 移动联通电信4G手机 双卡双待', 'iphone XS (6G)', 9199, 3, 78, 1, '苹果.jpg');
INSERT INTO `product` VALUES (156, b'1', 3, '4GB+128GB深空灰色 移动联通电信4G手机 双卡双待', 'iphone XS (4G)', 9099, 2, 56, 1, '苹果.jpg');
INSERT INTO `product` VALUES (155, b'1', 3, '8GB+64GB 深空灰色 移动联通4G手机', 'iphone 8 (8G)', 3949, 34, 34, 1, '苹果.jpg');
INSERT INTO `product` VALUES (153, b'1', 3, '4GB+64GB 深空灰色 移动联通4G手机', 'iphone 8 (4G)', 3349, 4, 78, 1, '苹果.jpg');
INSERT INTO `product` VALUES (154, b'1', 3, '6GB+64GB 深空灰色 移动联通4G手机', 'iphone 8 (6G)', 3549, 7, 34, 1, '苹果.jpg');
INSERT INTO `product` VALUES (152, b'1', 3, '6GB+64GB  移动联通4G手机', 'iphone 8 plus (6G)', 4699, 2, 56, 1, '苹果.jpg');
INSERT INTO `product` VALUES (151, b'1', 3, '4GB+64GB  移动联通4G手机', 'iphone 8 plus (4G)', 4299, 2, 4, 1, '苹果.jpg');
INSERT INTO `product` VALUES (149, b'1', 3, '6GB+128GB  移动联通电信4G手机 双卡双待', 'iphone XR (6G)', 5699, 44, 89, 1, '苹果.jpg');
INSERT INTO `product` VALUES (150, b'1', 3, '8GB+128GB  移动联通电信4G手机 双卡双待', 'iphone  XR (8G)', 5999, 5, 4, 1, '苹果.jpg');
INSERT INTO `product` VALUES (148, b'1', 3, '4GB+128GB  移动联通电信4G手机 双卡双待', 'iphone XR (4G)', 5499, 23, 7, 1, '苹果.jpg');
INSERT INTO `product` VALUES (147, b'1', 2, '全面屏智能游戏拍照手机 6GB+64GB  骁龙710处理器 全网通4G 双卡双待', '小米8SE (6G)', 1699, 45, 56, 1, '小米.jpg');
INSERT INTO `product` VALUES (146, b'1', 2, '全面屏智能游戏拍照手机 4GB+64GB  骁龙710处理器 全网通4G 双卡双待', '小米8SE (4G)', 1499, 23, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (145, b'1', 2, '流光渐变AI双摄 8GB+64GB  全网通4G 双卡双待 小水滴全面屏拍照游戏智能手机', '小米play (8G)', 1149, 34, 63, 1, '小米.jpg');
INSERT INTO `product` VALUES (144, b'1', 2, '流光渐变AI双摄 6GB+64GB  全网通4G 双卡双待 小水滴全面屏拍照游戏智能手机', '小米play (6G)', 949, 3, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (143, b'1', 2, '流光渐变AI双摄 4GB+64GB  全网通4G 双卡双待 小水滴全面屏拍照游戏智能手机', '小米play (4G)', 749, 78, 45, 1, '小米.jpg');
INSERT INTO `product` VALUES (142, b'1', 2, 'AI美颜 6GB+32GB 全网通4G手机 双卡双待', '红米6A (6G)', 849, 23, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (141, b'1', 2, 'AI美颜 4GB+32GB 全网通4G手机 双卡双待', '红米6A (4G)', 649, 45, 45, 1, '小米.jpg');
INSERT INTO `product` VALUES (140, b'1', 2, '镜面渐变AI双摄 8GB+64GB  全网通4G 双卡双待 全面屏拍照游戏智能手机', '小米8青春版 (8G)', 1399, 4, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (139, b'1', 2, '镜面渐变AI双摄 6GB+64GB  全网通4G 双卡双待 全面屏拍照游戏智能手机', '小米8青春版 (6G)', 1199, 67, 45, 1, '小米.jpg');
INSERT INTO `product` VALUES (138, b'1', 2, '镜面渐变AI双摄 4GB+64GB  全网通4G 双卡双待 全面屏拍照游戏智能手机', '小米8青春版 (4G)', 1099, 45, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (137, b'1', 2, '6GB+256GB  全网通4G 双卡双待 全面屏拍照智能游戏手机', '小米8 (8G)', 2399, 3, 46, 1, '小米.jpg');
INSERT INTO `product` VALUES (136, b'1', 2, '8GB+128GB  全网通4G 双卡双待 全面屏拍照智能游戏手机', '小米8 (8G)', 2199, 67, 12, 1, '小米.jpg');
INSERT INTO `product` VALUES (135, b'1', 2, '6GB+128GB  全网通4G 双卡双待 全面屏拍照智能游戏手机', '小米8 (6G)', 2099, 43, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (134, b'1', 2, '4GB+128GB  全网通4G 双卡双待 全面屏拍照智能游戏手机', '小米8 (4G)', 1899, 5, 45, 1, '小米.jpg');
INSERT INTO `product` VALUES (133, b'1', 2, 'AI双摄 4GB+128GB  全网通4G 双卡双待 水滴全面屏拍照游戏智能手机', '红米Note7 (8G)', 1599, 13, 12, 1, '小米.jpg');
INSERT INTO `product` VALUES (132, b'1', 2, 'AI双摄 4GB+64GB  全网通4G 双卡双待 水滴全面屏拍照游戏智能手机', '红米Note7 (8G)', 1399, 24, 53, 1, '小米.jpg');
INSERT INTO `product` VALUES (131, b'1', 2, 'AI双摄 6GB+64GB  全网通4G 双卡双待 水滴全面屏拍照游戏智能手机', '红米Note7 (6G)', 1199, 4, 23, 1, '小米.jpg');
INSERT INTO `product` VALUES (130, b'1', 2, 'AI双摄 4GB+64GB  全网通4G 双卡双待 水滴全面屏拍照游戏智能手机', '红米Note7 (4G)', 1099, 23, 56, 1, '小米.jpg');
INSERT INTO `product` VALUES (129, b'1', 2, '4800万超广角三摄 8GB+256GB  骁龙855 全网通4G 双卡双待 全面屏拍照智能游戏手机', '红米K20 pro (8G)', 3399, 74, 2, 1, '小米.jpg');
INSERT INTO `product` VALUES (128, b'1', 2, '4800万超广角三摄 8GB+128GB  骁龙855 全网通4G 双卡双待 全面屏拍照智能游戏手机', '红米K20 pro (8G)', 3199, 55, 45, 1, '小米.jpg');
INSERT INTO `product` VALUES (127, b'1', 2, '4800万超广角三摄 6GB+128GB  骁龙855 全网通4G 双卡双待 全面屏拍照智能游戏手机', '红米K20 pro (6G)', 2999, 3, 34, 1, '小米.jpg');
INSERT INTO `product` VALUES (126, b'1', 2, '4800万超广角三摄 4GB+128GB  骁龙855 全网通4G 双卡双待 全面屏拍照智能游戏手机', '红米K20 pro (4G)', 2799, 3, 12, 1, '小米.jpg');
INSERT INTO `product` VALUES (125, b'1', 5, '91%屏占比 2000万AI双摄 8GB+128GB  移动联通电信4G全面屏手机 双卡双待', '华为荣耀8x (8G)', 1499, 7, 43, 1, '华为.jpg');
INSERT INTO `product` VALUES (124, b'1', 5, '91%屏占比 2000万AI双摄 8GB+64GB  移动联通电信4G全面屏手机 双卡双待', '华为荣耀8x (8G)', 1299, 66, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (123, b'1', 5, '91%屏占比 2000万AI双摄 6GB+64GB  移动联通电信4G全面屏手机 双卡双待', '华为荣耀8x (6G)', 1199, 2, 45, 1, '华为.jpg');
INSERT INTO `product` VALUES (122, b'1', 5, '91%屏占比 2000万AI双摄 4GB+64GB  移动联通电信4G全面屏手机 双卡双待', '华为荣耀8x (4G)', 1099, 3, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (121, b'1', 1, '前置3200万人像超级夜景4800万AI四摄麒麟980芯片8GB+256GB全网通双4G手机', '华为nova5 pro (8G)', 3599, 4, 34, 1, '华为.jpg');
INSERT INTO `product` VALUES (120, b'1', 1, '前置3200万人像超级夜景4800万AI四摄麒麟980芯片8GB+128GB全网通双4G手机', '华为nova5 pro (8G)', 3199, 6, 12, 1, '华为.jpg');
INSERT INTO `product` VALUES (119, b'1', 1, '前置3200万人像超级夜景4800万AI四摄麒麟980芯片6GB+128GB全网通双4G手机', '华为nova5 pro (6G)', 2999, 4, 34, 1, '华为.jpg');
INSERT INTO `product` VALUES (118, b'1', 1, '前置3200万人像超级夜景4800万AI四摄麒麟980芯片4GB+128GB全网通双4G手机', '华为nova5 pro (4G)', 2799, 2, 12, 1, '华为.jpg');
INSERT INTO `product` VALUES (117, b'1', 1, '超感光徕卡三摄麒麟980AI智能芯片全面屏屏内指纹版手机8GB+256GB全网通双4G手机', '华为P30 (8G)', 4688, 5, 1, 1, '华为.jpg');
INSERT INTO `product` VALUES (116, b'1', 1, '超感光徕卡三摄麒麟980AI智能芯片全面屏屏内指纹版手机8GB+128GB全网通双4G手机', '华为P30 (8G)', 4388, 7, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (115, b'1', 1, '超感光徕卡三摄麒麟980AI智能芯片全面屏屏内指纹版手机6GB+128GB全网通双4G手机', '华为P30 (6G)', 4288, 9, 45, 1, '华为.jpg');
INSERT INTO `product` VALUES (114, b'1', 1, '超感光徕卡三摄麒麟980AI智能芯片全面屏屏内指纹版手机4GB+128GB全网通双4G手机', '华为P30 (4G)', 4188, 6, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (113, b'1', 5, '4800万超广角AI四摄 3200W美颜自拍 麒麟Kirin980全网通版8GB+256GB  移动联通电信4G全面屏', '华为荣耀20 (8G)', 3199, 35, 34, 1, '华为.jpg');
INSERT INTO `product` VALUES (112, b'1', 5, '4800万超广角AI四摄 3200W美颜自拍 麒麟Kirin980全网通版8GB+128GB  移动联通电信4G全面屏', '华为荣耀20 (8G)', 2899, 7, 64, 1, '华为.jpg');
INSERT INTO `product` VALUES (111, b'1', 5, '4800万超广角AI四摄 3200W美颜自拍 麒麟Kirin980全网通版6GB+128GB  移动联通电信4G全面屏', '华为荣耀20 (6G)', 2699, 5, 45, 1, '华为.jpg');
INSERT INTO `product` VALUES (110, b'1', 5, '4800万超广角AI四摄 3200W美颜自拍 麒麟Kirin980全网通版4GB+128GB  移动联通电信4G全面屏', '华为荣耀20 (4G)', 2499, 3, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (109, b'1', 5, '4800万四摄 双光学防抖 麒麟980 全网通4G 8GB+256GB  全面屏拍照手机', '华为荣耀20 pro (8G)', 3699, 7, 5, 1, '华为.jpg');
INSERT INTO `product` VALUES (108, b'1', 5, '4800万四摄 双光学防抖 麒麟980 全网通4G 8GB+128GB  全面屏拍照手机', '华为荣耀20 pro (8G)', 3399, 6, 100, 1, '华为.jpg');
INSERT INTO `product` VALUES (107, b'1', 5, '4800万四摄 双光学防抖 麒麟980 全网通4G 6GB+128GB  全面屏拍照手机', '华为荣耀20 pro（6G)', 3199, 5, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (106, b'1', 5, '4800万四摄 双光学防抖 麒麟980 全网通4G 4GB+128GB  全面屏拍照手机', '华为荣耀20 pro（4G）', 2999, 4, 12, 1, '华为.jpg');
INSERT INTO `product` VALUES (105, b'1', 1, '麒麟980AI智能芯片全面屏超微距影像超大广角徕卡三摄8GB+256GB全网通版双4G手机', '华为Mate 20（8G）', 3999, 0, 100, 1, '华为.jpg');
INSERT INTO `product` VALUES (104, b'1', 1, '麒麟980AI智能芯片全面屏超微距影像超大广角徕卡三摄8GB+128GB全网通版双4G手机', '华为Mate 20（8G）', 3499, 1, 2, 1, '华为.jpg');
INSERT INTO `product` VALUES (103, b'1', 1, '麒麟980AI智能芯片全面屏超微距影像超大广角徕卡三摄6GB+128GB全网通版双4G手机', '华为Mate 20（6G）', 3799, 0, 80, 1, '华为.jpg');
INSERT INTO `product` VALUES (102, b'1', 1, '麒麟980AI智能芯片全面屏超微距影像超大广角徕卡三摄4GB+128GB全网通版双4G手机', '华为Mate 20（4G）', 3699, 0, 23, 1, '华为.jpg');
INSERT INTO `product` VALUES (182, b'1', 4, '全面屏游戏手机 6GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16th (6G)', 2298, 45, 39, 1, '魅族.jpg');
INSERT INTO `product` VALUES (183, b'1', 4, '全面屏游戏手机 8GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族16th (8G)', 2498, 23, 70, 1, '魅族.jpg');
INSERT INTO `product` VALUES (184, b'1', 4, '全面屏游戏手机 8GB+256GB  全网通移动联通电信4G手机 双卡双待', '魅族16th (8G)', 2698, 1, 40, 1, '魅族.jpg');
INSERT INTO `product` VALUES (185, b'1', 4, '准旗舰游戏拍照手机 4GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族X8 (4G)', 1398, 2, 46, 1, '魅族.jpg');
INSERT INTO `product` VALUES (186, b'1', 4, '准旗舰游戏拍照手机 6GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族X8 (6G)', 1598, 34, 12, 1, '魅族.jpg');
INSERT INTO `product` VALUES (187, b'1', 4, '准旗舰游戏拍照手机 8GB+128GB  全网通移动联通电信4G手机 双卡双待', '魅族X8 (8G)', 1798, 1, 57, 1, '魅族.jpg');
INSERT INTO `product` VALUES (188, b'1', 4, '准旗舰游戏拍照手机 8GB+256GB  全网通移动联通电信4G手机 双卡双待', '魅族X8 (8G)', 1998, 23, 90, 1, '魅族.jpg');
INSERT INTO `product` VALUES (189, b'1', 4, '4G手机  全网通（4+64G）高配', '魅族V8 (4G)', 579, 45, 56, 1, '魅族.jpg');
INSERT INTO `product` VALUES (190, b'1', 4, '4G手机  全网通（6+64G）高配', '魅族V8 (6G)', 679, 23, 12, 1, '魅族.jpg');
INSERT INTO `product` VALUES (191, b'1', 4, '4G手机  全网通（8+64G）高配', '魅族V8 (8G)', 879, 4, 34, 1, '魅族.jpg');
INSERT INTO `product` VALUES (192, b'1', 4, '4G手机  全网通（8+128G）高配', '魅族V8 (8G)', 1079, 2, 15, 1, '魅族.jpg');
INSERT INTO `product` VALUES (193, b'1', 4, '全网通4G+64G', '魅族Note 9 (4G)', 1068, 3, 3, 1, '魅族.jpg');
INSERT INTO `product` VALUES (194, b'1', 4, '全网通6G+64G', '魅族Note 9 (6G)', 1268, 5, 34, 1, '魅族.jpg');
INSERT INTO `product` VALUES (195, b'1', 4, '全网通8G+64G', '魅族Note 9 (8G)', 1468, 2, 67, 1, '魅族.jpg');
INSERT INTO `product` VALUES (196, b'1', 4, '全网通8G+128G', '魅族Note 9 (8G)', 1668, 10, 23, 1, '魅族.jpg');

-- ----------------------------
-- Table structure for product_properties
-- ----------------------------
DROP TABLE IF EXISTS `product_properties`;
CREATE TABLE `product_properties`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) NULL DEFAULT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_properties
-- ----------------------------
INSERT INTO `product_properties` VALUES (1, 5, '荣耀', 2, '电脑');
INSERT INTO `product_properties` VALUES (2, 6, '联想', 2, '电脑');
INSERT INTO `product_properties` VALUES (3, 2, '小米', 2, '电脑');
INSERT INTO `product_properties` VALUES (4, 7, '戴尔', 2, '电脑');
INSERT INTO `product_properties` VALUES (5, 3, 'apple', 2, '电脑');
INSERT INTO `product_properties` VALUES (6, 4, '魅族', 1, '手机');
INSERT INTO `product_properties` VALUES (7, 1, '华为', 1, '手机');
INSERT INTO `product_properties` VALUES (8, 2, '小米', 1, '手机');
INSERT INTO `product_properties` VALUES (9, 3, 'apple', 1, '手机');
INSERT INTO `product_properties` VALUES (10, 5, '荣耀', 1, '手机');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2019-07-20 19:37:27', 'c3079d243353e68687ea9b6794036998', b'1', 'admin', 'admin');
INSERT INTO `user` VALUES (2, '2019-07-20 19:38:19', 'dc1c5ed2b8b12557f7d874db182d4862', b'1', 'wyc', 'user');
INSERT INTO `user` VALUES (3, '2019-07-20 19:38:30', '6c84c231b65b68b0a5c58a3dacd2e10b', b'1', 'sbj', 'user');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `psw_ans` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `psw_ques` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'jnu', 'i@qq.com', '404', 'wyc', 'wyc', 'who am i', '110', 2);
INSERT INTO `user_info` VALUES (2, 'jnu', 'lyj@qq.com', '444', 'sbj', 'sbj', 'who am i', '119', 3);

SET FOREIGN_KEY_CHECKS = 1;
