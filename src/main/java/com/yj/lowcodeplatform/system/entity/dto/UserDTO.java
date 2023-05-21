package com.yj.lowcodeplatform.system.entity.dto;


import com.yj.lowcodeplatform.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote
 * @since 2023/5/21 16:01
 */
@Data
public class UserDTO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;


    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 身份证号码
     */
    private String idCard;


    /**
     * 邮箱地址
     */
    private String email;


    /**
     * 手机号码
     */
    private String phone;


    /**
     * 生日
     */
    private LocalDate birthday;


    /**
     * 状态 ：默认为0，即可使用，1为禁用
     */
    private Integer status;


    /**
     * 上次登录事件
     */
    private LocalDateTime lastLogin;


    /**
     * 0:男，1：女
     */
    private Integer gender;

}
