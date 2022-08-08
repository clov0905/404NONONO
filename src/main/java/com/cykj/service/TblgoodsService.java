package com.cykj.service;

import com.cykj.bean.Tblgoods;

import java.util.List;
import java.util.Map;

public interface TblgoodsService {
    //查询全部商品
    Map<String, Object> findGoodsList();
    //删除商品
    int delGoods(int index);
    //修改商品
    boolean updGoods( Tblgoods goods);
    //新增商品
    int insertGoods(Tblgoods tblgoods);
}
