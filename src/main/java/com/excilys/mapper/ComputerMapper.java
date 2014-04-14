package com.excilys.mapper;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.utils.*;

import com.excilys.dto.ComputerDto;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.ComputerService;


@Component
public class ComputerMapper {
	
	Logger logger =LoggerFactory.getLogger(ComputerMapper.class);
	@Autowired
	private ComputerService computerService;
	@Autowired
	private CompanyMapper companyMapper;
	
	public Computer convertDtoToComputer(ComputerDto computerDto) {
		long id=Long.parseLong(computerDto.getId());
		Date introduced, discontinued;
		
		try {
			introduced = DateConverter.convertStringToDate(computerDto.getIntroduced());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		try {
			discontinued = DateConverter.convertStringToDate(computerDto.getDiscontinued());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		Company company = companyMapper.convertDtoToCompany(computerDto.getCompany());
		
		Computer computer=Computer.build().id(id).name(computerDto.getName()).
		introduced(introduced).discontinued(discontinued).company(company).build();
		
		return computer;
	}
	
	
}
