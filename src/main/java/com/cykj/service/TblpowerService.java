package com.cykj.service;


import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrolepower;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TblpowerService {
    List<Tblpower> findPowerList(HttpServletRequest req);

    int delPowerByRoleId(Integer roleid);

    List<Integer> findStaffPowerId(Integer roleid);

    List<Tblpower> findStaffPower(List<Integer> powerIdList);

    List<Tblpower> findAllPower();

    int addPower(Tblrolepower tblrolepower);

    Map<String, Object> updPower(Tblpower tblpower);
}
