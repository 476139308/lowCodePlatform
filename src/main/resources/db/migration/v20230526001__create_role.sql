CREATE TABLE `system.role`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(50)  DEFAULT NULL COMMENT '角色名称',
    `key`         varchar(50)  DEFAULT NULL COMMENT '角色的key',
    `sort`        int(11) DEFAULT '0' COMMENT '角色排行',
    `create_by`   varchar(255) DEFAULT NULL COMMENT '创建者用户id',
    `create_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(255) DEFAULT NULL COMMENT '最近一次更新该账户信息的操作者',
    `update_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '最近一次更新的时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '标记信息',
    `deleted`     int(2) DEFAULT NULL COMMENT '是否被刪除\r\n     0：表示未被删除\r\n     1：表示已被删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';