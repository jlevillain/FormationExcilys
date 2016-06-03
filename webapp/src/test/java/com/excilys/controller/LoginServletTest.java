package com.excilys.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.validator.PageValidator;
import com.excilys.wrapper.Page;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoginServlet.class})
public class LoginServletTest {
	private static final String ERROR = "error";
	private static final String LOGOUT = "logout";

	@Mock
	ApplicationContext context;
	
	@Mock
	ModelAndView model;
	
	@InjectMocks
	LoginServlet loginServlet = new LoginServlet();
	
	@Test
	public void login() throws Exception {
		when(context.getMessage("Login.error", null, LocaleContextHolder.getLocale())).thenReturn(ERROR);
		PowerMockito.whenNew(ModelAndView.class).withNoArguments().thenReturn(model);
		
		loginServlet.login(ERROR, LOGOUT);
		
		verify(context).getMessage("Login.error", null, LocaleContextHolder.getLocale());
		verify(model).setViewName("login");
	}
	
}
