package com.excilys.om;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LogTest {

	private static final long id = 1L;
	private static final String request = "request";
	private static final long defaultId = 0L;
	private static final String defaultRequest = null;
	
	@Test
	public void logBuilder() {
		Log log = Log.build().id(id).request(request).build();
		
		assertEquals(id, log.getId());
		assertEquals(request, log.getRequest());
	}
	
	@Test
	public void logDefaultBuilder() {
		Log log = Log.build().build();
		
		assertEquals(defaultId, log.getId());
		assertEquals(defaultRequest, log.getRequest());
	}
	
	@Test
	public void logEquality() {
		Log log1 = Log.build().id(id).request(request).build();
		Log log2 = Log.build().id(id).request(request).build();
		boolean actual = log1.equals(log2);
		assertTrue(actual);
	}
	
	@Test
	public void logInequality() {
		Log log1 = Log.build().id(id).request(request).build();
		Log log2 = Log.build().id(defaultId).request(defaultRequest).build();
		boolean actual = log1.equals(log2);
		assertFalse(actual);
	} 
}
