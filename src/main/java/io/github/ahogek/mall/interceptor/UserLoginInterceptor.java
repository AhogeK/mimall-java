package io.github.ahogek.mall.interceptor;

import io.github.ahogek.mall.consts.MallConst;
import io.github.ahogek.mall.exception.UserLoginException;
import io.github.ahogek.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * true 表示继续流程，false表示中断
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            log.info("user=null");
            throw new UserLoginException();
            // return false;
            // return ResponseVo.error(NEED_LOGIN);
        }
        return true;
    }
}
