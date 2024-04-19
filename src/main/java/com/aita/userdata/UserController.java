package com.aita.userdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Employee;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getAll")
	public List<UserData> UserData()
	{	
		return userService.loadUsers();
	}
	
	@PostMapping(value="/create")
	public UserData createUser(@RequestBody UserData user) 
	{
		System.out.println("created");
		userService.store(user);
		return user;
	}
	
	@RequestMapping(value="/get/{id}")
	public UserData getUser(@PathVariable("id") Integer id)
	{	
		return userService.getUser(id);
	}
	
	
}
