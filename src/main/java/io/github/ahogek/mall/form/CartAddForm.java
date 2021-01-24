package io.github.ahogek.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 添加商品
 * </p>
 *
 * @author AhogeK
 * @since 2020-07-01 19:52
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;
}
