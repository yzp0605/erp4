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
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private PermissionService menuService;

	/**
	 * 跳转到menuManager.jsp
	 */
	@RequestMapping("toMenuManager")
	public String toMenuManager() {
		return "system/menu/menuManager";
	}

	/**
	 * 的menuManager.jsp里面加载menuLeft.jsp
	 */
	@RequestMapping("toMenuLeft")
	public String toMenuLeft() {
		return "system/menu/menuLeft";
	}

	/**
	 * 的menuManager.jsp里面加载menuRigth.jsp
	 */
	@RequestMapping("toMenuRight")
	public String toMenuRight() {
		return "system/menu/menuRight";
	}
	
	
	/**
	 * 加载菜单树的json
	 */
	@RequestMapping("loadMenuTree")
	@ResponseBody
	public List<TreeNode> loadMenuTree(PermissionVo menuVo){
		//只加载menu
		menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
		List<Permission> list = menuService.queryPermissionForList(menuVo);
		List<TreeNode> treeNodes=new ArrayList<>();
		for (Permission menu : list) {
			Boolean open=menu.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			Boolean isParent=menu.getParent()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getName(), open, isParent));
		}
		return treeNodes;
	}
	
	
	/**
	 * 加载菜单数据
	 */
	@RequestMapping("loadAllMenu")
	@ResponseBody
	public DataGridView loadAllMenu(PermissionVo menuVo) {
		menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
		return this.menuService.queryAllPermission(menuVo);
	}
	
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("toAddMenu")
	public String toAddMenu() {
		return "system/menu/menuAdd";
	}
	/**
	 * 添加
	 */
	@RequestMapping("addMenu")
	@ResponseBody
	public Map<String,Object> addMenu(PermissionVo menuVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);//添加的菜单
			int num=this.menuService.addPermission(menuVo);
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
	@RequestMapping("toUpdateMenu")
	public String toUpdateMenu(PermissionVo menuVo,Model model) {
		Permission menu=this.menuService.querPermissionById(menuVo.getId());
		if(menu.getIcon()!=null&&!menu.getIcon().equals(""))
		{
			menu.setIcon(menu.getIcon().replace("&", "&amp;"));
		}
		model.addAttribute("menu", menu);
		return "system/menu/menuUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("updateMenu")
	@ResponseBody
	public Map<String,Object> updateMenu(PermissionVo menuVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.menuService.updatePermission(menuVo);
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
	@RequestMapping("deleteMenu")
	@ResponseBody
	public Map<String,Object> deleteMenu(PermissionVo menuVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.menuService.deletePermission(menuVo);
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
	@RequestMapping("batchDeleteMenu")
	@ResponseBody
	public Map<String,Object> batchDeleteMenu(PermissionVo menuVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			Integer[] ids=menuVo.getIds();
			if(ids!=null&&ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					menuVo.setId(ids[i]);
					int num=this.menuService.deletePermission(menuVo);
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
