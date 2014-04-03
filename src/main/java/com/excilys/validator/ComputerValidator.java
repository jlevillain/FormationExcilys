package com.excilys.validator;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;

public class ComputerValidator {
	
	public static List<String> valide(ComputerDto computer) {
		List<String> list=new ArrayList<String>();
		list.addAll(valideId(computer.getId()));
		list.addAll(valideName(computer.getName()));
		list.addAll(valideIntroduced(computer.getIntroduced()));
		list.addAll(valideDiscontinued(computer.getDiscontinued()));
		list.addAll(valideCompany(computer.getCompany()));
		return list;
		
	}
	
	public static List<String> valideId(String id) {
		List<String> list=new ArrayList<String>();
		if (id.matches("[0-9]+")){
			return list;
		}
		
		list.add("invalidComputerId");
		return list;
	}
	
	public static List<String> valideName(String name) {
		List<String> list=new ArrayList<String>();
		if (name.matches(".+")) {
			return list;
		}
		
		list.add("invalidComputerName");
		return list;
	}
	
	public static List<String> valideIntroduced(String introduced) {
		List<String> list=new ArrayList<String>();
		if (introduced.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$") || "".equals(introduced)) {
			return list;
		}
		
		list.add("invalidComputerIntroduced");
		return list;
		
	}
	
	public static List<String> valideDiscontinued(String discontinued) {
		List<String> list=new ArrayList<String>();
		if (discontinued.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$") || "".equals(discontinued)) {
			return list;
		}
		list.add("invalidComputerDiscontinued");
		return list;
		
	}
	
	public static List<String> valideCompany(CompanyDto company) {
		return CompanyValidator.valide(company);
	}
}
