package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据登陆名查询用户
     * @param loginname
     * @return
     */
	User queryUserByLoginName(String loginname);
	
	
	/**
	 * 用户查询
	 */
	List<User> queryAllUser(User user);

	/*
	 * 根据部门编号查询用户信息
	 */
	List<User> queryUserByDeptId(Integer deptid);

	List<User> queryAllUser2();
	//根据用户ID删除用户和角色的关系
	void deleteUserRoleByUserId(Integer uid);
	//保存用户和角色的关系
	void saveUserRole(Integer uid, Integer rid);
}