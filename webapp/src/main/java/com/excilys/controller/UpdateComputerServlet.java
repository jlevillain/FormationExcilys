package com.excilys.controller;

import java.util.List;

import javax.servlet.*;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.excilys.dto.ComputerDto;
import com.excilys.exception.SQLRuntimeException;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerDtoValidator;

/**
 * Servlet implementation class UpdateComputerServlet
 */
@Controller
@RequestMapping("/UpdateComputer")
public class UpdateComputerServlet {
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
    /**
     * get the list of company
     * @return list of company
     */
    @ModelAttribute("companyList")
    List<Company> populateComputerList() {
    	List<Company> companyList=companyService.getAll();
		return companyList;
    }
    
    
    /**
     * method doGet of the controller
     * @param id id of the computer
     * @param model model 
     * @return page
     */
    @RequestMapping(method=RequestMethod.GET)
	public String doGet(@RequestParam(value="id",required=false) Integer id, ModelMap model) {
		// TODO Auto-generated method stub
    	
    	if (id==null) {
    		return "redirect:/";
    	}
		Computer comp=computerService.getOne(id);	
		model.addAttribute("computer", computerMapper.convertComputerToDto(comp));
		return "addComputer";
	}
   
	/**
	 * method doGet of the controller
	 * @param cdto computer to update
	 * @param result result
	 * @param model model
	 * @return page
	 */
    @RequestMapping(method=RequestMethod.POST)
	public String doPost(@Valid @ModelAttribute("computer") ComputerDto cdto, 
			BindingResult result, ModelMap model) throws SQLRuntimeException{
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
				computerService.updateOne(comp);
				return "redirect:/";
			}
		}
		return "addComputer";
	}

}
