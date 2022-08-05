package com.cykj.mapper;


import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrolepower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@Repository
public interface TblpowerMapper {
    List<Tblpower> findPowerList(@Param("roleid") Integer roleid);

    int delPowerByRoleId(@Param("roleid") Integer roleid);

    List<Integer> findStaffPowerId(@Param("roleid") Integer roleid);

    List<Tblpower> findStaffPower(@Param("powerIdList") List<Integer> powerIdList);

    List<Tblpower> findAllPower();

    int addPower(Tblrolepower tblrolepower);
}
