package com.excilys.validator;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;

/**
 * class validating a computer 
 * @author jlevillain
 *
 */
@Component
public class ComputerValidator {
	Logger logger = LoggerFactory.getLogger(ComputerDtoValidator.class);
	
	@Autowired
	ResourceBundleMessageSource source;
	
	/**
	 * validate a computer
	 * @param computer computer to validate
	 * @return list of error
	 */
	public List<String> valide(ComputerDto computer) {
		List<String> list=new ArrayList<String>();
		list.addAll(valideId(computer.getId()));
		list.addAll(valideName(computer.getName()));
		list.addAll(valideIntroduced(computer.getIntroduced()));
		list.addAll(valideDiscontinued(computer.getDiscontinued()));
		list.addAll(valideCompany(computer.getCompany()));
		return list;
		
	}
	
	/**
	 * validate the id of computer
	 * @param id id of computer
	 * @return list of error
	 */
	public List<String> valideId(String id) {
		List<String> list=new ArrayList<String>();
		if (id.matches("[0-9]+")){
			return list;
		}
		
		list.add("invalidComputerId");
		return list;
	}
	
	/**
	 * validate the name of computer
	 * @param name name of computer
	 * @return list of error
	 */
	public List<String> valideName(String name) {
		List<String> list=new ArrayList<String>();
		if (name.matches(".+")) {
			return list;
		}
		
		list.add("invalidComputerName");
		return list;
	}
	/**
	 * validate the introduced date of computer
	 * @param introduced introduced date of computer
	 * @return list of error
	 */
	public List<String> valideIntroduced(String introduced) {
		List<String> list=new ArrayList<String>();
		logger.debug(source.getMessage("Date.pattern.java", null, LocaleContextHolder.getLocale()));
		if (introduced.matches(source.getMessage("Date.pattern.java", null, LocaleContextHolder.getLocale())) || "".equals(introduced)) {
			return list;
		}
		
		list.add("invalidComputerIntroduced");
		return list;
		
	}
	/**
	 * validate the discontinued date of computer
	 * @param discontinued discontinued date of computer
	 * @return list of error
	 */
	public List<String> valideDiscontinued(String discontinued) {
		List<String> list=new ArrayList<String>();
		if (discontinued.matches(source.getMessage("Date.pattern.java", null, LocaleContextHolder.getLocale())) || "".equals(discontinued)) {
			return list;
		}
		list.add("invalidComputerDiscontinued");
		return list;
		
	}
	/**
	 * validate a company
	 * @param company company to validate
	 * @return list of error
	 */
	public List<String> valideCompany(CompanyDto company) {
		return CompanyValidator.valide(company);
	}
}
