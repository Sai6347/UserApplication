package com.aita.userdata;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.model.Employee;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	private UserDao userDao;

	public List<UserData> loadUsers() 
	{
		List<UserData> userList = userDao.loadUsers();
		return userList;
	}

	public void store(UserData user) 
	{
		userDao.store(user);
	}

	public UserData getUser(Integer id) 
	{
	
		return null;
	}

}
