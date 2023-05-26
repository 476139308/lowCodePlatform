package com.yj.lowcodeplatform.system.generator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/26 12:53
 */
@Data
@AllArgsConstructor
public class EntityField {
    private String name;

    private EntityFieldTypeEnum type;
    private String comment;


}
