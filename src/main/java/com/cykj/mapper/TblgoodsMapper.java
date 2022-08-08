package com.cykj.mapper;

import com.cykj.bean.Tblgoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TblgoodsMapper {
    //查询全部商品
    List<Tblgoods> findGoodsList();
}
