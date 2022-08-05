package com.cykj.web;


import com.cykj.bean.Tblpower;
import com.cykj.service.TblpowerService;
import com.cykj.service.TblroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private TblroleService tblroleService;

    @Autowired
    private TblpowerService tblpowerService;

    @RequestMapping("/goRoleList")
    public String goRoleList(Model model) {
//        List<Tblrole> roleList = tblroleService.selRoleList();
        return "roleMagt"; //页面文件名称
    }

    @RequestMapping("/goPowerMagt")
    public String goPowerMagt(Model model) {
        return "powerMagt"; //页面文件名称
    }

    @RequestMapping("/goRoleWindow")
    public String goRoleWindow(Model model) {
        return "roleWindow"; //页面文件名称
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String, Object> roleList(Model model, int pageCurr, int pageSize) {
        Map<String, Object> map = tblroleService.selRoleList(pageCurr, pageSize);
        return map;
    }

    @RequestMapping("/delRole")
    @ResponseBody
    public int delRole(Model model, int roleId) {
        int flag = tblroleService.delRole(roleId);
        return flag;
    }

    @RequestMapping("/showRole")
    @ResponseBody
    public Map<String, Object> showRole(Model model, int roleId) {
        Map<String, Object> map = tblroleService.showPower(roleId);
        return map;
    }

    @RequestMapping("/updRole")
    @ResponseBody
    public int updRole(Model model, int roleId, String name, String description) {
        int flag = tblroleService.updRole(roleId, name, description);
        return flag;
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public int updRole(Model model, String name, String description) {
        int flag = tblroleService.addRole(name, description);
        return flag;
    }

    @RequestMapping("/showPower")
    @ResponseBody
    public Map<String, Object> showPower(Model model, int roleId) {
        Map<String, Object> findRoleList = tblroleService.showPower(roleId);
        return findRoleList;
    }

    @RequestMapping("/showAllPower")
    @ResponseBody
    public Map<String, Object> showAllPower(Model model) {
        Map<String, Object> map = tblroleService.showAllPower();
        return map;
    }


    @RequestMapping(value = "/updPower")
    @ResponseBody
    public Map<String, Object> updPower(@RequestBody Tblpower tblpower) {
        Map<String, Object> map = tblpowerService.updPower(tblpower);
        return map;
    }
}
