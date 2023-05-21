package com.yj.lowcodeplatform.business.test.dao;

import com.yj.lowcodeplatform.system.dao.UserDao;
import com.yj.lowcodeplatform.system.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/5/21 12:51
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    @Resource
    private UserDao userDao;

    @Test
    void generate() {
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

        User save = userDao.save(user);
        System.out.println("save = " + save);

    }


    @Test
    void get() {
        Optional<User> byId = userDao.findById(2L);
        if (byId.isPresent()) {
            User user = byId.get();
            System.out.println("user = " + user);
        }
    }

}