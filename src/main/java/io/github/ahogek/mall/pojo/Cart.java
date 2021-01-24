package io.github.ahogek.mall.pojo;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author AhogeK
 * @since 2020-07-02 11:11
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
