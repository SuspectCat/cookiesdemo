package com.service.impl;

import java.lang.reflect.InvocationTargetException;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.EmpInfo;
import com.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public boolean isLogin(String username, String password) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		
		if (null != userDao.findUser(username, password, EmpInfo.class)) return true;
		return false;
		
	}

}
