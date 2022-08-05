package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserBean {
    private int userId;
    private String uAcc;
    private String uPwd;
    private String uName;
    private int roleId;
    private String phone;
    private String idNumber;
    private String address;
    private String headImg;
    private int state;


}
