package com.cykj.service;

import com.cykj.bean.Tblgoods;

import java.util.List;
import java.util.Map;

public interface TblgoodsService {
    //查询全部商品
    Map<String, Object> findGoodsList();
}
