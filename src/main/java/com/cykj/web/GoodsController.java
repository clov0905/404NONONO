package com.cykj.web;

import com.alibaba.fastjson.JSONArray;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
