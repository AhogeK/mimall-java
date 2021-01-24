package io.github.ahogek.mall.service;

import io.github.ahogek.mall.vo.CategoryVo;
import io.github.ahogek.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
