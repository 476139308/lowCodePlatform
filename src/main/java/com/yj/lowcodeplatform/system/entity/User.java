package com.yj.lowcodeplatform.system.entity;

import com.yj.lowcodeplatform.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote
 * @since 2023/5/21 16:01
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "system_user")
public class User extends BaseEntity implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 邮箱地址
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private LocalDate birthday;

    /**
     * 状态 ：默认为1，即可使用，0为禁用
     */
    @Column(name = "status", nullable = false)
    private Integer status = 0;

    /**
     * 上次登录事件
     */
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    /**
     * 0:男，1：女
     */
    @Column(name = "gender")
    private Integer gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
