package io.github.ahogek.mall.service;

import io.github.ahogek.mall.form.CartAddForm;
import io.github.ahogek.mall.form.CartUpdateForm;
import io.github.ahogek.mall.pojo.Cart;
import io.github.ahogek.mall.vo.CartVo;
import io.github.ahogek.mall.vo.ResponseVo;

import java.util.List;

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
