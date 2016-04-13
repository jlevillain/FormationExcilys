package com.excilys.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.excilys.dto.ComputerDto;
import com.excilys.om.Computer;
/**
 * class wrapping a page
 * @author excilys
 *
 */
@XmlRootElement(name="page")
public class Page {
	private int page=1;
	private int interval=5;
	private boolean desc=false;
	private String search="";
	private List<ComputerDto> computerList;
	private int computerSize;
	private int orderBy=2;
	private int nbPage=10;
	/**
	 * get the number of page
	 * @return number of page
	 */
	public int getNbPage() {
		return nbPage;
	}
	/**
	 * set the number of page
	 * @param nbPage number of page
	 */
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	/**
	 * get the orderBy
	 * @return orderBy
	 */
	public int getOrderBy() {
		return orderBy;
	}
	/**
	 * set the order by
	 * @param orderBy orderBy to set
	 */
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * set the order by
	 * @param str orderBy to set
	 */
	public void setOrderBy(String str) {
		if (str!=null) {
			try {
				orderBy = Integer.parseInt(str);
			}catch (NumberFormatException e) {
				
			}
		}
	}
	/**
	 * get the actual page
	 * @return actual page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * set the actual page
	 * @param page actual page
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * get the interval
	 * @return interval
	 */
	public int getInterval() {
		return interval;
	}
	/**
	 * set the interval 
	 * @param interval interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}
	/**
	 * get the isDesc
	 * @return the isDesc
	 */
	public boolean isDesc() {
		return desc;
	}
	/**
	 * set the isDesc
	 * @param isDesc isDesc to set
	 */
	public void setDesc(boolean isDesc) {
		this.desc = isDesc;
	}
	/**
	 * get the search parameter
	 * @return search parameter
	 */
	public String getSearch() {
		return search;
	}
	/**
	 * set the search parameter
	 * @param search search parameter to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}
	/**
	 * get the list of computer 
	 * @return list of computer
	 */
	public List<ComputerDto> getComputerList() {
		return computerList;
	}
	/**
	 * set the list of computer
	 * @param computerList list of computer
	 */
	public void setComputerList(List<ComputerDto> computerList) {
		this.computerList = computerList;
	}
	/**
	 * get computer size
	 * @return computerSize
	 */
	public int getComputerSize() {
		return computerSize;
	}
	/**
	 * set computer size
	 * @param computerSize computer size to set
	 */
	public void setComputerSize(int computerSize) {
		this.computerSize = computerSize;
	}
	/**
	 * builder of page
	 * @author jlevillain
	 *
	 */
	public static class Builder {
		Page page;
		/**
		 * constructor of builder
		 */
		private Builder() {
			page=new Page();
		}
		/**
		 * set the actual page of page
		 * @param page actual page
		 * @return builder of page
		 */
		public Builder page(int page) {
			this.page.setPage(page);
			return this;
		}
		/**
		 * set the search parameter of page
		 * @param search search parameter of page
		 * @return builder of page
		 */
		public  Builder search(String search) {
			this.page.setSearch(search);
			return this;
		}
		/**
		 * set the computer list of page
		 * @param computerList computer list of page
		 * @return builder of page
		 */
		public Builder computerList(List<ComputerDto> computerList) {
			this.page.setComputerList(computerList);
			return this;
		}
		/**
		 * set the computer size of page
		 * @param computerSize computer size of page
		 * @return builder of page
		 */
		public Builder computerSize(int computerSize) {
			this.page.setComputerSize(computerSize);
			return this;
		}
		/**
		 * set the interval of page
		 * @param interval interval of page
		 * @return builder of page
		 */
		public Builder interval(int interval) {
			this.page.setInterval(interval);
			return this;
		}
		/**
		 * set the isDesc parameter of page
		 * @param isDesc isDesc parameter of page
		 * @return builder of page
		 */
		public Builder isDesc(boolean isDesc) {
			this.page.setDesc(isDesc);
			return this;
		}
		/**
		 * set the orderBy parameter of page
		 * @param orderBy orderBy parameter of page
		 * @return builder of page
		 */
		public Builder orderBy(int orderBy) {
			this.page.setOrderBy(orderBy);
			return this;
		}
		/**
		 * set the number of page 
		 * @param nbPage number of page
		 * @return builder of page
		 */
		public Builder nbPage(int nbPage) {
			this.page.setNbPage(nbPage);
			return this;
		}
		/**
		 * construct a page object
		 * @return page object
		 */
		public Page build() {
			return page;
		}
	}
	/**
	 * get builder of page
	 * @return builder of page
	 */
	public static Builder build() {
		return new Builder();
	}
	
}
