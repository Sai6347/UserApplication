package com.aita.userdata;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class UserDataInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
	
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		Class[] configFiles = {UserDataConfig.class};
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() 
	{
		String [] mappings = {"/"};
		return mappings;
	}

}