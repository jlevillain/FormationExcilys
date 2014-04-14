package com.excilys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerDtoValidator;
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
	private ComputerDtoValidator computerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(computerValidator);
	}
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
   /*
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new ComputerValidator());
    }
*/
    
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
	public String doPost(@Valid @ModelAttribute("computer") ComputerDto cdto,
			BindingResult result, ModelMap model) {
		// TODO Auto-generated method stub
		logger.debug(""+cdto);
		
		if (cdto.getName()==null || cdto.getIntroduced()==null
				|| cdto.getDiscontinued() ==null || cdto.getCompany()==null) {
			return "redirect:/AddComputer";
		}

		//List<String> error=ComputerValidator.valide(cdto);
		//model.addAttribute("error", error);
		if (result.hasErrors()) {
			model.addAttribute("computer", cdto);
			return "addComputer";
		}else {
		//if ( error.size()==0 ) {
			Computer comp=computerMapper.convertDtoToComputer(cdto);
			if (comp!=null) {
				logger.debug(comp.toString());
				computerService.insertOne(comp);
				return "redirect:/";
			}
		}
		//}
		return "addComputer";
		
		
		
	}
	
}
