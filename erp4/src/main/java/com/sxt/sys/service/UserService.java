package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.UserVo;

/**
 * 用户服务接口
 * @author LJH
 *
 */
public interface UserService {

	//根据登陆名查询用户信息
	public User queryUserByLoginName(String loginname);
	
	//查询用户
	public DataGridView queryAllUser(UserVo userVo);

	//根据部门编号查询用户信息
	public List<User> queryUserByDeptId(Integer deptid);
	
	public int addUser(UserVo userVo);

	 User querUserById(Integer id);

	public int updateUser(UserVo userVo);

	public int deleteUser(UserVo userVo);

	public List<User> queryAllUserForList();

	//重置密码
	public int resetUserPwd(UserVo userVo);

	//加载用户的角色和并选中用户已拥有的角色
	public DataGridView queryUserRole(UserVo userVo);

	//保存用户和角色之间的关系
	public void saveUserRole(UserVo userVo);

	
}
