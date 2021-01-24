package io.github.ahogek.mall.service;

import com.github.pagehelper.PageInfo;
import io.github.ahogek.mall.vo.OrderVo;
import io.github.ahogek.mall.vo.ResponseVo;

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo<String> cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}
