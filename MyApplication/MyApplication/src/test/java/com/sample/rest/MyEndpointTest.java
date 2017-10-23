package com.sample.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

public class MyEndpointTest {

	@Test
	public void shouldReturn200AndSayHello() {
		Response response = new MyEndpoint().sayHello();
		assertEquals("Response code should be 200", Status.OK.getStatusCode(), response.getStatus());
		String greeting = (String)response.getEntity();
		assertEquals("Response message should be Hello, World!", "Hello, World!", greeting);
	}
}
