package com.service;

import java.lang.reflect.InvocationTargetException;

public interface UserLoginService {
	/**
	 * 检查用户是否登录成功
	 * @param username	用户名
	 * @param password	密码
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	boolean isLogin(String username, String password) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
}
