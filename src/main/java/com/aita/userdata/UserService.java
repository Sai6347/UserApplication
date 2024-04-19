package com.aita.userdata;

import java.util.List;

public interface UserService<User> 
{

	List<UserData> loadUsers();
	
	void store(UserData user);

	UserData getUser(Integer id);
}
