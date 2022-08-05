package com.cykj.service.impl;


import com.cykj.bean.UserBean;
import com.cykj.mapper.TbluserMapper;
import com.cykj.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbluserMapper tbluserMapper;

    @Override
    public int login(String uAcc, String uPwd, Model model, HttpSession session) {
        UserBean userBean = tbluserMapper.login(uAcc, uPwd);
        if (userBean != null) {
            session.setAttribute("user", userBean);
            model.addAttribute("un", uAcc);
            return 1;
        }
        return 0;
    }

    @Override
    public int frontRegist(UserBean userBean) {
        int flag = tbluserMapper.frontRegist(userBean);
        return flag;
    }

    @Override
    public Map<String, Object> findAllUser() {
        List<UserBean> allUser = tbluserMapper.findAllUser();
        int countAllUser = tbluserMapper.countAllUser();
        Map<String, Object> map = new HashMap<>();
        map.put("userList", allUser);
        map.put("pageCount", countAllUser);
        return map;
    }

    @Override
    public Map<String, Object> likeUser(int pageCurr, int pageSize, String uAcc, String uName) {
        PageHelper.startPage(pageCurr, pageSize);
        List<UserBean> users = tbluserMapper.likeUser(uAcc, uName);
        PageInfo<UserBean> pageInfo = new PageInfo<>(users);
        List<UserBean> userList = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("userList", userList);
        map.put("pageCount", pageInfo.getPages());
        return map;
    }

    @Override
    public int delUser(int userId) {
        int flag = tbluserMapper.delUser(userId);
        if (flag > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int addUser(String uAcc, String uPwd, String uName, String idNumber, String phone, String address) {
        int flag = tbluserMapper.addUser(uAcc, uPwd, uName, idNumber, phone, address);
        if (flag > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updUser(String uPwd, String uName, String phone, String address, int userId) {
        int flag = tbluserMapper.updUser(uPwd, uName, phone, address, userId);
        if (flag > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<UserBean> byIdFindUser(int userId) {
        List<UserBean> userBeanList = tbluserMapper.byIdFindUser(userId);
        return userBeanList;
    }

}
