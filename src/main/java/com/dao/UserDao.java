package com.dao;

import java.lang.reflect.InvocationTargetException;

public interface UserDao {
	/**
	 * 通过用户名和密码查找用户
	 * @param <T>
	 * @param username
	 * @param password
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	<T> T findUser(String username, String password, Class<T> type) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
}
