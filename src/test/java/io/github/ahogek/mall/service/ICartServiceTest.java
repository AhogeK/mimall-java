package io.github.ahogek.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.ahogek.mall.MallApplicationTests;
import io.github.ahogek.mall.enums.ResponseEnum;
import io.github.ahogek.mall.form.CartAddForm;
import io.github.ahogek.mall.form.CartUpdateForm;
import io.github.ahogek.mall.vo.CartVo;
import io.github.ahogek.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class ICartServiceTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer productId = 26;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @BeforeEach
    void add() {
        log.info("【新增购物车】");
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void list() {
        log.info("【购物车列表】");
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void update() {
        log.info("【更新购物车】");
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(10);
        ResponseVo<CartVo> responseVo = cartService.update(uid, productId, form);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @AfterEach
    void delete() {
        log.info("【删除购物车】");
        ResponseVo<CartVo> responseVo = cartService.delete(uid, productId);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void selectAll() {
        log.info("【选择全部】");
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void unSelectAll() {
        log.info("【取消全部选择】");
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("list={}", gson.toJson(responseVo));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void sum() {
        log.info("【购物车商品数量总和】");
        ResponseVo<Integer> sum = cartService.sum(uid);
        log.info("list={}", gson.toJson(sum));
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), sum.getStatus());
    }
}