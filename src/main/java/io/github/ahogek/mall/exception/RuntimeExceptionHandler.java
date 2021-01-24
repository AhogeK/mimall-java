package io.github.ahogek.mall.exception;

import io.github.ahogek.mall.enums.ResponseEnum;
import io.github.ahogek.mall.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

import static io.github.ahogek.mall.enums.ResponseEnum.ERROR;
import static io.github.ahogek.mall.enums.ResponseEnum.NEED_LOGIN;

/**
 * <p>
 * Runtime Exception Handler
 * </p>
 *
 * @author AhogeK
 * @since 2020-06-16 22:57
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handle(RuntimeException e) {
        return ResponseVo.error(ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handle() {
        return ResponseVo.error(NEED_LOGIN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo notValidExceptionHandle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResponseVo.error(ResponseEnum.PARAM_ERROR, Objects.requireNonNull(bindingResult.getFieldError())
                .getField() + " " + Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }
}
