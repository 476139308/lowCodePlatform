package com.yj.lowcodeplatform.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @ClassName BaseEntity
 * @Author YuJin
 * @Date 2023/5/21 12:28
 * @Version 1.0.0
 */


@Data
@MappedSuperclass
public class BaseEntity {
    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;

    /**
     * 最近被谁更新
     */
    private String updateBy;
    /**
     * 最近一次更新时间
     */
    @LastModifiedDate
    private LocalDateTime updateTime;

    /**
     * 标记信息
     */
    private String remark;

    /**
     * 是否被刪除
     * 0：表示未被删除
     * 1：表示已被删除
     */
    private Integer deleted = 0;

}
