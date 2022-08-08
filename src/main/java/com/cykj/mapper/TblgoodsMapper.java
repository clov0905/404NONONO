package com.cykj.mapper;

import com.cykj.bean.Tblgoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TblgoodsMapper {
    //查询全部商品
    List<Tblgoods> findGoodsList();
    //删除商品
    int delGoods(int index);
    //修改商品
    boolean updGoods(Tblgoods tblgoods);
    //新增商品
    int insertGoods(Tblgoods tblgoods);
}
