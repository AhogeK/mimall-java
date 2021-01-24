package io.github.ahogek.mall.service;

import io.github.ahogek.mall.pojo.User;
import io.github.ahogek.mall.vo.ResponseVo;

/**
 * <p>
 * User Service
 * </p>
 *
 * @author AhogeK
 * @since 2020-06-16 16:32
 */
public interface IUserService {

    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登录
     */
    ResponseVo<User> login(String username, String password);
}
