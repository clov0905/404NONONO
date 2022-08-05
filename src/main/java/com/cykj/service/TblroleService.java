package com.cykj.service;

import java.util.Map;

public interface TblroleService {
    Map<String, Object> selRoleList(int pageCurr, int pageSize);

    int delRole(int roleId);

    int addRole(String name, String description);

    int findRoleId(String name);

    Map<String, Object> showPower(int roleId);

    int updRole(int roleId, String roleName, String description);

    Map<String, Object> showAllPower();

}
