package com.sxt.sys.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;

/**
 * 工作流的任务办理人的监听
 * 
 * @author LJH 这里面不能加注解 因这个类的对象是avtiviti使用new去创建的
 */
public class LeaveBillTaskListener implements TaskListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// 1,当前这个对象没有被spring管理 如何得到 在这里面得到request
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		// 2,得到session
		HttpSession session=request.getSession();
		// 3,得到当前用户户
		User user=(User) session.getAttribute("user");
		//4,取到领导的ID
		Integer mgr=user.getMgr();
		//5,根据IOC容器
//		ApplicationContext context=
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		//6,根据领导的ID去查询领导的信息
		UserService userService = ctx.getBean(UserService.class);
		//7，查询领导
		User leaderUser = userService.querUserById(mgr);
		//8，设置任务办理人
		delegateTask.setAssignee(leaderUser.getName());
	}

}
