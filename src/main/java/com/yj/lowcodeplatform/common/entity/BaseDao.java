package com.yj.lowcodeplatform.common.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 13:26
 */
@NoRepositoryBean
public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    /**
     * 重载的查询语句
     *
     * @param id
     * @return 查询结果
     * @Transactional(readOnly = true)只读性事务能够优化数据库的执行
     */
    @Override
    @Query("select t from #{#entityName} t  where t.id = ?1 and t.deleted = 0")
    @Transactional(readOnly = true)
    Optional<T> findById(Long id);

    @Query("update  #{#entityName} t set t.deleted = 1 where t.id = ?1")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public void logicDeleteById(Long id);
}
