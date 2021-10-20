package com.service;

import java.lang.reflect.InvocationTargetException;

public interface UserLoginService {
	/**
	 * ����û��Ƿ��¼�ɹ�
	 * @param username	�û���
	 * @param password	����
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
