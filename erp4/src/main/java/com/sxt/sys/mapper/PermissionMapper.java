package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> queryAllPermission(Permission permission);

    //根据角色ID查询权限
	List<Permission> queryPermissionByRoleId(Integer available, Integer roleid);
	//根据用户ID查询菜单或者权限
	List<Permission> queryPermissionByUserId(String type,Integer userid);
    
}