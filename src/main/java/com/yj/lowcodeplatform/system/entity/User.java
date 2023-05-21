package com.yj.lowcodeplatform.system.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName User
 * @Author YuJin
 * @Date 2023/5/20 17:17
 * @Version 1.0.0
 */
@Entity
@Table(name = "system_user")
@Data
public class User {
    @Id
    private Integer id;
}
