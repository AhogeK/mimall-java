package io.github.ahogek.mall.service;

import com.github.pagehelper.PageInfo;
import io.github.ahogek.mall.vo.ProductDetailVo;
import io.github.ahogek.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
