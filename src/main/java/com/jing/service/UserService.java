package com.jing.service;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.UserDao;
import com.jing.utils.Md5Utils;
import com.jing.vo.User;

@Transactional
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username, Md5Utils.md5(password));
	}

}
