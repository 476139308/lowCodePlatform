package com.yj.lowcodeplatform.system.service;

import com.yj.lowcodeplatform.system.entity.User;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 16:54
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void save() {
        User user = new User();
        user.setUsername("yujin");
        user.setPassword("123214");
        user.setIdCard("340826200001012232");
        user.setEmail("432133454@qq.com");
        user.setPhone("13333333333");
        user.setBirthday(LocalDate.now());
        user.setStatus(0);
        user.setLastLogin(LocalDateTime.now());
        user.setDeleted(0);
        user.setGender(0);
        user.setCreateBy("admin");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateBy("admin");
        user.setUpdateTime(LocalDateTime.now());
        user.setRemark("32123");
        user.setDeleted(0);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);

        Long save = userService.save(userVO);
        System.out.println("save = " + save);
    }

    @Test
    void login() {



    }
}