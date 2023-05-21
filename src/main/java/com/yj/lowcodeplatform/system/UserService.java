package com.yj.lowcodeplatform.system;

import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import org.springframework.data.domain.Page;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 14:47
 */
public interface UserService {
    Long save(UserVO vO);

    void delete(Long id);


    void update(Long id, UserUpdateVO vO);


    UserDTO getById(Long id);

    Page<UserDTO> query(UserQueryVO vO);


}
