package com.aita.userdata;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.aita.userdata"})
public class UserDataConfig 
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/");
		viewResolver.setSuffix(".html");
		return viewResolver;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSouce());
		
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource dataSouce()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setUrl("jdbc:mysql://localhost:3307/aita?useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
		
	}
}
