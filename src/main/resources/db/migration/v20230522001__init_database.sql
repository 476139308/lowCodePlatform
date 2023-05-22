CREATE DATABASE `platform` CHARACTER SET 'utf8mb4';

CREATE TABLE `system_user`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(50)  NOT NULL COMMENT '用户名',
    `password`    varchar(255) NOT NULL COMMENT '密码',
    `id_card`     varchar(20)  DEFAULT NULL COMMENT '身份证号码',
    `email`       varchar(100) DEFAULT NULL COMMENT '邮箱地址',
    `phone`       varchar(20)  DEFAULT NULL COMMENT '手机号',
    `birthday`    date         DEFAULT NULL COMMENT '生日',
    `gender`      int(11)      DEFAULT NULL COMMENT '性别，1是男，2是女',
    `last_login`  datetime     DEFAULT NULL COMMENT '最近一次登录时间',
    `status`      int(11)      DEFAULT '0' COMMENT '用户账户状态，0为正常状态，1为禁用',
    `create_by`   varchar(255) DEFAULT NULL COMMENT '创建者用户id',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(255) DEFAULT NULL COMMENT '最近一次更新该账户信息的操作者',
    `update_time` datetime     DEFAULT NULL COMMENT '最近一次更新的时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '标记信息',
    `deleted`     int(2)       DEFAULT NULL COMMENT '是否被刪除\r\n     0：表示未被删除\r\n     1：表示已被删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;