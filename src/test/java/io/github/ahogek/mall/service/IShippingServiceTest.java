package io.github.ahogek.mall.service;

import com.github.pagehelper.PageInfo;
import io.github.ahogek.mall.MallApplicationTests;
import io.github.ahogek.mall.enums.ResponseEnum;
import io.github.ahogek.mall.form.ShippingForm;
import io.github.ahogek.mall.pojo.Shipping;
import io.github.ahogek.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private ShippingForm form;

    private Integer shippingId;

    @BeforeEach
    public void before() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("AhogeK");
        form.setReceiverAddress("GongShu");
        form.setReceiverCity("Hangzhou");
        form.setReceiverMobile("18812345678");
        form.setReceiverPhone("010123456");
        form.setReceiverProvince("Hangzhou");
        form.setReceiverDistrict("GongShu");
        form.setReceiverZip("316000");
        this.form = form;
        add();
    }

    void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}", responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @AfterEach
    void delete() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}", responseVo);
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void update() {
        form.setReceiverCity("北京");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.update(uid, shippingId, form);
        log.info("result={}", responseVo);
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void list() {
        ResponseVo<PageInfo<Shipping>> responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}", responseVo);
        Assertions.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}