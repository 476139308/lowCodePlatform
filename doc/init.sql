CREATE TABLE `system_user`
(
    `id`          bigint(20)   NOT NULL COMMENT '主键',
    `username`    varchar(50)  NOT NULL COMMENT '用户名',
    `password`    varchar(100) NOT NULL COMMENT '密码',
    `id_card`     varchar(20)  DEFAULT NULL COMMENT '身份证号码',
    `email`       varchar(100) DEFAULT NULL COMMENT '邮箱地址',
    `phone`       varchar(15)  DEFAULT NULL COMMENT '手机号码',
    `birthday`    date         DEFAULT NULL COMMENT '生日',
    `status`      varchar(30)  DEFAULT NULL COMMENT '状态',
    `last_login`  datetime     DEFAULT NULL COMMENT '上次登录事件',
    `create_by`   varchar(100) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_by`   varchar(100) DEFAULT NULL COMMENT '修改者',
    `update_time` datetime     NOT NULL COMMENT '修改事件',
    `is_deleted`  int(10)      DEFAULT NULL COMMENT '是否被删除',
    `remark`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;