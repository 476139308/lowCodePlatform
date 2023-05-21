package com.yj.lowcodeplatform.common.service.impl;

import com.yj.lowcodeplatform.common.entity.BaseDao;
import com.yj.lowcodeplatform.common.entity.BaseEntity;
import com.yj.lowcodeplatform.common.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 15:45
 */
@Service
public class BaseServiceImpl<D extends BaseDao<T>, T extends BaseEntity> implements BaseService<T> {

    @Resource
    private D dao;

    @Override
    public T findById(Long id) {
        return dao.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    @Override
    public void save(T t) {
        dao.save(t);
    }

    @Override
    public void updateById(T t) {
        dao.save(t);
    }

    @Override
    public void deleteById(Long id) {
        dao.logicDeleteById(id);
    }
}
