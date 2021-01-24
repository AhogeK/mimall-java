package io.github.ahogek.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * User Form
 * </p>
 *
 * @author AhogeK
 * @since 2020-06-16 20:23
 */
@Data
public class UserRegisterForm {

    // NotBlank会判断空格 空格字符串也为空
    @NotBlank
    // @NotEmpty 用于集合
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
