package com.yj.lowcodeplatform.system.controller;

import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import com.yj.lowcodeplatform.system.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userServiceImpl.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userServiceImpl.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userServiceImpl.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(@Valid UserQueryVO vO) {
        return userServiceImpl.query(vO);
    }
}
