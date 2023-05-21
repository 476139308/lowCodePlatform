package com.yj.lowcodeplatform.system.controller;

import com.yj.lowcodeplatform.common.entity.Result;
import com.yj.lowcodeplatform.common.utils.JwtUtils;
import com.yj.lowcodeplatform.system.entity.dto.UserDTO;
import com.yj.lowcodeplatform.system.entity.vo.UserQueryVO;
import com.yj.lowcodeplatform.system.entity.vo.UserUpdateVO;
import com.yj.lowcodeplatform.system.entity.vo.UserVO;
import com.yj.lowcodeplatform.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote
 * @since 2023/5/21 16:01
 */
@Validated
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(@Valid UserQueryVO vO) {
        return userService.query(vO);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        UserVO userVo = userService.login(userDTO);
        userDTO.setId(4L);
        String jwtToken = JwtUtils.getJwtToken(userDTO.getId().toString(), userDTO.getUsername());
        return Result.success(jwtToken);
    }
}
