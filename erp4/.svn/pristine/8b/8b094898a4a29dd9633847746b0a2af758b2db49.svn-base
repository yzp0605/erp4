package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.Md5Uitls;
import com.sxt.sys.utils.PinyinUtils;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 跳转到userManager.jsp
	 */
	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "system/user/userManager";
	}

	/**
	 * 的userManager.jsp里面加载userLeft.jsp
	 */
	@RequestMapping("toUserLeft")
	public String toUserLeft() {
		return "system/user/userLeft";
	}

	/**
	 * 的userManager.jsp里面加载userRigth.jsp
	 */
	@RequestMapping("toUserRight")
	public String toUserRight() {
		return "system/user/userRight";
	}
	
	
	/**
	 * 加载用户数据
	 */
	@RequestMapping("loadAllUser")
	@ResponseBody
	public DataGridView loadAllUser(UserVo userVo) {
		return this.userService.queryAllUser(userVo);
	}
	
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("toAddUser")
	public String toAddUser() {
		return "system/user/userAdd";
	}
	
	/**
	 * 根据部门ID查询用户的信息
	 */
	@RequestMapping("loadUserByDeptId")
	@ResponseBody
	public List<User> loadUserByDeptId(UserVo userVo){
		return this.userService.queryUserByDeptId(userVo.getDeptid());
	}
	/**
	 * 根据用户名生成拼音
	 */
	@RequestMapping(path="initUserLoginNameUseUserName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String initUserLoginNameUseUserName(String name) {
		String loginname = PinyinUtils.getPinYin(name);
		return loginname;
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public Map<String,Object> addUser(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			//设置用户默认密码[加密后的]
			userVo.setPwd(Md5Uitls.encodePwdUseMd5
					(SYS_Constast.USER_PWD_DEFAULT, userVo.getName()+userVo.getAddress(), 2));
			//设置用户的类型
			userVo.setType(SYS_Constast.USER_TYPE_NORMAL);
			//设置默认头像
			userVo.setImgpath(SYS_Constast.USER_DEFAULT_IMG);
			int num=this.userService.addUser(userVo);
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
	@RequestMapping("toUpdateUser")
	public String toUpdateUser(UserVo userVo,Model model) {
		User user=this.userService.querUserById(userVo.getId());
		model.addAttribute("user", user);
		return "system/user/userUpdate";
	}
	
	/**
	 * 根据用户ID查询用户信息
	 */
	@RequestMapping("queryUserById")
	@ResponseBody
	public User queryUserById(UserVo userVo) {
		return this.userService.querUserById(userVo.getId());
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.userService.updateUser(userVo);
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
	
	
	//重置密码
	@RequestMapping("resetUserPwd")
	@ResponseBody
	public Map<String,Object> resetUserPwd(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.userService.resetUserPwd(userVo);
			if(num>0) {
				msg="重置成功";
			}else {
				msg="重置失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="重置失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public Map<String,Object> deleteUser(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.userService.deleteUser(userVo);
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
	@RequestMapping("batchDeleteUser")
	@ResponseBody
	public Map<String,Object> batchDeleteUser(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			Integer[] ids=userVo.getIds();
			if(ids!=null&&ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					userVo.setId(ids[i]);
					int num=this.userService.deleteUser(userVo);
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
	
	/**
	 * 跳转到分配角色的页面
	 */
	@RequestMapping("toSelectUserRole")
	public String toSelectUserRole(UserVo userVo) {
		return "system/user/selectRole";
	}
	
	
	/**
	 * 加载可用的角色并选中用户已拥有的角色
	 */
	@RequestMapping("loadUserRole")
	@ResponseBody
	public DataGridView loadUserRole(UserVo userVo) {
		return this.userService.queryUserRole(userVo);
	}
	
	/**
	 * 保存用户和角色之间的关系
	 */
	@RequestMapping("saveUserRole")
	@ResponseBody
	public Map<String,Object> saveUserRole(UserVo userVo){
		Map<String,Object> map=new HashMap<>();
		String msg="分配成功";
		try {
			this.userService.saveUserRole(userVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
}
