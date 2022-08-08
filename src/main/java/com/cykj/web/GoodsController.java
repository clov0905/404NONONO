package com.cykj.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cykj.bean.Tblgoods;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodsMange")
public class GoodsController {
    @Autowired
    private TblgoodsService tblgoodsService;

    //前后端分离
    @RequestMapping(value ="/selGoodsList",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selGoodsList() {
        Map<String, Object> map = tblgoodsService.findGoodsList();
        return JSONArray.toJSONString(map);
    }

    //修改货物数据
    @RequestMapping(value = "/updGoods",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public boolean updGoods(Tblgoods tblgoods){
        return tblgoodsService.updGoods(tblgoods);
    }

    //模糊查询用户列表+分页
    @RequestMapping(value = "/findGoodsListByName",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findGoodsListByName(String goodsName,String startPage,String singlePageNum){
        System.out.println(goodsName+"||"+singlePageNum+"|"+startPage);
        Map<String,Object> map= tblgoodsService.findGoodsListByName(goodsName,Integer.parseInt(startPage),Integer.parseInt(singlePageNum));
        int num=tblgoodsService.findGoodsListNum(goodsName);
        map.put("num",num);
        return JSONArray.toJSONString(map);
    }

    //删除商品
    @RequestMapping("/delGoods")
    @ResponseBody
    public int delGoods(int index){
        int flag = tblgoodsService.delGoods(index);
        return flag;
    }
    //新增商品
    @RequestMapping(value = "/insertGoods",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int insertGoods(Tblgoods tblgoods){
        return tblgoodsService.insertGoods(tblgoods);
    }
}
