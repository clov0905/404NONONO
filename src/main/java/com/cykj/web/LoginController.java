package com.cykj.web;

import com.alibaba.fastjson.JSONArray;
import com.cykj.bean.UserBean;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/userMange")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginView")
    public String login() {
        return "login"; //页面文件名称
    }

    @RequestMapping("/doLogin")
    public String doLogin(String uAcc, String uPwd, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        int flag = userService.login(uAcc, uPwd, model, session);
        if (flag > 0) {
            return "redirect:/admin/goIndex";
        }
        return "login";
    }

    //前后端分离
    @RequestMapping("/doLogin01")
    public @ResponseBody
    String doLogin01(String uAcc, String uPwd, HttpServletRequest req, Model model) {
        System.out.println(uAcc + "-----" + uPwd + "-----------------45");
        HttpSession session = req.getSession();
        int flag = userService.login(uAcc, uPwd, model, session);
        if (flag > 0) {
//            JSONArray.toJSONString(flag);
            return JSONArray.toJSONString(flag);
        }
        return JSONArray.toJSONString(flag);
    }


    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login"; //页面文件名称
    }

    @RequestMapping("/goRegister")
    public String goRegister() {
        return "register"; //页面文件名称
    }

    @RequestMapping("/doRegister")
    public String doRegister(UserBean userBean, MultipartFile fileName, HttpServletRequest request, Model model) {
        //拿到文件名
        String imgName = fileName.getOriginalFilename();
        try {
//            fileName.transferTo(new File("D:\\cykjJX2201\\课堂笔记\\第四阶段\\图片\\"+imgName));//保存File文件
            //访问的url
            String url5 = request.getServletContext().getRealPath("/upload");
            File file = new File(url5);
            if (!file.exists()) {
                file.mkdir();
            }
            fileName.transferTo(new File(url5 + "/" + imgName));//保存File文件

            userBean.setHeadImg("upload/" + imgName);

            int flag = userService.frontRegist(userBean);
            if (flag > 0) {
                return "login";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("checkacc")
    public @ResponseBody
    String checkAccount(@RequestBody String uAcc) {
        System.out.println(uAcc);
        return "";
    }

    @RequestMapping("/gogogo")
    public String llll(){
        return "aaa";
    }

}
