package com.excilys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class DateConverter {
	Logger logger = LoggerFactory.getLogger(DateConverter.class);
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	/**
	 * convert a string into date
	 * @param str string to convert
	 * @return date
	 * @throws ParseException
	 */
	public Date convertStringToDate(String str) throws ParseException {
		if ("".equals(str)) {
			return null;
		}
		Date date;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		date = format.parse(str);
		return date;
	}
	
	/**
	 * convert a string into datetime
	 * @param str string to convert
	 * @return datetime
	 * @throws IllegalFieldValueException
	 */
	public DateTime convertStringToDateTime(String str) throws IllegalFieldValueException {
		if ("".equals(str)) {
			return null;
		}
		DateTime date = null;
		String pattern=messageSource.getMessage("Date.pattern",null,  LocaleContextHolder.getLocale());
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		date=fmt.parseDateTime(str);
		logger.debug(""+date);
		return date;
	}
	
	/**
	 * convert a datetime into string
	 * @param date date to convert
	 * @return string
	 */
	public String convertDateTimeToString(DateTime date) {
		if (date==null) {
			return "";
		}
		String pattern=messageSource.getMessage("Date.pattern",null,  LocaleContextHolder.getLocale());
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		return fmt.print(date);
	}
}
