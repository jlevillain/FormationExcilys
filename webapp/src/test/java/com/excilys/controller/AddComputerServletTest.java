package com.excilys.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerDtoValidator;

@RunWith(MockitoJUnitRunner.class)
public class AddComputerServletTest {
	
	@Mock
	BindingResult bindingResult;
	
	@Mock
	ModelMap modelMap;
	
	@Mock
	ComputerDtoValidator computerValidator;
	
	@Mock
	ComputerService computerService;
	
	@Mock	
	CompanyService companyService;
	
	@Mock
	ComputerMapper computerMapper;
	
	@InjectMocks
	AddComputerServlet addComputerServlet = new AddComputerServlet();
	
	@Test
	public void populateComputerList() {
		List<Company> list = new ArrayList<>();
		when(companyService.getAll()).thenReturn(list);
		
		List<Company> list2 = addComputerServlet.populateComputerList();
		
		verify(companyService).getAll();
		assertEquals(list, list2);
	}
	
	@Test
	public void doGet() {
		addComputerServlet.doGet(null);
		
		verify(computerMapper).convertComputerToDto(new Computer());
	}
	
	@Test
	public void doPostNullValue() {
		ComputerDto computer = new ComputerDto();
		computer.setName(null);
		String actual = addComputerServlet.doPost(computer, null, null);
		
		assertEquals("redirect:/AddComputer", actual);
	}
	
	@Test
	public void doPostHasError() {
		ComputerDto computer = new ComputerDto();
		computer.setCompany(new CompanyDto());
		when(bindingResult.hasErrors()).thenReturn(true);
		
		String actual = addComputerServlet.doPost(computer, bindingResult, modelMap);

		verify(bindingResult).hasErrors();
		verify(modelMap).addAttribute("computer", computer);
		
		assertEquals("addComputer", actual);
	}
	
	@Test
	public void doPost() {
		ComputerDto computerDto = new ComputerDto();
		computerDto.setCompany(new CompanyDto());
		Computer computer = new Computer();
		when(bindingResult.hasErrors()).thenReturn(false);
		when(computerMapper.convertDtoToComputer(computerDto)).thenReturn(computer);
		
		String actual = addComputerServlet.doPost(computerDto, bindingResult, modelMap);
		
		verify(bindingResult).hasErrors();
		verify(computerMapper).convertDtoToComputer(computerDto);
		verify(computerService).insertOne(computer);
		
		assertEquals("redirect:/", actual);
	}
	
	@Test
	public void doPostNullComputer() {
		ComputerDto computerDto = new ComputerDto();
		computerDto.setCompany(new CompanyDto());
		Computer computer = null;
		when(bindingResult.hasErrors()).thenReturn(false);
		when(computerMapper.convertDtoToComputer(computerDto)).thenReturn(computer);
		
		String actual = addComputerServlet.doPost(computerDto, bindingResult, modelMap);
		
		verify(bindingResult).hasErrors();
		verify(computerMapper).convertDtoToComputer(computerDto);
		
		assertEquals("addComputer", actual);
	}
}
