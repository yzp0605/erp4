package com.sxt.sys.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sxt.sys.domain.User;

public class SessionUtils {

	/**
	 * 得到session
	 */
	public static HttpSession getSession() {
		// 1,当前这个对象没有被spring管理 如何得到 在这里面得到request
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		// 2,得到session
		HttpSession session = request.getSession();
		return session;
	}

	/**
	 * 得到Sesison里面的用户
	 */
	public static User getUserInSession(String key) {
		return (User) getSession().getAttribute(key);
	}

	/**
	 * 得到Sesison里面的用户的用户名
	 */
	public static String getUserNameInSession(String key) {
		User user = (User) getSession().getAttribute(key);
		return user.getName();
	}

}
