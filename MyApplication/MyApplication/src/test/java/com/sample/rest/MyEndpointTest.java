package com.sample.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.sample.dao.HelloDAO;

@RunWith(MockitoJUnitRunner.class)
public class MyEndpointTest {

	@InjectMocks
	MyEndpoint endpoint;
	
	@Mock
	HelloDAO dao;
	
	@Test
	public void shouldReturn200AndSayHello() {
		when(dao.getGreeting()).thenReturn("Hello, World!");
		Response response = endpoint.sayHello();
		assertEquals("Response code should be 200", Status.OK.getStatusCode(), response.getStatus());
		String greeting = (String)response.getEntity();
		assertEquals("Response message should be Hello, World!", "Hello, World!", greeting);
	}
	
	@Test
	public void shoudlReturn200AndANumberWhenPostingAHello()
	{
		when(dao.postGreeting(any(String.class))).thenReturn(1);
		Response response = endpoint.postHello("Hello, World!");
		assertEquals("Response code should be 200", Status.OK.getStatusCode(), response.getStatus());
		Integer id = (Integer) response.getEntity();
		assertEquals("Response entity should be 1", new Integer(1), id);
	}
}
