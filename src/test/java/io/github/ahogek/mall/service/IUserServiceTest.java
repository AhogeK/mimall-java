package io.github.ahogek.mall.service;

import io.github.ahogek.mall.MallApplicationTests;
import io.github.ahogek.mall.enums.ResponseEnum;
import io.github.ahogek.mall.enums.RoleEnum;
import io.github.ahogek.mall.pojo.User;
import io.github.ahogek.mall.vo.ResponseVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class IUserServiceTest extends MallApplicationTests {

    public static final String USERNAME = "jack";
    public static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @BeforeEach
    void register() {
        User user = new User(USERNAME, PASSWORD, "jack@gmail.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    void login() {
        // register();
        ResponseVo<User> login = userService.login(USERNAME, PASSWORD);
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), login.getStatus());
    }
}