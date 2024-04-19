package com.aita.userdata;

import java.util.List;

public interface UserDao 
{

	public List<UserData> loadUsers();
	
	public void store(UserData user);
}
