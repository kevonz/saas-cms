delimiter $$

CREATE DATABASE `kevondb` /*!40100 DEFAULT CHARACTER SET utf8 */$$

delimiter $$

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGIdelimiter $$

delimiter $$

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `password` char(32) NOT NULL COMMENT '密码',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `register_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '注册IP',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '最后登录IP',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `reset_key` char(32) DEFAULT NULL COMMENT '重置密码KEY',
  `reset_pwd` varchar(16) DEFAULT NULL COMMENT '重置密码VALUE',
  `error_time` datetime DEFAULT NULL COMMENT '登录错误时间',
  `error_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录错误次数',
  `error_ip` varchar(50) DEFAULT NULL COMMENT '登录错误IP',
  `activation` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活状态',
  `activation_code` char(32) DEFAULT NULL COMMENT '激活码',
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `ak_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表'$$