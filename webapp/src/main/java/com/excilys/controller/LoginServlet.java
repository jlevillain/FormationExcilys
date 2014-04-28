package com.excilys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginServlet {
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
	 
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error",context.getMessage("Login.error",null,  LocaleContextHolder.getLocale()));
			}
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        String hashedPassword = passwordEncoder.encode("user");
//	        System.out.println(">>> "+hashedPassword);
			model.setViewName("login");
			return model;
		}
}
