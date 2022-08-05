package com.cykj.service.impl;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrolepower;
import com.cykj.bean.UserBean;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.service.TblpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblpowerServiceImpl implements TblpowerService {
    @Autowired
    private TblpowerMapper tblpowerMapper;

    @Override
    public List<Tblpower> findPowerList(HttpServletRequest req) {
        UserBean userBean = (UserBean) req.getSession().getAttribute("user");
        List<Tblpower> findPowerList = tblpowerMapper.findPowerList(userBean.getRoleId());
        if (findPowerList.size() > 0) {
            return findPowerList;
        }
        return null;
    }

    @Override
    public int delPowerByRoleId(Integer roleid) {
        int flag = tblpowerMapper.delPowerByRoleId(roleid);
        return flag;
    }

    @Override
    public List<Integer> findStaffPowerId(Integer roleid) {
        List<Integer> findStaffPowerId = tblpowerMapper.findStaffPowerId(roleid);
        return findStaffPowerId;
    }

    @Override
    public List<Tblpower> findStaffPower(List<Integer> powerIdList) {
        List<Tblpower> findStaffPower = tblpowerMapper.findStaffPower(powerIdList);
        return findStaffPower;
    }

    @Override
    public List<Tblpower> findAllPower() {
        List<Tblpower> findAllPower = tblpowerMapper.findAllPower();
        return findAllPower;
    }

    @Override
    public int addPower(Tblrolepower tblrolepower) {
        int flag = tblpowerMapper.addPower(tblrolepower);
        if (flag > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public Map<String, Object> updPower(Tblpower tblpower) {
        Map<String, Object> map = new HashMap<>();
        int delPower = tblpowerMapper.delPowerByRoleId(tblpower.getRoleId());//删除所有权限
        int addNum = 0;
        //插入保存的所有权限
        System.out.println();
        for (int i = 0; i < tblpower.getPowerList().size(); i++) {
            Tblrolepower tblrolepower = new Tblrolepower();
            tblrolepower.setRoleId(tblpower.getRoleId());
            tblrolepower.setPowerId(tblpower.getPowerList().get(i));
            addNum += tblpowerMapper.addPower(tblrolepower);
        }
        if (delPower > 0 && addNum > 0) {
            map.put("flag", 1);
        } else {
            map.put("flag", 0);
        }
        return map;
    }
}
