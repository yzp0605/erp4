package com.sxt.md;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.Md5Uitls;
import com.sxt.sys.utils.RandomUtils;
import com.sxt.sys.vo.UserVo;

public class ModData {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//查询所有用户
		UserService userService=context.getBean(UserService.class);
		List<User> list=userService.queryAllUserForList();
		for (User user : list) {
			System.out.println(user);
			String salt=RandomUtils.createRandomUUID();
			user.setSalt(salt);
			user.setPwd(Md5Uitls.encodePwdUseMd5("123456", salt, 2));
			UserVo userVo=new UserVo();
			BeanUtils.copyProperties(user, userVo);
			userService.updateUser(userVo);
		}
		
	}

}
