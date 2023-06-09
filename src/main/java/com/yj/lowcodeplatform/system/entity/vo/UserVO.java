package com.yj.lowcodeplatform.system.entity.vo;

import com.yj.lowcodeplatform.common.entity.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author YuJin
 * @since 2023/5/21 16:01
 * @version 1.0.0
 * @apiNote
 */

@Data
public class UserVO  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @NotNull(message = "id can not null")
    private Long id;


    /**
     * 用户名
     */
    @NotNull(message = "username can not null")
    private String username;


    /**
     * 密码
     */
    @NotNull(message = "password can not null")
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
    @NotNull(message = "status can not null")
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
