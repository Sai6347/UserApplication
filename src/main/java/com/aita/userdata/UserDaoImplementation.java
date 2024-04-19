package com.aita.userdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplementation implements UserDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserData> loadUsers() 
	{
		String sql = "select * from aita.userData";
		
		List<UserData> userList = jdbcTemplate.query(sql, new UserRowMapper());
		
		return userList;
	}

	public void store(UserData user) 
	{
		Object[] userParameters = {user.getName(),user.getMobile(),user.getEmail(),user.getPassword(),user.getcPassword()};
		
		String query = "insert into userData(name,mobile,email,password,cPassword) values(?,?,?,?,?)";
		jdbcTemplate.update(query, userParameters);
		System.out.println("Record Inserted");
	}

}
