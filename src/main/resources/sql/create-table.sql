DROP TABLE IF EXISTS `d1_user`;
CREATE TABLE `d1_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 2018-04-12 新增 start
alter table d1_user add column user_no varchar(20) not null comment '用户No' after user_name;

CREATE TABLE `d1_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_no` varchar(20) NOT NULL COMMENT '用户号',
  `role_no` varchar(20) NOT NULL COMMENT '角色编号',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `d1_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(100) NOT NULL COMMENT '资源路径',
  `url_id` varchar(20) NOT NULL COMMENT '资源ID',
  `url_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `method_name` varchar(50) DEFAULT NULL COMMENT '资源对应的方法名',
  `method_path` varchar(50) DEFAULT NULL COMMENT '资源对应的包路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

CREATE TABLE `d1_resource_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_no` varchar(20) NOT NULL COMMENT '角色编号',
  `url_id` varchar(20) NOT NULL COMMENT '资源ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源角色映射表';
-- 2018-04-12 新增 end