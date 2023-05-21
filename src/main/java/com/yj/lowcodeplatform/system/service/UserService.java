package com.yj.lowcodeplatform.system.service;

import com.yj.lowcodeplatform.common.service.BaseService;
import com.yj.lowcodeplatform.system.entity.User;
import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import org.springframework.data.domain.Page;

/**
 * @author YuJin
 * @since 2023/5/21 16:01
 * @version 1.0.0
 * @apiNote
 */
public interface UserService extends BaseService<User> {
    Long save(UserVO vO);

    void delete(Long id);


    void update(Long id, UserUpdateVO vO);


    UserDTO getById(Long id);

    Page<UserDTO> query(UserQueryVO vO);

    UserVO login(UserDTO userDTO);
}
