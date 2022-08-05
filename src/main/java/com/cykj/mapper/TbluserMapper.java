package com.cykj.mapper;


import com.cykj.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@Repository
public interface TbluserMapper {
    UserBean login(@Param("uAcc") String uAcc, @Param("uPwd") String uPwd);

    int frontRegist(UserBean tbluser);

    String findUser(@Param("uAcc") String uAcc);

    List<UserBean> findAllUser();

    List<UserBean> likeUser(@Param("uAcc") String uAcc, @Param("uName") String uName);

    int delUser(@Param("userId") int userId);

    int addUser(@Param("uAcc") String uAcc,
                @Param("uPwd") String uPwd,
                @Param("uName") String uName,
                @Param("idNumber") String idNumber,
                @Param("phone") String phone,
                @Param("address") String address);

    int updUser(@Param("uPwd") String uPwd,
                @Param("uName") String uName,
                @Param("phone") String phone,
                @Param("address") String address,
                @Param("userId") int userId);

    List<UserBean> byIdFindUser(@Param("userId") int userId);

    List<UserBean> findUserRole(@Param("roleId") int roleId);

    int countAllUser();
}
