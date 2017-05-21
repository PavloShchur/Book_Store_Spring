package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		user.setName(user.getName().toUpperCase());
		if (user.getEmail().contains("@")) {
			// validation
			// crypt
			// other logic
			userDao.save(user);
		} else {
			System.out.println("wrong email");
		}
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		return userDao.findAll();

	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);

	}

	public void update(User user) {
		userDao.save(user);
	}

}
