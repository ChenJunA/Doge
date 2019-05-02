/* 系统日志表 */
CREATE TABLE `doge_log` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问者IP',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '请求地址',
  `method` varchar(255) NOT NULL DEFAULT '' COMMENT '请求方法',
  `browser` varchar(100) DEFAULT '' COMMENT '浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 用户表 */
CREATE TABLE `doge_user` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(300) NOT NULL DEFAULT '' COMMENT '密码',
  `picture` varchar(100) NOT NULL DEFAULT '' COMMENT '封面图片',
  `avatar` varchar(100) NOT NULL DEFAULT '' COMMENT '头像',
  `sex` varchar(10) NOT NULL DEFAULT '' COMMENT '性别',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT '地址',
  `phone_number` varchar(20) NOT NULL DEFAULT '' COMMENT '电话号码',
  `biography` varchar(500) NOT NULL DEFAULT '' COMMENT '个人简介',
  `Followers_number` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '粉丝数',
  `Following_number` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '关注数',
  `stars` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞数',
  `is_ban` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否封禁，默认为0未封禁，1为已封禁',
  `is_active` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否激活，默认为0未激活，1为已激活',
   PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 角色表*/
CREATE TABLE `doge_role` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 权限表*/
CREATE TABLE `doge_permision` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 用户_角色对应表 */
CREATE TABLE `doge_user_role` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 角色_权限对应表 */
CREATE TABLE `doge_role_permision` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  `permission_id` bigint UNSIGNED NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 动物分类表 1——流浪狗，2——宠物狗，3——推荐*/
CREATE TABLE `doge_dog_type` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '分类下的动物数量',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 动物状态表 1——待领养，2——领养中，3——已领养*/
CREATE TABLE `doge_dog_state` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(20) NOT NULL COMMENT '状态名称',
  `number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '状态下的动物数量',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 动物表 */
CREATE TABLE `doge_dog` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` bigint UNSIGNED NOT NULL COMMENT '类别',
  `foster` bigint UNSIGNED NOT NULL COMMENT '发布人',
  `adopt` bigint UNSIGNED COMMENT '领养人',
  `adopt_time` datetime COMMENT '领养时间',
  `state` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `dog_name` varchar(50) NOT NULL DEFAULT '' COMMENT '动物名',
  `sex` varchar(300) NOT NULL DEFAULT '' COMMENT '性别',
  `age` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '年龄',
  `address` varchar(200) NOT NULL DEFAULT '' COMMENT '地址',
  `is_vaccine` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否注射疫苗，默认为0未注射疫苗，1为已注射疫苗',
  `dog_describe` varchar(1000) NOT NULL DEFAULT '' COMMENT '描述',
  `picture` varchar(100) NOT NULL DEFAULT '' COMMENT '图片',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 留言、评论表 */
CREATE TABLE `doge_comment` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '评论人ID',
  `dog_id` bigint UNSIGNED NOT NULL COMMENT '动物ID',
  `content` varchar(200) NOT NULL DEFAULT '' COMMENT '留言/评论内容',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 用户关注表 */
CREATE TABLE `doge_follow` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `follower_id` bigint UNSIGNED NOT NULL COMMENT 'followerID',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 用户收藏表 */
CREATE TABLE `doge_collection` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `dog_id` bigint UNSIGNED NOT NULL COMMENT '动物ID',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 

/* 图片分类表 1——用户图片，2——动物图片，3——论坛图片*/
CREATE TABLE `doge_picture_category` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '分类下的图片数量',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 图片表 */
CREATE TABLE `doge_picture` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `category`  tinyint(1) UNSIGNED NOT NULL COMMENT '图片类别',
  `picture` bigint UNSIGNED NOT NULL COMMENT '图片路径',
  `x_id` bigint UNSIGNED NOT NULL COMMENT '人，动物，论坛ID',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 论坛帖子表 */
CREATE TABLE `doge_article` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '发帖用户ID',
  `title` varchar(300) NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(1000) NOT NULL DEFAULT '' COMMENT '内容',
  `reply_num`  bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '回复数量',
  `view_num` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 论坛回复表 */
CREATE TABLE `doge_reply` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '回复用户ID',
  `article_id` bigint UNSIGNED NOT NULL COMMENT '文章ID',
  `content` varchar(1000) NOT NULL DEFAULT '' COMMENT '回复内容',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


