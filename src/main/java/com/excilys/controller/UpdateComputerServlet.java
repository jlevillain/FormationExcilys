package com.excilys.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.excilys.dao.DaoFactory;
import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerDtoValidator;
import com.excilys.validator.ComputerValidator;

/**
 * Servlet implementation class UpdateComputerServlet
 */
@Controller
@RequestMapping("/UpdateComputer")
public class UpdateComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(UpdateComputerServlet.class);
	private static final long serialVersionUID = 1L;
	@Autowired
	private ComputerDtoValidator computerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(computerValidator);
	}
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ComputerService computerService;
	@Autowired
	private ComputerMapper computerMapper;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComputerServlet() {
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
	public String doGet(@RequestParam("id") int id, ModelMap model) {
		// TODO Auto-generated method stub
		Computer comp=computerService.getOne(id);	
		model.addAttribute("computer", comp);
		return "addComputer";
	}

	
    @RequestMapping(method=RequestMethod.POST)
	public String doPost(@Valid @ModelAttribute("computer") ComputerDto cdto, 
			BindingResult result, ModelMap model) {
		// TODO Auto-generated method stub
		
		logger.debug(""+cdto);
		
		if (cdto.getId()==null || cdto.getName()==null || cdto.getIntroduced()==null
				|| cdto.getDiscontinued() ==null || cdto.getCompany()==null) {
			return "redirect:/AddComputer";
		}
		if (result.hasErrors()) {
			model.addAttribute("computer", cdto);
			return "addComputer";
		}else {
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
