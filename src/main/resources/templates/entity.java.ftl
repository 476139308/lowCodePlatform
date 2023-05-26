package com.yj.lowcodeplatform.system.entity;

import com.yj.lowcodeplatform.common.entity.BaseEntity;

/**
* @author YuJin
* @version 1.0.0
* @apiNote
* @since 2023/5/21 16:01
*/

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "${tableName}}")
public class ${className} extends BaseEntity implements Serializable{

    private static final long serialVersionUID=1L;

    /**
    * 主键
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    <#list fields as field>
        /**
        * ${field.comment}
        */
        @Column
        private ${field.type.javaType}${field.name};
    </#list>

}
