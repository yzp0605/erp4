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
import com.sxt.sys.domain.Dept;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.vo.DeptVo;

@Controller
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	/**
	 * 跳转到deptManager.jsp
	 */
	@RequestMapping("toDeptManager")
	public String toDeptManager() {
		return "system/dept/deptManager";
	}

	/**
	 * 的deptManager.jsp里面加载deptLeft.jsp
	 */
	@RequestMapping("toDeptLeft")
	public String toDeptLeft() {
		return "system/dept/deptLeft";
	}

	/**
	 * 的deptManager.jsp里面加载deptRigth.jsp
	 */
	@RequestMapping("toDeptRight")
	public String toDeptRight() {
		return "system/dept/deptRight";
	}
	
	
	/**
	 * 加载部门树的json
	 */
	@RequestMapping("loadDeptTree")
	@ResponseBody
	public List<TreeNode> loadDeptTree(DeptVo deptVo){
		List<Dept> list = deptService.queryAllDeptForList(deptVo);
		List<TreeNode> treeNodes=new ArrayList<>();
		for (Dept dept : list) {
			Boolean open=dept.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			Boolean isParent=dept.getParent()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNodes.add(new TreeNode(dept.getId(), dept.getPid(), dept.getName(), open, isParent));
		}
		return treeNodes;
	}
	
	
	/**
	 * 加载部门数据
	 */
	@RequestMapping("loadAllDept")
	@ResponseBody
	public DataGridView loadAllDept(DeptVo deptVo) {
		return this.deptService.queryAllDept(deptVo);
	}
	
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("toAddDept")
	public String toAddDept() {
		return "system/dept/deptAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("addDept")
	@ResponseBody
	public Map<String,Object> addDept(DeptVo deptVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.deptService.addDept(deptVo);
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
	@RequestMapping("toUpdateDept")
	public String toUpdateDept(DeptVo deptVo,Model model) {
		Dept dept=this.deptService.querDeptById(deptVo.getId());
		model.addAttribute("dept", dept);
		return "system/dept/deptUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("updateDept")
	@ResponseBody
	public Map<String,Object> updateDept(DeptVo deptVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.deptService.updateDept(deptVo);
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
	@RequestMapping("deleteDept")
	@ResponseBody
	public Map<String,Object> deleteDept(DeptVo deptVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.deptService.deleteDept(deptVo);
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
	@RequestMapping("batchDeleteDept")
	@ResponseBody
	public Map<String,Object> batchDeleteDept(DeptVo deptVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			Integer[] ids=deptVo.getIds();
			if(ids!=null&&ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					deptVo.setId(ids[i]);
					int num=this.deptService.deleteDept(deptVo);
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
