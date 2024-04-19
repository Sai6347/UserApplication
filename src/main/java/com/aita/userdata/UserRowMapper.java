package com.aita.userdata;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserData> 
{
	public UserData mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		UserData user = new UserData();
		user.setName(rs.getString("name"));
		user.setMobile(rs.getString("mobile"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setcPassword(rs.getString("cPassword"));
		
		return user;
	}
	
}

