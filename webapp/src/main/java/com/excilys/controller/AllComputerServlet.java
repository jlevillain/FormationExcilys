package com.excilys.controller;

import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ListSortMapper;
import com.excilys.mapper.SortMapper;
import com.excilys.wrapper.PageWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.mapper.ComputerMapper;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public PageWrapper doGet(@RequestParam("start") int start, @RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("sort") String sort) throws IOException{
        List<Computer> computerList=null;
        Integer computerSize;
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("name",2);
        map.put("introduced",3);
        map.put("discontinued",4);
        map.put("company", 6);
        logger.info(sort);
        ListSortMapper sortMapper = new ObjectMapper().readValue("{\"sortMappers\":"+sort+"}", ListSortMapper.class);

        computerList=computerService.getAll("",page-1,limit,map.get(sortMapper.getSortMappers().get(0).getProperty()).intValue(),("ASC".equals(sortMapper.getSortMappers().get(0).getDirection()))?false:true);
        computerSize = computerService.getSize("");
        List<ComputerDto> computerDtoList=new ArrayList<ComputerDto>();
        for (Computer comp : computerList) {
            computerDtoList.add(computerMapper.convertComputerToDto(comp));
        }
        PageWrapper pageWrapper = new PageWrapper();
        pageWrapper.setComputers(computerDtoList);
        pageWrapper.setTotal(computerSize);
        return pageWrapper;

    }
}
