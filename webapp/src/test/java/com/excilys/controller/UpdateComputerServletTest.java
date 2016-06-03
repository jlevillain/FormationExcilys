package com.excilys.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerDtoValidator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UpdateComputerServletTest {
	private static final String REDIRECT = "redirect:/";
	private static final String ADD_COMPUTER = "addComputer";
	private static final String REDIRECT_ADD_COMPUTER = REDIRECT+"AddComputer";
	private static final int ID = 1
			;
	@Mock
	ComputerDtoValidator computerValidator;
	
	@Mock
	CompanyService companyService;
	
	@Mock
	ComputerService computerService;
	
	@Mock
	ComputerMapper computerMapper;
	
	@Mock
	ModelMap model;
	
	@Mock
	BindingResult bindingResult;
	
	@InjectMocks
	UpdateComputerServlet updateComputerServlet;
	
	@Test
	public void populateComputerList() {
		List<Company> companies = new ArrayList<>();
		when(companyService.getAll()).thenReturn(companies);
		
		List<Company> actual = updateComputerServlet.populateComputerList();
		
		verify(companyService).getAll();
		assertEquals(companies, actual);
	}
	
	@Test
	public void doGetIdNull() {
		
		String actual = updateComputerServlet.doGet(null, model);
		
		assertEquals(REDIRECT, actual);
	}
	
	@Test
	public void doGet() {
		Computer computer = new Computer();
		ComputerDto computerDTO = new ComputerDto();
		when(computerService.getOne(ID)).thenReturn(computer);
		when(computerMapper.convertComputerToDto(computer)).thenReturn(computerDTO);
		
		String actual = updateComputerServlet.doGet(ID, model);
		
		verify(computerService).getOne(ID);
		verify(computerMapper).convertComputerToDto(computer);
		verify(model).addAttribute("computer", computerDTO);
		assertEquals(ADD_COMPUTER, actual);
	}
	
	@Test
	public void doPostRedirectAddComputer() {
		ComputerDto computerDTO = new ComputerDto();
		
		String actual = updateComputerServlet.doPost(computerDTO, bindingResult, model);
		
		assertEquals(REDIRECT_ADD_COMPUTER, actual);
	}
	
	@Test
	public void doPostHasErrors() {
		ComputerDto computerDTO = ComputerDto.build().id("id").name("name").introduced("introduced")
				.discontinued("discontinued").company(new CompanyDto()).build();
		when(bindingResult.hasErrors()).thenReturn(true);
		
		String actual = updateComputerServlet.doPost(computerDTO, bindingResult, model);
		
		verify(bindingResult).hasErrors();
		assertEquals(ADD_COMPUTER, actual);
	}
	
	@Test
	public void doPostWithoutError() {
		Computer computer = new Computer();
		ComputerDto computerDTO = ComputerDto.build().id("id").name("name").introduced("introduced")
				.discontinued("discontinued").company(new CompanyDto()).build();
		when(bindingResult.hasErrors()).thenReturn(false);
		when(computerMapper.convertDtoToComputer(computerDTO)).thenReturn(computer);
		
		String actual = updateComputerServlet.doPost(computerDTO, bindingResult, model);
		
		verify(bindingResult).hasErrors();
		verify(computerMapper).convertDtoToComputer(computerDTO);
		verify(computerService).updateOne(computer);
		assertEquals(REDIRECT, actual);
	}
	
	@Test
	public void doPostNullComputer() {
		Computer computer = null;
		ComputerDto computerDTO = ComputerDto.build().id("id").name("name").introduced("introduced")
				.discontinued("discontinued").company(new CompanyDto()).build();
		when(bindingResult.hasErrors()).thenReturn(false);
		when(computerMapper.convertDtoToComputer(computerDTO)).thenReturn(computer);
		
		String actual = updateComputerServlet.doPost(computerDTO, bindingResult, model);
		
		verify(bindingResult).hasErrors();
		verify(computerMapper).convertDtoToComputer(computerDTO);
		assertEquals(ADD_COMPUTER, actual);
	}
	
}
