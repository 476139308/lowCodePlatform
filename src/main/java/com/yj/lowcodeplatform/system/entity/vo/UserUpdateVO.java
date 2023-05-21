package com.yj.lowcodeplatform.system.entity.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author YuJin
 * @since 2023/5/21 16:01
 * @version 1.0.0
 * @apiNote
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateVO extends UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
