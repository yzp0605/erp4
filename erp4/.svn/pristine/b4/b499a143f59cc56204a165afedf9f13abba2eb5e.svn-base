package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.ActiverUser;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.TreeNodeBuilder;
import com.sxt.sys.vo.LogInfoVo;
import com.sxt.sys.vo.PermissionVo;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private LogInfoService logInfoService;
	
	/**
	 * 跳转到用户登陆的页面
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "system/main/login";
	}
	
	/**
	 * 登陆
	 */
	@RequestMapping("login")
	public String login(UserVo userVo,Model model,HttpServletRequest request) {
		//1,得到shiro的主体
		Subject subject=SecurityUtils.getSubject();
		// 2.创建token用于认证 客户端传递过来的用户名和密码
		AuthenticationToken token = new UsernamePasswordToken(userVo.getLoginname(), userVo.getPwd());
		// 做认证
		try {
			subject.login(token);
			System.out.println("---------------------认证成功");
			//取出ActiverUser
			ActiverUser activerUser =(ActiverUser) subject.getPrincipal();
			request.getSession().setAttribute("user", activerUser.getCurUser());
			//记录登陆日志
			LogInfoVo logInfoVo=new LogInfoVo();
			logInfoVo.setLoginname(activerUser.getCurUser().getName()+"-"+activerUser.getCurUser().getLoginname());
			logInfoVo.setLoginip(request.getRemoteAddr().toString());
			logInfoVo.setLogintime(new Date());
			logInfoService.addLogInfo(logInfoVo);
			
			return "system/main/index";
		} catch (UnknownAccountException e1) {
			System.out.println("用户名不存在");
			model.addAttribute("error", "用户名不存在");
		} catch (IncorrectCredentialsException e2) {
			System.out.println("密码不正确");
			model.addAttribute("error", "密码不正确");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		return "system/main/login";
		
	}
	
	
	/**
	 * 加载主页面的导航菜单
	 */
	@RequestMapping("loadIndexTree")
	@ResponseBody
	public List<TreeNode> loadIndexTree(HttpSession session){
		//得到用户
		User user=(User) session.getAttribute("user");
		List<Permission> list=null;
		if(user.getType()==SYS_Constast.USER_TYPE_SUPER) {
			//如果是超级管理员，查询所有菜单
			PermissionVo permissionVo=new PermissionVo();
			permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
			permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
			list=permissionService.queryPermissionForList(permissionVo);
		}else {
			//否则根据用户ID查询菜单
			PermissionVo permissionVo=new PermissionVo();
			permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
			permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
			list=permissionService.queryPermissionForList(permissionVo,user.getId());
		}
		//构造List<TreeNode> 
		List<TreeNode>  treeNodes=new ArrayList<>();
		for (Permission p : list) {
			Boolean spread=p.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNodes.add(new TreeNode(p.getId(), p.getPid(), p.getName(), p.getHref(), p.getIcon(), spread, p.getTarget()));
		}
		//把简答的json集合对象转成标准的json集合对象
		return TreeNodeBuilder.builder(treeNodes, 1);
	}
}
