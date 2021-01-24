package io.github.ahogek.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author AhogeK
 * @since 2020-07-01 19:42
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;
}
