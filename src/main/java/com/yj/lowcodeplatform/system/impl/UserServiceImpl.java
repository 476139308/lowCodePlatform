package com.yj.lowcodeplatform.system.impl;

import com.yj.lowcodeplatform.system.UserService;
import com.yj.lowcodeplatform.system.dao.UserDao;
import com.yj.lowcodeplatform.system.entity.User;
import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public Long save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    @Override
    public void delete(Long id) {
        userRepository.logicDeleteById(id);
    }

    @Override
    public void update(Long id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    @Override
    public UserDTO getById(Long id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
