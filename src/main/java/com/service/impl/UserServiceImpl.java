package com.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.dao.UserServiceDao;
import com.dao.impl.UserServiceDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> DisplayAllUser() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		UserServiceDao userServiceDao = new UserServiceDaoImpl();
		
		List<User> displayAllUser = userServiceDao.DisplayAllUser(User.class);
		
		return displayAllUser;
	}

	@Override
	public void insertMessage(String username, String real_name, String gender) {
		// TODO Auto-generated method stub
		UserServiceDao dao = new UserServiceDaoImpl();
		
		dao.insertMessage(username, real_name, gender);
	}

	@Override
	public List<User> selectUser(String username, String real_name, String gender) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
		// TODO Auto-generated method stub
		UserServiceDao dao = new UserServiceDaoImpl();
		List<User> selectUser = dao.selectUser(username, real_name, gender, User.class);
		
		return selectUser;
	}

}
