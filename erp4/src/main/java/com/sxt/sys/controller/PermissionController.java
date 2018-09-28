package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	/**
	 * 跳转到permissionManager.jsp
	 */
	@RequestMapping("toPermissionManager")
	public String toPermissionManager() {
		return "system/permission/permissionManager";
	}

	/**
	 * 的permissionManager.jsp里面加载permissionLeft.jsp
	 */
	@RequestMapping("toPermissionLeft")
	public String toPermissionLeft() {
		return "system/permission/permissionLeft";
	}

	/**
	 * 的permissionManager.jsp里面加载permissionRigth.jsp
	 */
	@RequestMapping("toPermissionRight")
	public String toPermissionRight() {
		return "system/permission/permissionRight";
	}
	
	
	/**
	 * 加载权限数据
	 */
	@RequestMapping("loadAllPermission")
	@ResponseBody
	public DataGridView loadAllPermission(PermissionVo permissionVo) {
		permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);
		return this.permissionService.queryAllPermission(permissionVo);
	}
	
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("toAddPermission")
	public String toAddPermission() {
		return "system/permission/permissionAdd";
	}
	/**
	 * 添加
	 */
	@RequestMapping("addPermission")
	@ResponseBody
	public Map<String,Object> addPermission(PermissionVo permissionVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);//添加的权限
			int num=this.permissionService.addPermission(permissionVo);
			if(num>0) {
				msg="添加成功";
			}else {
				msg="添加失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="添加失败";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdatePermission")
	public String toUpdatePermission(PermissionVo permissionVo,Model model) {
		Permission permission=this.permissionService.querPermissionById(permissionVo.getId());
		model.addAttribute("permission", permission);
		return "system/permission/permissionUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("updatePermission")
	@ResponseBody
	public Map<String,Object> updatePermission(PermissionVo permissionVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.permissionService.updatePermission(permissionVo);
			if(num>0) {
				msg="修改成功";
			}else {
				msg="修改失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="修改失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("deletePermission")
	@ResponseBody
	public Map<String,Object> deletePermission(PermissionVo permissionVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.permissionService.deletePermission(permissionVo);
			if(num>0) {
				msg="删除成功";
			}else {
				msg="删除失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeletePermission")
	@ResponseBody
	public Map<String,Object> batchDeletePermission(PermissionVo permissionVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			Integer[] ids=permissionVo.getIds();
			if(ids!=null&&ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					permissionVo.setId(ids[i]);
					int num=this.permissionService.deletePermission(permissionVo);
					if(num>0) {
						msg="删除成功";
					}else {
						msg="删除失败";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
}
