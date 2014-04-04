package com.excilys.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerValidator;

/**
 * Servlet implementation class AddComputerServlet
 */

@Controller
@RequestMapping("/AddComputer")
public class AddComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(AddComputerServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private ComputerService computerService;
    
	@Autowired
    private CompanyService companyService;
	
	@Autowired
	private ComputerMapper computerMapper;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
   
    
    @ModelAttribute("companyList")
    Map<String,String> populateComputerList() {
    	List<Company> companyList=companyService.getAll();
    	Map<String,String> list=new HashMap<String,String>();
    	for (Company comp: companyList) {
    		list.put(""+comp.getId(), comp.getName());
    	}
		return list;
    }
    
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		// TODO Auto-generated method stub
		return new ModelAndView("addComputer","computer",new Computer());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String doPost(@ModelAttribute("computer") ComputerDto cdto,
			ModelMap model) {
		// TODO Auto-generated method stub
		logger.debug(""+cdto);
		
		if (cdto.getName()==null || cdto.getIntroduced()==null
				|| cdto.getDiscontinued() ==null || cdto.getCompany()==null) {
			return "redirect:/AddComputer";
		}
		/*
		CompanyDto compDto=CompanyDto.build().
				id(computer.getCompany().getId()).
				name("a").build();
		ComputerDto cdto=ComputerDto.build().id("0").
			name(computer.getname).
			introduced(computer.getintroducedDate).
			discontinued(computer.getDiscontinued()).
			company(compDto).build();
		*/
		List<String> error=ComputerValidator.valide(cdto);
		model.addAttribute("error", error);
		model.addAttribute("computer", cdto);
		if ( error.size()==0 ) {
			Computer comp=computerMapper.convertDtoToComputer(cdto);
			if (comp!=null) {
				logger.debug(comp.toString());
				computerService.insertOne(comp);
				return "redirect:/";
			}
		}
		
		return "addComputer";
		
	}

}
