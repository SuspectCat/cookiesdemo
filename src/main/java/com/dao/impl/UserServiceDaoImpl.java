package com.dao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserServiceDao;
import com.util.DatabaseConnecter;

public class UserServiceDaoImpl implements UserServiceDao {

	@Override
	public <T> List<T> DisplayAllUser(Class<T> type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		List<T> allUser = new ArrayList<T>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DatabaseConnecter.getConnection();
			statement = DatabaseConnecter.getStatement(connection);
			
			String sql = "select * from user_info where status = 0;";
			
			resultSet = statement.executeQuery(sql);
			
			if (null != resultSet) {
				while (resultSet.next()) {
					ResultSetMetaData metaData = resultSet.getMetaData();
					int columnCount = metaData.getColumnCount();
					
					Constructor<T> constructor = type.getConstructor();
					T newInstance = constructor.newInstance();
					
					for (int index = 0; index < columnCount; index++) {
						String columnName = metaData.getColumnName(index + 1);
						
						Method[] declaredMethods = type.getDeclaredMethods();
						
						for (Method method : declaredMethods) {
							if (method.getName().equalsIgnoreCase("set" + columnName))
								method.invoke(newInstance, resultSet.getObject(columnName));
						}
					}
					
					allUser.add(newInstance);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConnecter.close(connection, statement, resultSet);
		}
		
		return allUser;
	}

	@Override
	public void insertMessage(String username, String real_name, String gender) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DatabaseConnecter.getConnection();
			String sql = "insert into  user_info value (null, ?, ?, ?, 0);";
			preparedStatement = DatabaseConnecter.getPreparedStatement(connection, sql);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, real_name);
			preparedStatement.setString(3, gender);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConnecter.close(connection, preparedStatement, null);
		}
		
	}

	@Override
	public <T> List<T> selectUser(String username, String real_name, String gender, Class<T> type) throws SQLException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<T> userList = new ArrayList<T>();
		
		connection = DatabaseConnecter.getConnection();
		
		StringBuilder sqlStringBuilder = new StringBuilder();
		sqlStringBuilder.append("select * from user_info where status = 0 and username like '%?%' and  real_name like '%?%' and gender = ?;");
		
		preparedStatement = DatabaseConnecter.getPreparedStatement(connection, sqlStringBuilder.toString());
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, real_name);
		preparedStatement.setString(3, gender);
		
		resultSet = preparedStatement.executeQuery();
		
		if (null != resultSet) {
			while (resultSet.next()) {
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				Constructor<T> constructor = type.getConstructor();
				T newInstance = constructor.newInstance();
				
				for (int index = 0; index < columnCount; index++) {
					String columnName = metaData.getColumnName(index + 1);
					
					Method[] declaredMethods = type.getDeclaredMethods();
					
					for (Method method : declaredMethods) {
						if (method.getName().equalsIgnoreCase("set" + columnName))
							method.invoke(newInstance, resultSet.getObject(columnName));
					}
				}
				
				userList.add(newInstance);
			}
		}
		
		return userList;
	}

}
