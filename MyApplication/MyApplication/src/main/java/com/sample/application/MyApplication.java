package com.sample.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.sample.rest.MyEndpoint;

@ApplicationPath("/")
public class MyApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		classes.add(MyEndpoint.class);
		
		return classes;
	}
}
