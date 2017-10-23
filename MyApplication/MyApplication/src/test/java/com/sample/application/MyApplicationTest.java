package com.sample.application;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Set;

public class MyApplicationTest {
	
	@Test
	public void testGetClasses()
	{
		Set<Class<?>> classes = new MyApplication().getClasses();
		assertEquals("There should be one class",  1, classes.size());
	}

}
