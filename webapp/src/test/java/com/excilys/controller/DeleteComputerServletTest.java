package com.excilys.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.excilys.service.ComputerService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteComputerServletTest {
	private static final int ID = 1;
	private static final String EXPECTED = "redirect:/";
	@Mock
	ComputerService computerService;
	
	@InjectMocks
	DeleteComputerServlet deleteComputerServlet = new DeleteComputerServlet();
	
	@Test
	public void doGet() {
		
		String actual = deleteComputerServlet.doGet(ID);
		
		verify(computerService).deleteOne(ID);
		assertEquals(EXPECTED, actual);
	}
}
