package com.yj.lowcodeplatform.system.dao;

import com.yj.lowcodeplatform.common.entity.BaseDao;
import com.yj.lowcodeplatform.system.entity.User;

/**
 * @author YuJin
 * @since 2023/5/21 16:01
 * @version 1.0.0
 * @apiNote
 */
public interface UserDao extends BaseDao<User> {

    User findByUsername(String username);

}