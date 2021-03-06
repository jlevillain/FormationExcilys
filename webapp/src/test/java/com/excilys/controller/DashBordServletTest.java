package com.excilys.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;

import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.PageValidator;
import com.excilys.wrapper.Page;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Page.class, PageValidator.class})
public class DashBordServletTest {
	private static final String SEARCH_PARAM = "searchParam";
	private static final String PAGE_PARAM = "pageParam";
	private static final String ORDER_BY_PARAM = "orderByParam";
	private static final String IS_DESC_PARAM = "isDescParam";
	private static final String NB_PAGE_PARAM = "nbPageParam";
	private static final String LANG = "lang";
	private static final String LOGOUT = "logout";
	private static final String LANG_COOKIE = "langCookie";
	private static final String SEARCH = "searchParam";
	private static final int PAGE = 1;
	private static final int ORDER_BY = 2;
	private static final boolean DESC = false;
	private static final int NB_PAGE = 1;
	private static final int COMPUTER_SIZE = 1;
	
	@Mock
	ApplicationContext context;
	
	@Mock
	ComputerMapper computerMapper;
	
	@Mock
	ComputerService computerService;
	
	@Mock
	CompanyService companyService;
	
	@Mock
	ModelMap model;
	
	@Mock
	Page.Builder pageBuilder;
	
	@InjectMocks
	DashBordServlet dashBordServlet = new DashBordServlet();
	
	@Test
	public void doGet() throws IOException {
		
		PowerMockito.mockStatic(Page.class);
		PowerMockito.mockStatic(PageValidator.class);
		
		Page pageWrapperExpected = new Page();
		List<Computer> computerList = new ArrayList<Computer>();
		Computer computer = new Computer();
		computerList.add(computer);
		
		when(context.getMessage("Login.success", null, LocaleContextHolder.getLocale())).thenReturn("Login.success");
		
		when(computerService.getAll(SEARCH, PAGE-1, NB_PAGE, ORDER_BY, DESC)).thenReturn(computerList);
		when(computerService.getSize(SEARCH)).thenReturn(COMPUTER_SIZE);
		
		when(PageValidator.validSearch(SEARCH_PARAM)).thenReturn(SEARCH);
		when(PageValidator.validPage(PAGE_PARAM)).thenReturn(PAGE);
		when(PageValidator.validOrderBy(ORDER_BY_PARAM)).thenReturn(ORDER_BY);
		when(PageValidator.validIsDesc(IS_DESC_PARAM)).thenReturn(DESC);
		when(PageValidator.validNbPage(NB_PAGE_PARAM)).thenReturn(NB_PAGE);
		
		when(Page.build()).thenReturn(pageBuilder);
		when(pageBuilder.search(SEARCH)).thenReturn(pageBuilder);
		when(pageBuilder.page(PAGE)).thenReturn(pageBuilder);
		when(pageBuilder.isDesc(DESC)).thenReturn(pageBuilder);
		when(pageBuilder.orderBy(ORDER_BY)).thenReturn(pageBuilder);
		when(pageBuilder.nbPage(NB_PAGE)).thenReturn(pageBuilder);
		when(pageBuilder.computerList(any(List.class))).thenReturn(pageBuilder);
		when(pageBuilder.computerSize(COMPUTER_SIZE)).thenReturn(pageBuilder);
		when(pageBuilder.build()).thenReturn(pageWrapperExpected);
		
		dashBordServlet.doGet(SEARCH_PARAM, PAGE_PARAM, ORDER_BY_PARAM, IS_DESC_PARAM, NB_PAGE_PARAM, LANG, LOGOUT, LANG_COOKIE, model);
		
		verify(computerMapper).convertComputerToDto(computer);
		verify(model).addAttribute("msg",context.getMessage("Login.success",null,  LocaleContextHolder.getLocale()));
		verify(model).addAttribute("page", pageWrapperExpected);
	}
}
