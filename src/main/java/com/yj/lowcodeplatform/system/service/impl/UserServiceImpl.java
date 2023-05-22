package com.yj.lowcodeplatform.system.service.impl;

import com.yj.lowcodeplatform.common.service.impl.BaseServiceImpl;
import com.yj.lowcodeplatform.system.dao.UserDao;
import com.yj.lowcodeplatform.system.entity.User;
import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import com.yj.lowcodeplatform.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote
 * @since 2023/5/21 16:01
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userRepository;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Long save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean.setPassword(bCryptPasswordEncoder.encode(bean.getPassword()));
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

    @Override
    public UserVO login(UserDTO userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
//        return authenticate.isAuthenticated()?;
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
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
