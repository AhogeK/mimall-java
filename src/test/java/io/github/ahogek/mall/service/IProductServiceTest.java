package io.github.ahogek.mall.service;

import io.github.ahogek.mall.MallApplicationTests;
import io.github.ahogek.mall.enums.ResponseEnum;
import io.github.ahogek.mall.vo.ProductDetailVo;
import io.github.ahogek.mall.vo.ResponseVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class IProductServiceTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    void list() {
        productService.list(null, 1, 1);
    }

    @Test
    void detail() {
        ResponseVo<ProductDetailVo> detail = productService.detail(26);
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), detail.getStatus());
    }
}