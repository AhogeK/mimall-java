package io.github.ahogek.mall.service;

import com.github.pagehelper.PageInfo;
import io.github.ahogek.mall.form.ShippingForm;
import io.github.ahogek.mall.pojo.Shipping;
import io.github.ahogek.mall.vo.ResponseVo;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author AhogeK
 * @since 2020-07-03 17:20
 */
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo<Map<String, Integer>> delete(Integer uid, Integer shippingId);

    ResponseVo<Map<String, Integer>> update(Integer uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo<Shipping>> list(Integer uid, Integer pageNum, Integer pageSize);
}
