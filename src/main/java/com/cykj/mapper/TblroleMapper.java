package com.cykj.mapper;


import com.cykj.bean.Tblrole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@Repository
public interface TblroleMapper {
    List<Tblrole> selRoleList();

    int delRole(@Param("roleId") int roleId);

    int addRole(@Param("name") String name, @Param("description") String description);

    List<Tblrole> findRoleId(@Param("name") String name);

    List<Tblrole> findRoleList(@Param("roleId") int roleId);

    int updRole(@Param("roleId") int roleId, @Param("roleName") String roleName, @Param("description") String description);
}
