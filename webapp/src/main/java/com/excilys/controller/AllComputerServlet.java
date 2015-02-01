package com.excilys.controller;

import com.excilys.dto.ComputerDto;
import com.excilys.mapper.*;
import com.excilys.wrapper.PageWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import sun.org.mozilla.javascript.json.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.validation.Valid;

/**
 * Created by eron on 17/01/15.
 */
@Controller
@RequestMapping("/AllComputer")
public class AllComputerServlet {
    Logger logger = LoggerFactory.getLogger(AllComputerServlet.class);
    @Autowired
	ApplicationContext context;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ComputerService computerService;
    @Autowired
    private ComputerMapper computerMapper;

    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PageWrapper doGet(@RequestParam("start") int start, @RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam(value = "sort") String sort, @RequestParam(value="filter", required=false) String filter) throws IOException{
        List<Computer> computerList=null;
        Integer computerSize;
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("name",2);
        map.put("introduced",3);
        map.put("discontinued",4);
        map.put("company", 6);
        logger.info(sort);
        ListSortMapper sortMapper = new ObjectMapper().readValue("{\"sortMappers\":"+sort+"}", ListSortMapper.class);
        logger.info(filter);
        ListFilterMapper filterMapper = new ObjectMapper().readValue("{\"filterMappers\":"+filter+"}",ListFilterMapper.class);

        String company="";
        String computer="";
        for(int i=0;filterMapper.getFilterMappers()!=null&&i<filterMapper.getFilterMappers().size();i++) {
            FilterMapper fm = filterMapper.getFilterMappers().get(i);
            if("company".equals(fm.getProperty())) {
                company = fm.getValue();
            }
            if("name".equals(fm.getProperty())) {
                computer = fm.getValue();
            }
        }
        logger.info(computer+"#"+company);
        if("".equals(company) || company==null) {
            computerList = computerService.getAll(computer, page - 1, limit, map.get(sortMapper.getSortMappers().get(0).getProperty()).intValue(), ("ASC".equals(sortMapper.getSortMappers().get(0).getDirection())) ? false : true);
            computerSize = computerService.getSize(computer);
        }else {
            computerList = computerService.getAll(computer, company, page - 1, limit, map.get(sortMapper.getSortMappers().get(0).getProperty()).intValue(), ("ASC".equals(sortMapper.getSortMappers().get(0).getDirection())) ? false : true);
            computerSize = computerService.getSize(computer, company);
        }
        List<ComputerDto> computerDtoList=new ArrayList<ComputerDto>();
        for (Computer comp : computerList) {
            computerDtoList.add(computerMapper.convertComputerToDto(comp));
        }
        PageWrapper pageWrapper = new PageWrapper();
        pageWrapper.setComputers(computerDtoList);
        pageWrapper.setTotal(computerSize);
        return pageWrapper;
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public String doPost(@RequestBody ComputerDto cdto)throws DataAccessException {
        // TODO Auto-generated method stub
        logger.debug(""+cdto);

        if (cdto.getName()==null || cdto.getCompany()==null) {
            return "";
        }

        //List<String> error=ComputerValidator.valide(cdto);
        //model.addAttribute("error", error);
        Computer comp=computerMapper.convertDtoToComputer(cdto);
        if (comp!=null) {
            logger.debug(comp.toString());
            computerService.insertOne(comp);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody ComputerDto cdto)throws DataAccessException {
        // TODO Auto-generated method stub
        logger.debug(""+cdto);

        if (cdto.getName()==null || cdto.getCompany()==null) {
            return "";
        }

        //List<String> error=ComputerValidator.valide(cdto);
        //model.addAttribute("error", error);
        Computer comp=computerMapper.convertDtoToComputer(cdto);
        if (comp!=null) {
            logger.debug(comp.toString());
            computerService.updateOne(comp);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PageWrapper getComputer(@PathVariable int id) {
        if(id>0) {
            Computer computer = computerService.getOne(id);
            ComputerDto computerDto = computerMapper.convertComputerToDto(computer);
            //return computerDto;
            PageWrapper pageWrapper = new PageWrapper();
            List<ComputerDto> computerDtoList=new ArrayList<ComputerDto>();
            computerDtoList.add(computerDto);
            pageWrapper.setComputers(computerDtoList);
            pageWrapper.setTotal(1);
            return pageWrapper;
        }
        return null;
    }
}
