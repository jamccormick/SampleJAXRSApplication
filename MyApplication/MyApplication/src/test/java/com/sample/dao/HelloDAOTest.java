package com.sample.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloDAOTest {
	
	@Test
	public void testGetGreeting() {
		HelloDAO dao = new HelloDAO();
		String greeting = dao.getGreeting();
		assertEquals("Greetings should match", "Hello, world!", greeting);
	}
	
	@Test
	public void testSetGreeting() {
		
	}
}
