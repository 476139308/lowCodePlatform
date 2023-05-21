package com.yj.lowcodeplatform.common.service;

import com.yj.lowcodeplatform.common.entity.BaseEntity;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 15:43
 */
public interface BaseService<T extends BaseEntity> {
    T findById(Long id);

    void save(T t);

    void updateById(T t);

    void deleteById(Long id);

}
