package com.excilys.validator;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dto.CompanyDto;


/**
 * class validating a company
 * @author jlevilain
 *
 */
public class CompanyValidator {
	/**
	 * validate a company
	 * @param company company to validate
	 * @return list of error
	 */
	public static List<String> valide(CompanyDto company) {
		List<String> list=new ArrayList<String>();
		list.addAll(valideId(company.getId()));
		list.addAll(valideName(company.getName()));
		return list;
	}
	/**
	 * validate the id of company
	 * @param id id of company
	 * @return list of error
	 */
	public static List<String> valideId(String id) {
		List<String> list=new ArrayList<String>();
		if(id.matches("[0-9]+")) {
			return list;
		}
		
		list.add("invalidCompanyId");
		return list;
		
		
	}
	/**
	 * validate the name of company
	 * @param name name of company
	 * @return list of error
	 */
	public static List<String> valideName(String name) {
		List<String> list=new ArrayList<String>();
		if (name.matches(".+") ){
			return list;
		}
		
		list.add("invalidCompanyName");
		return list;
	}
}
