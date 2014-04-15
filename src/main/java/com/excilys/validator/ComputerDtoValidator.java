package com.excilys.validator;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.excilys.controller.AddComputerServlet;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Computer;
import com.excilys.utils.*;

@Component
public class ComputerDtoValidator implements Validator {
	Logger logger = LoggerFactory.getLogger(ComputerDtoValidator.class);
	
	@Autowired
	private DateConverter dateConverter;
	
	@Autowired
	private ComputerValidator computerValidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ComputerDto.class.isAssignableFrom(clazz) || Computer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ComputerDto comp=(ComputerDto)target;
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.computerDto.name");
		List<String> er=computerValidator.valideIntroduced(comp.getIntroduced());
		/*
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		fmt.withLocale(Locale.FRENCH);
		DateTime titi=fmt.parseDateTime(comp.getIntroduced());
		Date date=titi.toDate();
		
		System.out.println(""+date);
		*/
		if (er.size()!=0) {
			errors.rejectValue("introduced", "FailDate.computerDto.introduced");
		}else {
			try{
				dateConverter.convertStringToDateTime(comp.getIntroduced());
			}catch(IllegalFieldValueException e) {
				logger.debug(""+e.getMessage());
				errors.rejectValue("introduced", "FailDate.computerDto.introduced");
			}
		}
		er=computerValidator.valideDiscontinued(comp.getDiscontinued());
		if (er.size()!=0) {
			errors.rejectValue("discontinued", "FailDate.computerDto.discontinued");
		}else {
			try{
				dateConverter.convertStringToDateTime(comp.getDiscontinued());
			}catch(IllegalFieldValueException e) {
				logger.debug(""+e.getMessage());
				errors.rejectValue("discontinued", "FailDate.computerDto.discontinued");
			}
		}
	}

}
