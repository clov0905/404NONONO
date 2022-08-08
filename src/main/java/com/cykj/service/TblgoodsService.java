package com.cykj.service;

import com.cykj.bean.Tblgoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TblgoodsService {
    //查询全部商品
    Map<String, Object> findGoodsList();
    //删除商品
    int delGoods(int index);
    //修改商品
    boolean updGoods( Tblgoods goods);
    //商品名模糊查询商品列表
    Map<String,Object>findGoodsListByName(String goodsName,int startPage,int singlePageNum);
    //商品名查询商品列表总量
    int findGoodsListNum(String goodsName);
    //新增商品
    int insertGoods(Tblgoods tblgoods);
}
