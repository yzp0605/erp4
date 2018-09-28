package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //查询
    List<Role> queryAllRole(Role role);
    //根据角色ID删除sys_role_permission的数据
	void deleteRolePermissionByRoleId(Integer roleid);
	//保存角色和菜单之间的关系
	void saveRolePermissin(Integer roleid, Integer pid);
	//根据用户ID查询角色
	List<Role> queryRoleByUserId(Integer id);
}