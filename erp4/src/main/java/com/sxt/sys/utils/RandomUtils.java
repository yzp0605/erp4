package com.sxt.sys.utils;

import java.util.UUID;

/**
 * 随机字符串工具
 * @author LJH
 *
 */
public class RandomUtils {

	/**
	 * 生成一个UUID
	 */
	public static String createRandomUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	
	
	
}
