package io.github.ahogek.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * User Login Form
 * </p>
 *
 * @author AhogeK
 * @since 2020-06-16 20:23
 */
@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}

