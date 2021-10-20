package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnecter {
	private static Properties databaseProperties = new Properties();
	private static String user = null;
	private static String password = null;
	private static String uri = null;
	
	static {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		InputStream resourceAsStream = contextClassLoader.getResourceAsStream("DatabaseConnection.properties");
		try {
			databaseProperties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName(databaseProperties.getProperty("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user = databaseProperties.getProperty("jdbc.user");
		password = databaseProperties.getProperty("jdbc.password");
		uri = databaseProperties.getProperty("jdbc.uri");
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(uri, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Statement getStatement(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static PreparedStatement getPreparedStatement(Connection connection, String sqlString) {
		try {
			return connection.prepareStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (null != resultSet) resultSet.close();
			if (null != statement) statement.close();
			if (null != connection) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
