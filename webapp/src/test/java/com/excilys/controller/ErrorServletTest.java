package com.excilys.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.exception.SQLRuntimeException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ErrorServlet.class)
public class ErrorServletTest {
	private static final String ERROR_ARG = "error/errorSql";
	@Mock
	ModelAndView model;
	
	@InjectMocks
	ErrorServlet errorServlet = new ErrorServlet();
	
	@Test
	public void handleSqlRuntimeException() throws Exception {
		SQLRuntimeException ex = new SQLRuntimeException();
		
		PowerMockito.whenNew(ModelAndView.class).withArguments(ERROR_ARG).thenReturn(model);
		
		ModelAndView actualModel = errorServlet.handleSqlRuntimeException(ex);

		PowerMockito.verifyNew(ModelAndView.class).withArguments(ERROR_ARG);
		assertEquals(model, actualModel);
		verify(model).addObject("exception", ex);
	}
	
	@Test
	public void handleDataAccessException() throws Exception {
		DataAccessException ex = new TransientDataAccessResourceException("msg");
		
		PowerMockito.whenNew(ModelAndView.class).withArguments(ERROR_ARG).thenReturn(model);
		
		ModelAndView actualModel = errorServlet.handleSqlRuntimeException(ex);
		
		PowerMockito.verifyNew(ModelAndView.class).withArguments(ERROR_ARG);
		assertEquals(model, actualModel);
		verify(model).addObject("exception", ex);
	}
	
	@Test
	public void handleException() throws Exception {
		SQLRuntimeException ex = new SQLRuntimeException();
		
		PowerMockito.whenNew(ModelAndView.class).withArguments(ERROR_ARG).thenReturn(model);
		
		ModelAndView actualModel = errorServlet.handleException(ex);
		
		PowerMockito.verifyNew(ModelAndView.class).withArguments(ERROR_ARG);
		assertEquals(model, actualModel);
		verify(model).addObject("exception", ex);
	}
	
}
