package com.excilys.bean;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.excilys.bean.ComputerService;
import com.excilys.wrapper.ComputerWrapper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ComputerServiceImplTest {

	@Mock
	com.excilys.service.ComputerService service;
	
	@InjectMocks
	ComputerServiceImpl computerServiceImpl = new ComputerServiceImpl();
	
	@Test
	public void getAll() {
		
		computerServiceImpl.getAll();
		
		verify(service).getAll();
	}
	
}
