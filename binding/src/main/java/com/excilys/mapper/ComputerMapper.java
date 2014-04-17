package com.excilys.mapper;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.utils.*;
import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.ComputerService;


/**
 * class mapping a computerDto in computer
 * @author excilys
 *
 */
@Component
public class ComputerMapper {
	
	Logger logger =LoggerFactory.getLogger(ComputerMapper.class);
	@Autowired
	private ComputerService computerService;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private DateConverter dateConverter;
	
	/**
	 * convert a computerDto in computer
	 * @param computerDto computerDto to convert
	 * @return computer
	 */
	public Computer convertDtoToComputer(ComputerDto computerDto) {
		long id=Long.parseLong(computerDto.getId());
		DateTime introduced;
		DateTime discontinued;
		
		try {
			//introduced = DateConverter.convertStringToDate(computerDto.getIntroduced());
			introduced=dateConverter.convertStringToDateTime(computerDto.getIntroduced());
		} catch (IllegalFieldValueException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		try {
			discontinued = dateConverter.convertStringToDateTime(computerDto.getDiscontinued());
		} catch (IllegalFieldValueException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		Company company = companyMapper.convertDtoToCompany(computerDto.getCompany());
		
		Computer computer=Computer.build().id(id).name(computerDto.getName()).
		introduced(introduced).discontinued(discontinued).company(company).build();
		logger.debug(""+computer);
		return computer;
	}
	
	/**
	 * convert a computer in computerDto
	 * @param computer computer to convert
	 * @return computerDto
	 */
	public ComputerDto convertComputerToDto(Computer computer) {
		String introduced="";
		String discontinued="";
		try {
			//introduced = DateConverter.convertStringToDate(computerDto.getIntroduced());
			introduced=dateConverter.convertDateTimeToString(computer.getIntroduced());
		} catch (IllegalFieldValueException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		try {
			discontinued = dateConverter.convertDateTimeToString(computer.getDiscontinued());
		} catch (IllegalFieldValueException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			return null;
		}
		CompanyDto company=companyMapper.convertCompanyToDto(computer.getCompany());
		ComputerDto comp=ComputerDto.build().id(""+computer.getId()).
				name(computer.getName()).
				introduced(introduced).
				discontinued(discontinued).
				company(company).build();
		return comp;
	}
	
}
