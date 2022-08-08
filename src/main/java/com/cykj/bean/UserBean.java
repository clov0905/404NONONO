package com.cykj.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ApiModel("用户实体类")
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
