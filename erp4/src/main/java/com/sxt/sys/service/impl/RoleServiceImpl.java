package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	

	@Override
	public DataGridView queryAllRole(RoleVo roleVo) {
		Page<Object> page=PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data=this.roleMapper.queryAllRole(roleVo);
		return new DataGridView(page.getTotal(), data);
	}

	/**
	 * 添加部门
	 */
	@Override
	public void addRole(RoleVo roleVo) {
		this.roleMapper.insert(roleVo);
	}

	@Override
	public Role queryRoleById(Integer id) {
		
		return this.roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		this.roleMapper.updateByPrimaryKey(roleVo);
	}

	@Override
	public void deleteRole(Integer id) {
		this.roleMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 保存角色和权限菜单之间的关系
	 */
	@Override
	public void saveRolePermission(RoleVo roleVo) {
		Integer roleid=roleVo.getId();
		Integer[] ids=roleVo.getIds();
		//先删除sys_role_permission 里面roleid=roleid的的数据
		this.roleMapper.deleteRolePermissionByRoleId(roleid);
		//再做插入
		if(ids!=null&&ids.length>0) {
			for (Integer pid : ids) {
				this.roleMapper.saveRolePermissin(roleid,pid);
			}
		}
	}

	@Override
	public List<Role> queryRoleByUserId(Integer id) {
		return this.roleMapper.queryRoleByUserId(id);
	}
}
