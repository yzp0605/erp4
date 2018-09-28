package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.Role;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.vo.PermissionVo;
import com.sxt.sys.vo.RoleVo;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;

	/**
	 * 跳转到roleManager.jsp
	 */
	@RequestMapping("toRoleManager")
	public String toRoleManager() {
		return "system/role/roleManager";
	}
	
	
	/**
	 * 加载角色列表
	 */
	@RequestMapping("loadAllRoles")
	@ResponseBody
	public DataGridView loadAllRoles(RoleVo roleVo) {
		return this.roleService.queryAllRole(roleVo);
	}
	
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("toAddRole")
	public String toAddRole() {
		return "system/role/roleAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("addRole")
	@ResponseBody
	public Map<String,Object> addRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			this.roleService.addRole(roleVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdateRole")
	public String toUpdateRole(RoleVo roleVo,Model model) {
		Role role=this.roleService.queryRoleById(roleVo.getId());
		model.addAttribute("role", role);
		return "system/role/roleUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Map<String,Object> updateRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.roleService.updateRole(roleVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 删除
	 */
	@RequestMapping("deleteRole")
	@ResponseBody
	public Map<String,Object> deleteRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.roleService.deleteRole(roleVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteRole")
	@ResponseBody
	public Map<String,Object> batchDeleteRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			Integer[] ids=roleVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.roleService.deleteRole(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到分配权限的页面
	 */
	@RequestMapping("toSelectRolePermission")
	public String toSelectRolePermission(RoleVo roleVo,Model model) {
//		model.addAttribute("id", roleVo.getId());
		return "system/role/selectPermission";
	}
	
	/**
	 * 根据角色ID加载权限分配的复选树的json
	 */
	@RequestMapping("loadRolePermission")
	@ResponseBody
	public List<TreeNode> loadRolePermission(RoleVo roleVo){
		PermissionVo permissionVo=new PermissionVo();
		permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);//可用的
		Integer roleid=roleVo.getId();
		//1，根据角色ID查询角色已有的权限
		List<Permission> curRolePermissions=permissionService.queryPermissionByRoleIdForList(permissionVo,roleid);
		//2，查询出所有可用的权限和菜单
		List<Permission> allPermissions=permissionService.queryPermissionForList(permissionVo);
		List<TreeNode> treeNodes=new ArrayList<>();
		for (Permission p1 : allPermissions) {
			Boolean checked=false;
			for (Permission p2 : curRolePermissions) {
				if(p1.getId()==p2.getId()) {
					checked=true;
					break;
				}
			}
			Boolean open=p1.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			Boolean isParent=false;//处理选择权限时  CURD的树不出来的问题
			if(p1.getType().equals(SYS_Constast.PERMISSION_TYPE_MENU)) {
				isParent=true;
			}
			treeNodes.add(new TreeNode(p1.getId(), p1.getPid(), p1.getName(), open, isParent, checked));
		}
		return treeNodes;
	}
	
	
	/**
	 * 保存角色和权限菜单之间的关系
	 */
	@RequestMapping("saveRolePermission")
	@ResponseBody
	public Map<String,Object> saveRolePermission(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="分配成功";
		try {
			this.roleService.saveRolePermission(roleVo);
		} catch (Exception e) {
			msg="分配失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
}
