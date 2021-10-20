package com.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface UserServiceDao {
	<T> List<T> DisplayAllUser(Class<T> type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	void insertMessage(String username, String real_name, String gender);
	
	<T> List<T> selectUser(String username, String real_name, String gender, Class<T> type) throws SQLException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
