package com.cykj.web;

import com.alibaba.fastjson.JSONArray;
import com.cykj.bean.Tblpower;
import com.cykj.bean.UserBean;
import com.cykj.service.TblpowerService;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    //修改测试--------谭永波
    @Autowired
    private UserService userService;

    @Autowired
    private TblpowerService tblpowerService;

    //前后端分离
    @RequestMapping("/selUser01")
    @ResponseBody
    public String selUser01() {
        Map<String, Object> map = userService.findAllUser();
        return JSONArray.toJSONString(map);
    }

    @RequestMapping("/userList")
    public String userList(Model model) {
        Map<String, Object> map = userService.likeUser(1, 4, "", "");
        model.addAttribute("userList", map.get("userList"));
        return "userList"; //页面文件名称
    }

    @RequestMapping("/selUser")
    @ResponseBody
    public Map<String, Object> selUser(Model model, String uAcc, String uName, int pageCurr, int pageSize) {
        Map<String, Object> map = userService.likeUser(pageCurr, pageSize, uAcc, uName);
        return map;
    }


    @RequestMapping("/delUser")
    @ResponseBody
    public int delUser(Model model, int userId) {
        int flag = userService.delUser(userId);
        return flag;
    }

    @RequestMapping("/updShowUser")
    @ResponseBody
    public List<UserBean> updShowUser(int userId) {
        List<UserBean> userList = userService.byIdFindUser(userId);
        return userList;
    }

    @RequestMapping("/updUser")
    @ResponseBody
    public int updUser(Model model, UserBean userBean, int updId) {
        int flag = userService.updUser(userBean.getUPwd(), userBean.getUName(), userBean.getPhone(), userBean.getAddress(), updId);
        return flag;
    }

    @RequestMapping("/updUser01")
    @ResponseBody
    public int updUser01(Model model, UserBean userBean, String updId) {
        System.out.println(updId + "---------------76");
        int userId = Integer.parseInt(updId);
        int flag = userService.updUser(userBean.getUPwd(), userBean.getUName(), userBean.getPhone(), userBean.getAddress(), userId);
        return flag;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(Model model, UserBean userBean) {
        int flag = userService.addUser(userBean.getUAcc(), userBean.getUPwd(), userBean.getUName(), userBean.getIdNumber(), userBean.getPhone(), userBean.getAddress());
        return flag;
    }

    @RequestMapping("/powerList")
    @ResponseBody
    public List<Tblpower> powerList(Model model, HttpServletRequest req) {
        List<Tblpower> powerList = tblpowerService.findPowerList(req);
        return powerList;
    }

    @RequestMapping("/goIndex")
    public String goIndex() {
        return "index"; //页面文件名称
    }

}
