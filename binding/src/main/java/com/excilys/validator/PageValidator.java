package com.excilys.validator;

/**
 * class validating a page
 * @author jlevillain
 *
 */
public class PageValidator {
	/**
	 * validate search parameter
	 * @param search search parameter
	 * @return valid search 
	 */
	public static String validSearch(String search) {
		if (search==null) {
			return "";
		}
		return search;
	}
	
	/**
	 * validate the orderBy parameter
	 * @param orderBy orderBy parameter
	 * @return valid order by
	 */
	public static int validOrderBy(String orderBy) {
		if (orderBy==null)
			return 2;
		try {
			int number=Integer.parseInt(orderBy);
			if (1<=number && number<=6) {
				return number; 
			}
			return 2;
		}catch(NumberFormatException e) {
			return 2;
		}
	}
	
	/**
	 * validate the number of page
	 * @param nbPage number of page
	 * @return valid number of page
	 */
	public static int validNbPage(String nbPage) {
		if (nbPage==null) {
			return 10;
		}
		try {
			int number=Integer.parseInt(nbPage);
			if (number<1) {
				return 10;
			}
			return number; 
		}catch(NumberFormatException e) {
			return 10;
		}
	}
	
	/**
	 * validate isDesc parameter
	 * @param isDesc isDesc parameter
	 * @return valid isDesc
	 */
	public static boolean validIsDesc(String isDesc) {
		if ("true".equals(isDesc)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * validate the actual page
	 * @param page actual page 
	 * @return valid actual page
	 */
	public static int validPage(String page) {
		if (page==null) {
			return 1;
		}
		try {
			int number=Integer.parseInt(page);
			if (number<1) {
				return 1;
			}
			return number;
		}catch(NumberFormatException e) {
			return 1;
		}
	}
}
