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
	private static String searchParam = "searchParam";
	private static String pageParam = "pageParam";
	private static String orderByParam = "orderByParam";
	private static String isDescParam = "isDescParam";
	private static String nbPageParam = "nbPageParam";
	private static String lang = "lang";
	private static String logout = "logout";
	private static String langCookie = "langCookie";
	private static String search = "searchParam";
	int page = 1;
	int orderBy = 2;
	boolean desc = false;
	int nbPage = 1;
	int computerSize = 1;
	
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
		
		when(computerService.getAll(search, page-1, nbPage,orderBy,desc)).thenReturn(computerList);
		when(computerService.getSize(search)).thenReturn(computerSize);
		
		when(PageValidator.validSearch(searchParam)).thenReturn(search);
		when(PageValidator.validPage(pageParam)).thenReturn(page);
		when(PageValidator.validOrderBy(orderByParam)).thenReturn(orderBy);
		when(PageValidator.validIsDesc(isDescParam)).thenReturn(desc);
		when(PageValidator.validNbPage(nbPageParam)).thenReturn(nbPage);
		
		when(Page.build()).thenReturn(pageBuilder);
		when(pageBuilder.search(search)).thenReturn(pageBuilder);
		when(pageBuilder.page(page)).thenReturn(pageBuilder);
		when(pageBuilder.isDesc(desc)).thenReturn(pageBuilder);
		when(pageBuilder.orderBy(orderBy)).thenReturn(pageBuilder);
		when(pageBuilder.nbPage(nbPage)).thenReturn(pageBuilder);
		when(pageBuilder.computerList(any(List.class))).thenReturn(pageBuilder);
		when(pageBuilder.computerSize(computerSize)).thenReturn(pageBuilder);
		when(pageBuilder.build()).thenReturn(pageWrapperExpected);
		
		dashBordServlet.doGet(searchParam, pageParam, orderByParam, isDescParam, nbPageParam, lang, logout, langCookie, model);
		
		verify(computerMapper).convertComputerToDto(computer);
		verify(model).addAttribute("msg",context.getMessage("Login.success",null,  LocaleContextHolder.getLocale()));
		verify(model).addAttribute("page", pageWrapperExpected);
	}
}
