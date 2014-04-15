package com.excilys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jboss.logging.Message;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.excilys.controller.AddComputerServlet;

@Component
public class DateConverter {
	Logger logger = LoggerFactory.getLogger(DateConverter.class);
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
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
	
	public String convertDateTimeToString(DateTime date) {
		if (date==null) {
			return "";
		}
		String pattern=messageSource.getMessage("Date.pattern",null,  LocaleContextHolder.getLocale());
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		return fmt.print(date);
	}
}
