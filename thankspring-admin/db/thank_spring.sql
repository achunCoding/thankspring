/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : thank_spring

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-12-29 17:10:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_attachment
-- ----------------------------
DROP TABLE IF EXISTS `article_attachment`;
CREATE TABLE `article_attachment` (
  `attach_id` bigint(20) NOT NULL,
  `attach_created` datetime DEFAULT NULL COMMENT '上传时间',
  `attach_location` varchar(255) DEFAULT NULL COMMENT '附件存储地址',
  `attach_name` varchar(255) DEFAULT NULL COMMENT '附件名',
  `attach_origin` int(11) DEFAULT NULL COMMENT '附件来源，0：上传，1：外部链接',
  `attach_path` varchar(255) DEFAULT NULL COMMENT '附件路径',
  `attach_size` varchar(255) DEFAULT NULL COMMENT '附件大小',
  `attach_small_path` varchar(255) DEFAULT NULL COMMENT '附件缩略图路径',
  `attach_suffix` varchar(255) DEFAULT NULL COMMENT '附件后缀',
  `attach_type` varchar(255) DEFAULT NULL COMMENT '附件类型',
  `attach_wh` varchar(255) DEFAULT NULL COMMENT '附件长宽',
  PRIMARY KEY (`attach_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='附件';

-- ----------------------------
-- Records of article_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `cate_id` bigint(20) NOT NULL,
  `cate_desc` varchar(255) DEFAULT NULL COMMENT '分类描述',
  `cate_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `cate_url` varchar(255) DEFAULT NULL COMMENT '分类路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='分类';

-- ----------------------------
-- Records of article_category
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `comment_id` bigint(20) NOT NULL,
  `comment_agent` varchar(512) DEFAULT NULL COMMENT '评论者ua信息',
  `comment_author` varchar(255) DEFAULT NULL COMMENT '评论人',
  `comment_author_avatar_md5` varchar(255) DEFAULT NULL COMMENT '评论人的头像，用于gavatar',
  `comment_author_email` varchar(255) DEFAULT NULL COMMENT '评论人邮箱',
  `comment_author_ip` varchar(255) DEFAULT NULL COMMENT '评论人的IP',
  `comment_author_url` varchar(255) DEFAULT NULL COMMENT '评论人的主页',
  `comment_content` longtext COMMENT '评论内容',
  `comment_date` datetime DEFAULT NULL COMMENT '评论时间',
  `comment_parent` bigint(20) DEFAULT NULL COMMENT '上一级',
  `comment_status` int(11) DEFAULT NULL COMMENT '评论状态：0：正常，1：待审核，2：回收站',
  `is_admin` int(11) DEFAULT NULL COMMENT '是否是博主的评论 0：不是 1：是',
  PRIMARY KEY (`comment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of article_comment
-- ----------------------------

-- ----------------------------
-- Table structure for article_gallery
-- ----------------------------
DROP TABLE IF EXISTS `article_gallery`;
CREATE TABLE `article_gallery` (
  `gallery_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gallery_date` varchar(255) DEFAULT NULL COMMENT '图片日期 / 拍摄日期',
  `gallery_desc` varchar(255) DEFAULT NULL COMMENT '图片描述',
  `gallery_location` varchar(255) DEFAULT NULL COMMENT '图片拍摄地点',
  `gallery_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `gallery_thumbnail_url` varchar(255) DEFAULT NULL COMMENT '图片路径地址',
  `gallery_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`gallery_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='相册';

-- ----------------------------
-- Records of article_gallery
-- ----------------------------

-- ----------------------------
-- Table structure for article_link
-- ----------------------------
DROP TABLE IF EXISTS `article_link`;
CREATE TABLE `article_link` (
  `link_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_desc` varchar(255) DEFAULT NULL COMMENT '友情链接名称',
  `link_name` varchar(255) DEFAULT NULL COMMENT '友情链接url',
  `link_pic` varchar(255) DEFAULT NULL COMMENT '友情链接头像',
  `link_url` varchar(255) DEFAULT NULL COMMENT '友情链接描述',
  PRIMARY KEY (`link_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='友情链接';

-- ----------------------------
-- Records of article_link
-- ----------------------------

-- ----------------------------
-- Table structure for article_post
-- ----------------------------
DROP TABLE IF EXISTS `article_post`;
CREATE TABLE `article_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `post_type` varchar(255) DEFAULT NULL COMMENT '文章类型',
  `post_content_md` longtext COMMENT '文章内容 MarkDown',
  `post_content` longtext COMMENT '文章内容 HTML',
  `post_url` varchar(255) DEFAULT NULL COMMENT '文章路径',
  `post_thumbnail` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `post_date` datetime DEFAULT NULL COMMENT '发表日期',
  `post_update` datetime DEFAULT NULL COMMENT '最后一次更新日期',
  `post_status` int(11) DEFAULT NULL COMMENT '0：已发布 1：草稿：2回收站 ',
  `post_views` bigint(20) DEFAULT NULL COMMENT '评论数',
  `allow_comment` int(11) DEFAULT NULL COMMENT '是否允许评论',
  `custom_tpl` varchar(255) DEFAULT NULL COMMENT '指定渲染模板',
  `user_id` bigint(20) DEFAULT NULL COMMENT '提交用户',
  `allow_ping` int(11) DEFAULT NULL COMMENT '是否允许Ping',
  `allow_feed` int(11) DEFAULT NULL COMMENT '是否允许Feed',
  PRIMARY KEY (`post_id`),
  UNIQUE KEY `post_title` (`post_title`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article_post
-- ----------------------------
INSERT INTO `article_post` VALUES ('1', '11111', null, null, null, '11111', null, null, null, '0', null, null, 'markdown', null, null, null);
INSERT INTO `article_post` VALUES ('2', '1111', null, '1111111111111111111', null, '1111', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('3', '11', null, '111111', null, '111', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('5', '1111111111111111', null, '1111111111111111', null, '11111111111111111111', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('6', 'admin', null, '1111111111111111111111111', null, 'admin1', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('7', '111111', null, '1111111111111111111111111111111111', '', '1111', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('9', '1111111111111111111111111111111111111111111111', null, '11111111111111111111111111111', '', '1111', null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('10', null, null, '', '', null, null, null, null, '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('13', '11111111111111111111111111111111111111111111111', null, '', '', null, null, '2018-12-29 13:03:34', '2018-12-29 13:03:34', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('14', null, null, '', '', null, null, '2018-12-29 13:05:15', '2018-12-29 13:05:15', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('15', null, null, '', '', null, null, '2018-12-29 13:06:04', '2018-12-29 13:06:04', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('16', null, null, '', '', null, null, '2018-12-29 13:09:04', '2018-12-29 13:09:04', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('17', null, null, '', '', null, null, '2018-12-29 13:10:42', '2018-12-29 13:10:42', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('18', null, null, '', '', null, null, '2018-12-29 13:13:37', '2018-12-29 13:13:37', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('19', null, null, '', '', null, null, '2018-12-29 13:14:52', '2018-12-29 13:14:52', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('20', null, null, '', '', null, null, '2018-12-29 13:16:21', '2018-12-29 13:16:21', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('22', null, null, '', '', null, null, '2018-12-29 13:19:27', '2018-12-29 13:19:27', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('23', null, null, '', '', null, null, '2018-12-29 13:23:05', '2018-12-29 13:23:05', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('24', null, null, '', '', null, null, '2018-12-29 13:27:01', '2018-12-29 13:27:01', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('25', null, null, '', '', null, null, '2018-12-29 13:27:27', '2018-12-29 13:27:27', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('26', null, null, '', '', null, null, '2018-12-29 13:28:52', '2018-12-29 13:28:52', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('27', null, null, '', '', null, null, '2018-12-29 13:32:52', '2018-12-29 13:32:52', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('28', null, null, '', '', null, null, '2018-12-29 13:33:57', '2018-12-29 13:33:57', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('29', null, null, '', '', null, null, '2018-12-29 13:44:03', '2018-12-29 13:44:03', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('30', null, null, '', '', null, null, '2018-12-29 13:44:40', '2018-12-29 13:44:40', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('33', null, null, '', '', null, null, '2018-12-29 13:50:53', '2018-12-29 13:50:53', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('34', null, null, '', '', null, null, '2018-12-29 13:54:19', '2018-12-29 13:54:19', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('35', null, null, '', '', null, null, '2018-12-29 14:03:01', '2018-12-29 14:03:01', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('36', null, null, '', '', null, null, '2018-12-29 14:03:13', '2018-12-29 14:03:13', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('37', null, null, '', '', null, null, '2018-12-29 14:04:37', '2018-12-29 14:04:37', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('38', null, null, '', '', null, null, '2018-12-29 14:40:54', '2018-12-29 14:40:54', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('39', null, null, '', '', null, null, '2018-12-29 14:43:03', '2018-12-29 14:43:03', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('40', null, null, '', '', null, null, '2018-12-29 14:43:16', '2018-12-29 14:43:16', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('41', null, null, '', '', null, null, '2018-12-29 14:57:41', '2018-12-29 14:57:41', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('42', null, null, '', '', null, null, '2018-12-29 14:58:11', '2018-12-29 14:58:11', '0', null, '1', 'markdown', null, '1', '1');
INSERT INTO `article_post` VALUES ('43', null, null, '', '', null, null, '2018-12-29 15:00:22', '2018-12-29 15:00:22', '0', null, '1', 'markdown', null, '1', '1');

-- ----------------------------
-- Table structure for article_post_category
-- ----------------------------
DROP TABLE IF EXISTS `article_post_category`;
CREATE TABLE `article_post_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL COMMENT '文章ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章与分类对应关系';

-- ----------------------------
-- Records of article_post_category
-- ----------------------------

-- ----------------------------
-- Table structure for article_post_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_post_tag`;
CREATE TABLE `article_post_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL COMMENT '文章ID',
  `tag_id` bigint(20) DEFAULT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 COMMENT='文章与标签对应关系';

-- ----------------------------
-- Records of article_post_tag
-- ----------------------------
INSERT INTO `article_post_tag` VALUES ('56', '22', '32');
INSERT INTO `article_post_tag` VALUES ('57', '22', '33');
INSERT INTO `article_post_tag` VALUES ('58', '23', '32');
INSERT INTO `article_post_tag` VALUES ('59', '23', '34');
INSERT INTO `article_post_tag` VALUES ('60', '23', '36');
INSERT INTO `article_post_tag` VALUES ('61', '23', '36');
INSERT INTO `article_post_tag` VALUES ('62', '24', '37');
INSERT INTO `article_post_tag` VALUES ('63', '24', '38');
INSERT INTO `article_post_tag` VALUES ('64', '25', '37');
INSERT INTO `article_post_tag` VALUES ('65', '25', '38');
INSERT INTO `article_post_tag` VALUES ('66', '25', '39');
INSERT INTO `article_post_tag` VALUES ('67', '25', '40');
INSERT INTO `article_post_tag` VALUES ('68', '26', '37');
INSERT INTO `article_post_tag` VALUES ('69', '26', '38');
INSERT INTO `article_post_tag` VALUES ('70', '26', '39');
INSERT INTO `article_post_tag` VALUES ('71', '26', '40');
INSERT INTO `article_post_tag` VALUES ('72', '26', '41');
INSERT INTO `article_post_tag` VALUES ('73', '26', '42');
INSERT INTO `article_post_tag` VALUES ('74', '26', '43');
INSERT INTO `article_post_tag` VALUES ('75', '26', '44');
INSERT INTO `article_post_tag` VALUES ('76', '27', '45');
INSERT INTO `article_post_tag` VALUES ('77', '27', '46');
INSERT INTO `article_post_tag` VALUES ('78', '28', '45');
INSERT INTO `article_post_tag` VALUES ('79', '28', '46');
INSERT INTO `article_post_tag` VALUES ('80', '28', '47');
INSERT INTO `article_post_tag` VALUES ('81', '28', '48');
INSERT INTO `article_post_tag` VALUES ('82', '29', '49');
INSERT INTO `article_post_tag` VALUES ('83', '29', '50');
INSERT INTO `article_post_tag` VALUES ('84', '30', '49');
INSERT INTO `article_post_tag` VALUES ('85', '30', '50');
INSERT INTO `article_post_tag` VALUES ('86', '30', '51');
INSERT INTO `article_post_tag` VALUES ('87', '30', '52');
INSERT INTO `article_post_tag` VALUES ('88', '33', '53');
INSERT INTO `article_post_tag` VALUES ('89', '33', '54');
INSERT INTO `article_post_tag` VALUES ('90', '34', '53');
INSERT INTO `article_post_tag` VALUES ('91', '34', '54');
INSERT INTO `article_post_tag` VALUES ('92', '34', '55');
INSERT INTO `article_post_tag` VALUES ('93', '34', '56');
INSERT INTO `article_post_tag` VALUES ('94', '35', '57');
INSERT INTO `article_post_tag` VALUES ('95', '35', '58');
INSERT INTO `article_post_tag` VALUES ('96', '36', '57');
INSERT INTO `article_post_tag` VALUES ('97', '36', '58');
INSERT INTO `article_post_tag` VALUES ('98', '36', '59');
INSERT INTO `article_post_tag` VALUES ('99', '36', '60');
INSERT INTO `article_post_tag` VALUES ('100', '37', '61');
INSERT INTO `article_post_tag` VALUES ('101', '37', '62');
INSERT INTO `article_post_tag` VALUES ('102', '37', '63');
INSERT INTO `article_post_tag` VALUES ('103', '37', '64');
INSERT INTO `article_post_tag` VALUES ('104', '37', '65');
INSERT INTO `article_post_tag` VALUES ('105', '37', '66');
INSERT INTO `article_post_tag` VALUES ('106', '37', '67');
INSERT INTO `article_post_tag` VALUES ('107', '37', '68');
INSERT INTO `article_post_tag` VALUES ('108', '38', '61');
INSERT INTO `article_post_tag` VALUES ('109', '38', '62');
INSERT INTO `article_post_tag` VALUES ('110', '38', '63');
INSERT INTO `article_post_tag` VALUES ('111', '38', '64');
INSERT INTO `article_post_tag` VALUES ('112', '38', '65');
INSERT INTO `article_post_tag` VALUES ('113', '38', '66');
INSERT INTO `article_post_tag` VALUES ('114', '38', '67');
INSERT INTO `article_post_tag` VALUES ('115', '38', '68');
INSERT INTO `article_post_tag` VALUES ('116', '39', '69');
INSERT INTO `article_post_tag` VALUES ('117', '39', '70');
INSERT INTO `article_post_tag` VALUES ('118', '40', '69');
INSERT INTO `article_post_tag` VALUES ('119', '40', '70');
INSERT INTO `article_post_tag` VALUES ('120', '41', '69');
INSERT INTO `article_post_tag` VALUES ('121', '41', '70');
INSERT INTO `article_post_tag` VALUES ('122', '42', '69');
INSERT INTO `article_post_tag` VALUES ('123', '42', '70');
INSERT INTO `article_post_tag` VALUES ('124', '43', '69');
INSERT INTO `article_post_tag` VALUES ('125', '43', '70');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  `tag_url` varchar(255) DEFAULT NULL COMMENT '标签Url',
  PRIMARY KEY (`tag_id`)
) ENGINE=MyISAM AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='标签';

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES ('69', '1111', null);
INSERT INTO `article_tag` VALUES ('70', '2222', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='系统日志';

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
INSERT INTO `sys_log` VALUES ('31', 'admin', '更新角色', 'top.wycfight.thankspring.modules.sys.controller.SysRoleController,update()', '{\"roleId\":3,\"roleName\":\"嘻嘻\",\"remark\":\"嘻嘻嘻嘻\",\"deptId\":1,\"deptName\":\"春纯蠢唇\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,27,29,31,32,33,34,35,36,37,38,39,40],\"deptIdList\":[],\"createTime\":\"Dec 20, 2018 8:35:00 AM\",\"updateTime\":\"Dec 20, 2018 10:43:02 AM\"}', '92', '0:0:0:0:0:0:0:1', '2018-12-20 10:43:02', '2018-12-20 10:43:02');
INSERT INTO `sys_log` VALUES ('32', 'admin', '删除角色', 'top.wycfight.thankspring.modules.sys.controller.SysRoleController,delete()', '[1,2,3]', '32', '0:0:0:0:0:0:0:1', '2018-12-20 10:59:03', '2018-12-20 10:59:03');
INSERT INTO `sys_log` VALUES ('33', 'admin', '保存角色', 'top.wycfight.thankspring.modules.sys.controller.SysRoleController,save()', '{\"roleId\":4,\"roleName\":\"123213\",\"remark\":\"213213213\",\"deptId\":1,\"deptName\":\"春纯蠢唇\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,27,29,31,32,33,34,35,36,37,38,39,40],\"deptIdList\":[],\"createTime\":\"Dec 20, 2018 11:02:38 AM\",\"updateTime\":\"Dec 20, 2018 11:02:38 AM\"}', '4369', '0:0:0:0:0:0:0:1', '2018-12-20 11:02:38', '2018-12-20 11:02:38');
INSERT INTO `sys_log` VALUES ('34', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":2,\"username\":\"1111\",\"password\":\"ab1f3ee7b29565018e462043781f5f59b43741daefa8e0abeda48259f50b9128\",\"salt\":\"5FQmGUnFmXkfiDoFfhrv\",\"email\":\"111@qq.com\",\"mobile\":\"17865913036\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 20, 2018 4:24:58 PM\",\"updateTime\":\"Dec 20, 2018 4:24:58 PM\"}', '3639', '0:0:0:0:0:0:0:1', '2018-12-20 16:24:58', '2018-12-20 16:24:58');
INSERT INTO `sys_log` VALUES ('35', 'admin', '保存用户', 'top.wycfight.thankspring.modules.sys.controller.SysUserController,save()', '{\"userId\":3,\"username\":\"typ\",\"password\":\"c193698486863387a188857561ca6a82e900536a86a4d6d94fe182031c211c51\",\"salt\":\"Xiia694xCeZMTWui8Pkx\",\"email\":\"typ@qq.com\",\"mobile\":\"17865913036\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Dec 20, 2018 5:21:57 PM\",\"updateTime\":\"Dec 20, 2018 5:21:57 PM\",\"deptId\":2,\"deptName\":\"你说啥呢\"}', '4140', '0:0:0:0:0:0:0:1', '2018-12-20 17:21:57', '2018-12-20 17:21:57');
INSERT INTO `sys_log` VALUES ('36', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":41,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"博客管理\",\"type\":0,\"icon\":\"fa fa-heart\",\"orderNum\":1}', '81', '0:0:0:0:0:0:0:1', '2018-12-25 08:35:10', '2018-12-25 08:35:10');
INSERT INTO `sys_log` VALUES ('37', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"文章\",\"url\":\"blog/post/list\",\"perms\":\"blog:post:list\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '231', '0:0:0:0:0:0:0:1', '2018-12-25 09:55:39', '2018-12-25 09:55:39');
INSERT INTO `sys_log` VALUES ('38', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"文章\",\"url\":\"blog/post/list.html\",\"perms\":\"blog:post:list\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '20', '0:0:0:0:0:0:0:1', '2018-12-25 09:56:18', '2018-12-25 09:56:18');
INSERT INTO `sys_log` VALUES ('39', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"文章\",\"url\":\"blog/post/list.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '11', '0:0:0:0:0:0:0:1', '2018-12-25 09:57:47', '2018-12-25 09:57:47');
INSERT INTO `sys_log` VALUES ('40', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"文章\",\"url\":\"admin/article/new.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '27', '0:0:0:0:0:0:0:1', '2018-12-26 16:10:50', '2018-12-26 16:10:50');
INSERT INTO `sys_log` VALUES ('41', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"发布文章\",\"url\":\"admin/article/new.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '31', '0:0:0:0:0:0:0:1', '2018-12-26 16:13:48', '2018-12-26 16:13:48');
INSERT INTO `sys_log` VALUES ('42', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":43,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"查看\",\"perms\":\"admin:article:new:list\",\"type\":2,\"orderNum\":0}', '13', '0:0:0:0:0:0:0:1', '2018-12-26 16:40:14', '2018-12-26 16:40:14');
INSERT INTO `sys_log` VALUES ('43', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":44,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"新增\",\"perms\":\"admin:article:new:save\",\"type\":2,\"orderNum\":0}', '12', '0:0:0:0:0:0:0:1', '2018-12-26 16:40:45', '2018-12-26 16:40:45');
INSERT INTO `sys_log` VALUES ('44', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":45,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"修改\",\"perms\":\"admin:article:new:update\",\"type\":2,\"orderNum\":0}', '14', '0:0:0:0:0:0:0:1', '2018-12-26 16:41:08', '2018-12-26 16:41:08');
INSERT INTO `sys_log` VALUES ('45', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":46,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"删除\",\"perms\":\"admin:article:new:delete\",\"type\":2,\"orderNum\":0}', '12', '0:0:0:0:0:0:0:1', '2018-12-26 16:41:26', '2018-12-26 16:41:26');
INSERT INTO `sys_log` VALUES ('46', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":42,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"发布文章\",\"url\":\"admin/article/post.html\",\"perms\":\"\",\"type\":1,\"icon\":\"fa fa-book\",\"orderNum\":0}', '37', '0:0:0:0:0:0:0:1', '2018-12-27 10:39:13', '2018-12-27 10:39:13');
INSERT INTO `sys_log` VALUES ('47', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":43,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"查看\",\"perms\":\"article:post:list\",\"type\":2,\"orderNum\":0}', '11', '0:0:0:0:0:0:0:1', '2018-12-27 10:39:28', '2018-12-27 10:39:28');
INSERT INTO `sys_log` VALUES ('48', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":44,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"新增\",\"perms\":\"article:post:save\",\"type\":2,\"orderNum\":0}', '11', '0:0:0:0:0:0:0:1', '2018-12-27 10:39:44', '2018-12-27 10:39:44');
INSERT INTO `sys_log` VALUES ('49', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":45,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"修改\",\"perms\":\"article:post:update\",\"type\":2,\"orderNum\":0}', '9', '0:0:0:0:0:0:0:1', '2018-12-27 10:39:54', '2018-12-27 10:39:54');
INSERT INTO `sys_log` VALUES ('50', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":46,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"删除\",\"perms\":\"article:post:delete\",\"type\":2,\"orderNum\":0}', '10', '0:0:0:0:0:0:0:1', '2018-12-27 10:40:05', '2018-12-27 10:40:05');
INSERT INTO `sys_log` VALUES ('51', 'admin', '删除角色', 'top.wycfight.thankspring.modules.sys.controller.SysRoleController,delete()', '[4]', '48', '0:0:0:0:0:0:0:1', '2018-12-27 13:52:10', '2018-12-27 13:52:10');
INSERT INTO `sys_log` VALUES ('52', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":47,\"parentId\":41,\"parentName\":\"博客管理\",\"name\":\"其他设置\",\"type\":0,\"icon\":\"fa fa-wrench\",\"orderNum\":0}', '28', '0:0:0:0:0:0:0:1', '2018-12-28 16:22:13', '2018-12-28 16:22:13');
INSERT INTO `sys_log` VALUES ('53', 'admin', '保存菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,save()', '{\"menuId\":48,\"parentId\":47,\"parentName\":\"其他设置\",\"name\":\"分类/标签\",\"url\":\"/article/category/list\",\"type\":1,\"icon\":\"fa fa-paper-plane-o\",\"orderNum\":0}', '10', '0:0:0:0:0:0:0:1', '2018-12-28 16:24:34', '2018-12-28 16:24:34');
INSERT INTO `sys_log` VALUES ('54', 'admin', '更新菜单', 'top.wycfight.thankspring.modules.sys.controller.SysMenuController,update()', '{\"menuId\":44,\"parentId\":42,\"parentName\":\"发布文章\",\"name\":\"新增\",\"perms\":\"article:post:save,article:category:select\",\"type\":2,\"orderNum\":0}', '24', '0:0:0:0:0:0:0:1', '2018-12-28 16:25:10', '2018-12-28 16:25:10');

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

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
INSERT INTO `sys_menu` VALUES ('41', '0', '博客管理', null, null, '0', 'fa fa-heart', '1');
INSERT INTO `sys_menu` VALUES ('42', '41', '发布文章', 'admin/article/post.html', '', '1', 'fa fa-book', '0');
INSERT INTO `sys_menu` VALUES ('43', '42', '查看', null, 'article:post:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('44', '42', '新增', null, 'article:post:save,article:category:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('45', '42', '修改', null, 'article:post:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('46', '42', '删除', null, 'article:post:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('47', '41', '其他设置', null, null, '0', 'fa fa-wrench', '0');
INSERT INTO `sys_menu` VALUES ('48', '47', '分类/标签', '/article/category/list', null, '1', 'fa fa-paper-plane-o', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11', '2018-12-17 08:19:46');
INSERT INTO `sys_user` VALUES ('2', '1111', 'ab1f3ee7b29565018e462043781f5f59b43741daefa8e0abeda48259f50b9128', '5FQmGUnFmXkfiDoFfhrv', '111@qq.com', '17865913036', '1', null, '2018-12-20 16:24:58', '2018-12-20 16:24:58');
INSERT INTO `sys_user` VALUES ('3', 'typ', 'c193698486863387a188857561ca6a82e900536a86a4d6d94fe182031c211c51', 'Xiia694xCeZMTWui8Pkx', 'typ@qq.com', '17865913036', '1', '2', '2018-12-20 17:21:57', '2018-12-20 17:21:57');

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
