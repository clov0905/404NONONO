package com.cykj.service;


import com.cykj.bean.UserBean;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    int login(String uAcc, String uPwd, Model model, HttpSession session);

    int frontRegist(UserBean userBean);

    Map<String, Object> findAllUser();

    Map<String, Object> likeUser(int pageCurr, int pageSize, String uAcc, String uName);

    int delUser(int userId);

    int addUser(String uAcc, String uPwd, String uName, String idNumber, String phone, String address);

    int updUser(String uPwd, String uName, String phone, String address, int userId);

    List<UserBean> byIdFindUser(int userId);
}
