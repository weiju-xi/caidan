/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : usercenter

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 09/12/2019 23:27:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `loginname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1203502944754995200', 'admin', '$2a$10$2G0urOP7x2QCnmPS9Q/pwuXgLgUuBwi0AwmGCMnnAQT2qlvnbZHu2', NULL);
INSERT INTO `tb_admin` VALUES ('1203579213031018496', 'weiju.xi', '$2a$10$duM7CUh58ofkCQks6EoDQOaFr1hO2MPXf5iM/Vgoviet96bWWFZvO', NULL);

-- ----------------------------
-- Table structure for tb_follow
-- ----------------------------
DROP TABLE IF EXISTS `tb_follow`;
CREATE TABLE `tb_follow`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `targetuser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被关注用户ID',
  PRIMARY KEY (`userid`, `targetuser`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_follow
-- ----------------------------
INSERT INTO `tb_follow` VALUES ('1', '1');
INSERT INTO `tb_follow` VALUES ('1', '10');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号\r\n',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(20) NULL DEFAULT NULL,
  `level` int(255) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES (100, '彩蛋物语', 0, 1, NULL, 1, NULL, '2019-12-08 22:03:16');
INSERT INTO `tb_menu` VALUES (101, '用户管理', 0, 1, NULL, 1, NULL, '2019-12-08 22:03:16');
INSERT INTO `tb_menu` VALUES (102, '权限管理', 0, 1, NULL, 1, NULL, '2019-12-08 22:03:16');
INSERT INTO `tb_menu` VALUES (103, '系统日志', 0, 1, NULL, 1, NULL, '2019-12-09 21:58:18');
INSERT INTO `tb_menu` VALUES (104, '金彩蛋', 100, 2, 'golds', 1, NULL, '2019-12-09 23:24:03');
INSERT INTO `tb_menu` VALUES (105, '银彩蛋', 100, 2, 'silvers', 1, NULL, '2019-12-09 23:24:25');
INSERT INTO `tb_menu` VALUES (106, '红彩蛋', 100, 2, 'reds', 1, NULL, '2019-12-09 23:24:29');
INSERT INTO `tb_menu` VALUES (107, '用户列表', 101, 2, 'users', 1, NULL, '2019-12-09 23:24:32');
INSERT INTO `tb_menu` VALUES (108, '角色列表', 102, 2, 'roles', 1, NULL, '2019-12-09 23:24:35');
INSERT INTO `tb_menu` VALUES (109, '权限列表', 102, 2, 'functions', 1, NULL, '2019-12-09 23:24:39');
INSERT INTO `tb_menu` VALUES (110, '操作日志', 103, 2, 'operates', 1, NULL, '2019-12-09 23:24:44');
INSERT INTO `tb_menu` VALUES (111, '登录日志', 103, 2, 'logins', 1, NULL, '2019-12-09 23:24:53');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, 'admin', '管理员', '2019-12-08 22:08:46');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES (1, 'admin', 100, '2019-12-08 22:10:25');
INSERT INTO `tb_role_menu` VALUES (2, 'admin', 101, '2019-12-08 22:10:51');
INSERT INTO `tb_role_menu` VALUES (3, 'admin', 102, '2019-12-08 22:10:55');
INSERT INTO `tb_role_menu` VALUES (4, 'admin', 103, '2019-12-08 22:11:02');
INSERT INTO `tb_role_menu` VALUES (5, 'admin', 104, '2019-12-09 22:11:13');
INSERT INTO `tb_role_menu` VALUES (6, 'admin', 105, '2019-12-09 22:11:14');
INSERT INTO `tb_role_menu` VALUES (7, 'admin', 106, '2019-12-09 22:11:14');
INSERT INTO `tb_role_menu` VALUES (9, 'admin', 107, '2019-12-09 22:11:14');
INSERT INTO `tb_role_menu` VALUES (10, 'admin', 108, '2019-12-09 22:11:14');
INSERT INTO `tb_role_menu` VALUES (11, 'admin', 110, '2019-12-09 22:11:14');
INSERT INTO `tb_role_menu` VALUES (12, 'admin', 111, '2019-12-09 22:11:14');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生年月日',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'E-Mail',
  `regdate` datetime(0) NULL DEFAULT NULL COMMENT '注册日期',
  `updatedate` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `lastdate` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆日期',
  `online` bigint(20) NULL DEFAULT NULL COMMENT '在线时长（分钟）',
  `interest` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兴趣',
  `personality` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性',
  `fanscount` int(20) NULL DEFAULT NULL COMMENT '粉丝数',
  `followcount` int(20) NULL DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'testuser', '111111', '小白', '男', '2018-01-08 15:39:19', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (1, '1203502944754995200', 'admin', '2019-12-08 22:09:45');

SET FOREIGN_KEY_CHECKS = 1;
