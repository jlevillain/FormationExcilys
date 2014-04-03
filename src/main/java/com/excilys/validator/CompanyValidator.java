package com.excilys.validator;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.CompanyDao;
import com.excilys.dto.CompanyDto;

public class CompanyValidator {
	public static List<String> valide(CompanyDto company) {
		List<String> list=new ArrayList<String>();
		list.addAll(valideId(company.getId()));
		list.addAll(valideName(company.getName()));
		return list;
	}
	
	public static List<String> valideId(String id) {
		List<String> list=new ArrayList<String>();
		if(id.matches("[0-9]+")) {
			return list;
		}
		
		list.add("invalidCompanyId");
		return list;
		
		
	}
	
	public static List<String> valideName(String name) {
		List<String> list=new ArrayList<String>();
		if (name.matches(".+") ){
			return list;
		}
		
		list.add("invalidCompanyName");
		return list;
	}
}
