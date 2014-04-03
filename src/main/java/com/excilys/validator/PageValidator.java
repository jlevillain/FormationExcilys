package com.excilys.validator;

public class PageValidator {
	public static String validSearch(String search) {
		if (search==null) {
			return "";
		}
		return search;
	}
	
	public static int validOrderBy(String orderBy) {
		if (orderBy==null)
			return 2;
		try {
			return Integer.parseInt(orderBy);
		}catch(NumberFormatException e) {
			return 2;
		}
	}
	
	public static int validNbPage(String nbPage) {
		if (nbPage==null) {
			return 10;
		}
		try {
			return Integer.parseInt(nbPage);
		}catch(NumberFormatException e) {
			return 10;
		}
	}
	
	public static boolean validIsDesc(String isDesc) {
		if ("true".equals(isDesc)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int validPage(String page) {
		if (page==null) {
			return 1;
		}
		try {
			return Integer.parseInt(page);
		}catch(NumberFormatException e) {
			return 1;
		}
	}
}
