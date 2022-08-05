package com.cykj.service.impl;


import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import com.cykj.bean.UserBean;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.mapper.TblroleMapper;
import com.cykj.mapper.TbluserMapper;
import com.cykj.service.TblroleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblroleServiceImpl implements TblroleService {
    @Autowired
    private TblroleMapper tblroleMapper;

    @Autowired
    private TbluserMapper tbluserMapper;

    @Autowired
    private TblpowerMapper tblpowerMapper;

    @Override
    public Map<String, Object> selRoleList(int pageCurr, int pageSize) {
        PageHelper.startPage(pageCurr, pageSize);
        List<Tblrole> selRoleList = tblroleMapper.selRoleList();
        PageInfo<Tblrole> pageInfo = new PageInfo<>(selRoleList);
        List<Tblrole> roleList = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("roleList", roleList);
        map.put("pageCount", pageInfo.getPages());
        return map;
    }

    public int userRole(int roleId) {
        List<UserBean> userRole = tbluserMapper.findUserRole(roleId);
        if (userRole.size() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int delRole(int roleId) {
        int flagRole = userRole(roleId);
        if (flagRole == 0) {
            //删除角色
            int delRole = tblroleMapper.delRole(roleId);
            //删除权限
            int delPower = tblpowerMapper.delPowerByRoleId(roleId);
            if (delPower > 0 && delRole > 0) {
                return 1;
            } else {
                return 2;
            }
        }
        return 3;
    }

    @Override
    public int addRole(String name, String description) {
        return tblroleMapper.addRole(name, description);
    }

    @Override
    public int findRoleId(String name) {
        List<Tblrole> findRoleId = tblroleMapper.findRoleId(name);
        if (findRoleId.size() > 0) {
            return findRoleId.get(0).getRoleId();
        }
        return 0;
    }

    @Override
    public Map<String, Object> showPower(int roleId) {
        List<Integer> powerIdList = tblpowerMapper.findStaffPowerId(roleId);//遍历该账号角色的所有权限id
        List<Tblpower> tblpowerList = tblpowerMapper.findStaffPower(powerIdList);
        Map<String, Object> map = new HashMap<>();
        map.put("powerList", tblpowerList);
        return map;
    }

    @Override
    public int updRole(int roleId, String roleName, String description) {
        return tblroleMapper.updRole(roleId, roleName, description);
    }

    @Override
    public Map<String, Object> showAllPower() {
        List<Tblpower> powerAll = tblpowerMapper.findAllPower();
        Map<String, Object> map = new HashMap<>();
        map.put("powerAll", powerAll);
        return map;
    }
}
