package io.github.ahogek.mall.controller;

import io.github.ahogek.mall.consts.MallConst;
import io.github.ahogek.mall.form.UserLoginForm;
import io.github.ahogek.mall.form.UserRegisterForm;
import io.github.ahogek.mall.pojo.User;
import io.github.ahogek.mall.service.IUserService;
import io.github.ahogek.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author AhogeK
 * @since 2020-06-16 17:48
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm) {
        // x-www-form-urlencoded 可以直接User user也可以@RequestParam json需要@RequestBody
        log.info("+++++++ username={} +++++++++", userRegisterForm.getUsername());
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        // dto
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpSession session) {
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        // 设置Session
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId={}", session.getId());

        return userResponseVo;
    }

    // session保存再内存里，改进版 token + redis
    @GetMapping("/user")
    public ResponseVo<User> userInfo (HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    // TODO 判断登录状态，拦截器
    /**
     * {@link TomcatServletWebServerFactory} getSessionTimeoutInMinutes() 不能低于1分钟
     */
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session) {
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
