package com.excilys.controller;

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
public class JSONControllerTest {
	
	@Mock
	ComputerService computerService;
	
	@InjectMocks
	JSONController jsonController = new JSONController();
	
	@Test
	public void getAll() {
		ComputerWrapper computerWrapper = new ComputerWrapper();
		when(computerService.getAll()).thenReturn(computerWrapper);
		
		ComputerWrapper actual = jsonController.getAll();
		
		verify(computerService).getAll();
		assertEquals(computerWrapper, actual);
	}
}
