package com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.entity.User;

public interface UserService {
	
	/**
	 * ��ʾ�����û�
	 * @param <T>
	 * @param type
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	List<User> DisplayAllUser() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * ģ����ѯ
	 * @param <T>
	 * @param username
	 * @param real_name
	 * @param gender
	 * @return
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	List<User> selectUser(String username, String real_name, String gender) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException;
	
	/**
	 * ����û�����Ϣ
	 * @param username
	 * @param real_name
	 * @param gender
	 */
	void insertMessage(String username, String real_name, String gender);
//	void updateMessage();
}
