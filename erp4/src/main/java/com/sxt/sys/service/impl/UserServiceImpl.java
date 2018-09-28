package com.sxt.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Role;
import com.sxt.sys.domain.User;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.mapper.UserMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.Md5Uitls;
import com.sxt.sys.utils.RandomUtils;
import com.sxt.sys.vo.RoleVo;
import com.sxt.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public User queryUserByLoginName(String loginname) {
		return userMapper.queryUserByLoginName(loginname);
	}

	// 查询用户
	@Override
	public DataGridView queryAllUser(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
		List<User> data = this.userMapper.queryAllUser(userVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public List<User> queryUserByDeptId(Integer deptid) {
		return this.userMapper.queryUserByDeptId(deptid);
	}

	@Override
	public int addUser(UserVo userVo) {
		return this.userMapper.insert(userVo);
	}

	@Override
	public User querUserById(Integer id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return this.userMapper.updateByPrimaryKeySelective(userVo);
	}

	@Override
	public int deleteUser(UserVo userVo) {
		return this.userMapper.deleteByPrimaryKey(userVo.getId());
	}

	@Override
	public List<User> queryAllUserForList() {
		return this.userMapper.queryAllUser2();
	}

	@Override
	public int resetUserPwd(UserVo userVo) {
		User user = this.userMapper.selectByPrimaryKey(userVo.getId());
		user.setSalt(RandomUtils.createRandomUUID());
		user.setPwd(Md5Uitls.encodePwdUseMd5(SYS_Constast.USER_PWD_DEFAULT, user.getSalt(), 2));
		return this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public DataGridView queryUserRole(UserVo userVo) {
		// 1，根据用户ID查询用户已拥有的角色
		List<Role> curRoles = this.roleMapper.queryRoleByUserId(userVo.getId());
		// 2,查询所有可用的角色
		Role role = new Role();
		role.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Role> allRoles = this.roleMapper.queryAllRole(role);
		List<RoleVo> list = new ArrayList<>();
		for (Role r1 : allRoles) {
			Boolean LAY_CHECKED = false;
			for (Role r2 : curRoles) {
				if (r1.getId() == r2.getId()) {
					LAY_CHECKED = true;
					break;
				}
			}
			RoleVo roleVo = new RoleVo();
			BeanUtils.copyProperties(r1, roleVo);
			roleVo.setLAY_CHECKED(LAY_CHECKED);
			list.add(roleVo);
		}
		return new DataGridView(Long.valueOf(list.size()), list);
	}

	@Override
	public void saveUserRole(UserVo userVo) {
		Integer uid = userVo.getId();
		Integer[] rids = userVo.getIds();
		// 1,删除之前的关系
		this.userMapper.deleteUserRoleByUserId(uid);
		// 2，保存新的关系
		if (rids != null && rids.length > 0) {
			for (Integer rid : rids) {
				this.userMapper.saveUserRole(uid, rid);
			}
		}
	}
}
