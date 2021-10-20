package com.dao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.dao.UserDao;
import com.util.DatabaseConnecter;

public class UserDaoImpl implements UserDao {

	@Override
	public <T> T findUser(String username, String password, Class<T> type)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DatabaseConnecter.getConnection();

			StringBuilder sqlStringBuilder = new StringBuilder();
			sqlStringBuilder.append("select * from emp_info where username = ?;");

			preparedStatement = DatabaseConnecter.getPreparedStatement(connection, sqlStringBuilder.toString());

			preparedStatement.setObject(1, username);
			ResultSet executeQuery = preparedStatement.executeQuery();

			if (null != executeQuery) {
				while (executeQuery.next()) {

					Constructor<T> constructor = type.getConstructor();
					T newInstance = constructor.newInstance();
					
					ResultSetMetaData metaData = executeQuery.getMetaData();
					int columnCount = metaData.getColumnCount();
					
					for (int i = 0; i < columnCount; i++) {
						String columnName = metaData.getColumnName(i + 1);
						
						Method[] declaredMethods = type.getDeclaredMethods();
						
						for (Method method : declaredMethods) {
							if (method.getName().equalsIgnoreCase("set" + columnName))
								method.invoke(newInstance, executeQuery.getObject(columnName));
						}
					}
					
					return newInstance;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConnecter.close(connection, preparedStatement, null);
		}

		return null;
	}

}
