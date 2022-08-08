package com.cykj.service.impl;

import com.cykj.bean.Tblgoods;
import com.cykj.mapper.TblgoodsMapper;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblgoodsServiceImpl implements TblgoodsService {

    @Autowired
    private TblgoodsMapper tblgoodsMapper;

    //查询全部商品
    @Override
    public Map<String, Object> findGoodsList() {
        List<Tblgoods> tblgoodsList = tblgoodsMapper.findGoodsList();
        Map<String, Object> map = new HashMap<>();
        map.put("goodsList", tblgoodsList);
        return map;
    }

    @Override
    public int delGoods(int index) {
        int flag = tblgoodsMapper.delGoods(index);
        return flag;
    }
    //商品的修改
    @Override
    public boolean updGoods(Tblgoods goods) {
        return tblgoodsMapper.updGoods(goods);
    }

    //
    @Override
    public Map<String,Object> findGoodsListByName(String goodsName, int startPage, int singlePageNum) {
        List<Tblgoods> list = tblgoodsMapper.findGoodsListByName(goodsName,startPage,singlePageNum);
        Map<String,Object>map=new HashMap<>();
        map.put("list",list);
        return map;
    }

    @Override
    public int findGoodsListNum(String goodsName) {
        int num=tblgoodsMapper.findGoodsListNum(goodsName);
        return num;
    }

    @Override
    public int insertGoods(Tblgoods tblgoods) {

        return  tblgoodsMapper.insertGoods(tblgoods);
    }
    //商品新增
}
