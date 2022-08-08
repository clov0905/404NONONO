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
    //商品的修改
    @Override
    public boolean updGoods(Tblgoods goods) {
        return tblgoodsMapper.updGoods(goods);
    }

}
