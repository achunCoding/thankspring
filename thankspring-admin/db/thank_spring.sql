/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : thank_spring

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-12-19 17:23:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '春纯蠢唇', '0', '0', null, null);
INSERT INTO `sys_dept` VALUES ('2', '1', '你说啥呢', '1', '0', '2018-12-19 14:18:54', '2018-12-19 14:18:54');
INSERT INTO `sys_dept` VALUES ('3', '1', '111', '1', '-1', '2018-12-19 14:30:54', '2018-12-19 14:42:02');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":2,\"username\":\"wyc\",\"password\":\"98d083aeb19afecf32db03fd30f2f036a6eb579956dfd05d9e27d56cd047a238\",\"salt\":\"O0QBV73HI5lXcGZB2Z1z\",\"email\":\"123@qq.com\",\"mobile\":\"13888888888\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 9:39:56 AM\",\"updateTime\":\"Dec 18, 2018 9:39:56 AM\"}', '89', '0:0:0:0:0:0:0:1', '2018-12-18 09:39:56', '2018-12-18 09:39:56');
INSERT INTO `sys_log` VALUES ('2', 'admin', '更新用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,update()', null, '0', '0:0:0:0:0:0:0:1', '2018-12-18 10:48:54', '2018-12-18 10:48:54');
INSERT INTO `sys_log` VALUES ('3', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":4,\"username\":\"typ\",\"password\":\"29dc3fce607bf1f09544ba7ed8a6cc0f52988cad56ef552074b828170d414829\",\"salt\":\"SzwPrpppXuRhODkORP8Y\",\"email\":\"111@qq.com\",\"mobile\":\"111\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 10:55:09 AM\",\"updateTime\":\"Dec 18, 2018 10:55:09 AM\"}', '13', '0:0:0:0:0:0:0:1', '2018-12-18 10:55:09', '2018-12-18 10:55:09');
INSERT INTO `sys_log` VALUES ('4', 'admin', '更新用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,update()', '{\"userId\":2,\"username\":\"wyc\",\"salt\":\"O0QBV73HI5lXcGZB2Z1z\",\"email\":\"123@qq.com\",\"mobile\":\"138888888889\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 9:39:56 AM\",\"updateTime\":\"Dec 18, 2018 11:06:30 AM\"}', '2306', '0:0:0:0:0:0:0:1', '2018-12-18 11:06:30', '2018-12-18 11:06:30');
INSERT INTO `sys_log` VALUES ('5', 'admin', '更新用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,update()', '{\"userId\":2,\"username\":\"wyc\",\"salt\":\"O0QBV73HI5lXcGZB2Z1z\",\"email\":\"123@qq.com\",\"mobile\":\"138888888889\",\"status\":0,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 9:39:56 AM\",\"updateTime\":\"Dec 18, 2018 11:06:48 AM\"}', '2235', '0:0:0:0:0:0:0:1', '2018-12-18 11:06:48', '2018-12-18 11:06:48');
INSERT INTO `sys_log` VALUES ('6', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[2]', '10785', '0:0:0:0:0:0:0:1', '2018-12-18 11:20:53', '2018-12-18 11:20:53');
INSERT INTO `sys_log` VALUES ('7', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[2]', '3646', '0:0:0:0:0:0:0:1', '2018-12-18 11:21:01', '2018-12-18 11:21:01');
INSERT INTO `sys_log` VALUES ('8', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":5,\"username\":\"123\",\"password\":\"bfede6550c8dc5d969731b98fd43ba58a5f669174db9ba3d808789a58b36ef0b\",\"salt\":\"KYzQKrsVyTIOCGh4ArMQ\",\"email\":\"123@qq.com\",\"mobile\":\"12321312\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 11:22:09 AM\",\"updateTime\":\"Dec 18, 2018 11:22:09 AM\"}', '85', '0:0:0:0:0:0:0:1', '2018-12-18 11:22:09', '2018-12-18 11:22:09');
INSERT INTO `sys_log` VALUES ('9', 'admin', '更新用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,update()', '{\"userId\":5,\"username\":\"123\",\"salt\":\"KYzQKrsVyTIOCGh4ArMQ\",\"email\":\"123@qq.com\",\"mobile\":\"12321312111\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 11:22:09 AM\",\"updateTime\":\"Dec 18, 2018 11:22:18 AM\"}', '2606', '0:0:0:0:0:0:0:1', '2018-12-18 11:22:18', '2018-12-18 11:22:18');
INSERT INTO `sys_log` VALUES ('10', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[5]', '8113', '0:0:0:0:0:0:0:1', '2018-12-18 11:22:31', '2018-12-18 11:22:31');
INSERT INTO `sys_log` VALUES ('11', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[4]', '5328', '0:0:0:0:0:0:0:1', '2018-12-18 12:39:14', '2018-12-18 12:39:14');
INSERT INTO `sys_log` VALUES ('12', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":5,\"username\":\"111\",\"password\":\"64694292c3b169a07d02d0212b4219fca7f1ab189d0b4b5ff584fc3facea8987\",\"salt\":\"xIxsbyv5O0U0Ybe469zt\",\"email\":\"11@qq.com\",\"mobile\":\"1111\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 12:42:12 PM\",\"updateTime\":\"Dec 18, 2018 12:42:12 PM\"}', '85', '0:0:0:0:0:0:0:1', '2018-12-18 12:42:12', '2018-12-18 12:42:12');
INSERT INTO `sys_log` VALUES ('13', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[5]', '2996', '0:0:0:0:0:0:0:1', '2018-12-18 12:42:30', '2018-12-18 12:42:30');
INSERT INTO `sys_log` VALUES ('14', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '2429', '0:0:0:0:0:0:0:1', '2018-12-18 12:44:26', '2018-12-18 12:44:26');
INSERT INTO `sys_log` VALUES ('15', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '1235', '0:0:0:0:0:0:0:1', '2018-12-18 12:44:48', '2018-12-18 12:44:48');
INSERT INTO `sys_log` VALUES ('16', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '906', '0:0:0:0:0:0:0:1', '2018-12-18 12:44:53', '2018-12-18 12:44:53');
INSERT INTO `sys_log` VALUES ('17', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '1942', '0:0:0:0:0:0:0:1', '2018-12-18 12:45:15', '2018-12-18 12:45:15');
INSERT INTO `sys_log` VALUES ('18', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '0', '0:0:0:0:0:0:0:1', '2018-12-18 12:45:30', '2018-12-18 12:45:30');
INSERT INTO `sys_log` VALUES ('19', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '0', '0:0:0:0:0:0:0:1', '2018-12-18 12:46:11', '2018-12-18 12:46:11');
INSERT INTO `sys_log` VALUES ('20', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":6,\"username\":\"1111\",\"password\":\"45ea579974e9c01163eb998f77bf95667a844e4b51d2aea3dbf045114dcd987e\",\"salt\":\"j77AOBEc5mekhYzIppVq\",\"email\":\"1111@qq.com\",\"mobile\":\"11111\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 12:46:34 PM\",\"updateTime\":\"Dec 18, 2018 12:46:34 PM\"}', '9', '0:0:0:0:0:0:0:1', '2018-12-18 12:46:34', '2018-12-18 12:46:34');
INSERT INTO `sys_log` VALUES ('21', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[6]', '12', '0:0:0:0:0:0:0:1', '2018-12-18 12:46:38', '2018-12-18 12:46:38');
INSERT INTO `sys_log` VALUES ('22', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":7,\"username\":\"typ\",\"password\":\"e19876e11e407e755bc3bb0527ecbaaeae80819cc914620273dc0d912f05ac9d\",\"salt\":\"3YOHnMf09QC3f16LJBsI\",\"email\":\"123@qq.com\",\"mobile\":\"17865913036\",\"status\":0,\"roleIdList\":[],\"createTime\":\"Dec 18, 2018 2:59:51 PM\",\"updateTime\":\"Dec 18, 2018 2:59:51 PM\"}', '3326', '0:0:0:0:0:0:0:1', '2018-12-18 14:59:51', '2018-12-18 14:59:51');
INSERT INTO `sys_log` VALUES ('23', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[7]', '27', '0:0:0:0:0:0:0:1', '2018-12-18 15:00:02', '2018-12-18 15:00:02');
INSERT INTO `sys_log` VALUES ('24', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[1]', '0', '0:0:0:0:0:0:0:1', '2018-12-18 15:00:28', '2018-12-18 15:00:28');
INSERT INTO `sys_log` VALUES ('25', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":2,\"username\":\"1111\",\"password\":\"4918ff00083cd60d824f02e34666b7b3b793d9f1b6e798f737c2b4596d4f59bd\",\"salt\":\"9xIIwqDONOe3uXE415i4\",\"email\":\"111@qq.com\",\"mobile\":\"17865913036\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 19, 2018 9:35:55 AM\",\"updateTime\":\"Dec 19, 2018 9:35:55 AM\"}', '22', '0:0:0:0:0:0:0:1', '2018-12-19 09:35:55', '2018-12-19 09:35:55');
INSERT INTO `sys_log` VALUES ('26', 'admin', '删除用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,delete()', '[2]', '19', '0:0:0:0:0:0:0:1', '2018-12-19 09:53:19', '2018-12-19 09:53:19');
INSERT INTO `sys_log` VALUES ('27', 'admin', '添加部门', 'top.wycfight.thankspring.modules.sys.controller.SysDeptController,save()', '{\"deptId\":1,\"parentId\":0,\"name\":\"春纯蠢唇\",\"parentName\":\"一级部门\",\"orderNum\":0}', '90', '0:0:0:0:0:0:0:1', '2018-12-19 14:15:41', '2018-12-19 14:15:41');
INSERT INTO `sys_log` VALUES ('28', 'admin', '添加部门', 'top.wycfight.thankspring.modules.sys.controller.SysDeptController,save()', '{\"deptId\":2,\"parentId\":1,\"name\":\"你说啥呢\",\"parentName\":\"春纯蠢唇\",\"orderNum\":1,\"createTime\":\"Dec 19, 2018 2:18:54 PM\",\"updateTime\":\"Dec 19, 2018 2:18:54 PM\"}', '79', '0:0:0:0:0:0:0:1', '2018-12-19 14:18:54', '2018-12-19 14:18:54');
INSERT INTO `sys_log` VALUES ('29', 'admin', '添加部门', 'top.wycfight.thankspring.modules.sys.controller.SysDeptController,save()', '{\"deptId\":3,\"parentId\":2,\"name\":\"hahahah\",\"parentName\":\"你说啥呢\",\"orderNum\":1,\"createTime\":\"Dec 19, 2018 2:30:54 PM\",\"updateTime\":\"Dec 19, 2018 2:30:54 PM\"}', '75', '0:0:0:0:0:0:0:1', '2018-12-19 14:30:54', '2018-12-19 14:30:54');
INSERT INTO `sys_log` VALUES ('30', 'admin', '删除部门', 'top.wycfight.thankspring.modules.sys.controller.SysDeptController,delete()', '3', '6853', '0:0:0:0:0:0:0:1', '2018-12-19 15:37:28', '2018-12-19 15:37:28');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('31', '1', '部门管理', 'modules/sys/dept.html', null, '1', 'fa fa-file-code-o', '1');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'sys:dept:list,sys:dept:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'sys:dept:save,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'sys:dept:update,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'sys:dept:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('36', '1', '字典管理', 'modules/sys/dict.html', null, '1', 'fa fa-bookmark-o', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'sys:dict:list,sys:dict:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'sys:dict:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'sys:dict:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'sys:dict:delete', '2', null, '6');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11', '2018-12-17 08:19:46');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
