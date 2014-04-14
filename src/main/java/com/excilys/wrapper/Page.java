package com.excilys.wrapper;

import java.util.List;

import com.excilys.dto.ComputerDto;
import com.excilys.om.Computer;

public class Page {
	private int page=1;
	private int interval=5;
	private boolean desc=false;
	private String search="";
	private List<ComputerDto> computerList;
	private int computerSize;
	private int orderBy=2;
	private int nbPage=10;
	
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	
	public void setOrderBy(String str) {
		if (str!=null) {
			try {
				orderBy = Integer.parseInt(str);
			}catch (NumberFormatException e) {
				
			}
		}
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public boolean isDesc() {
		return desc;
	}
	public void setDesc(boolean isDesc) {
		this.desc = isDesc;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public List<ComputerDto> getComputerList() {
		return computerList;
	}
	public void setComputerList(List<ComputerDto> computerList) {
		this.computerList = computerList;
	}
	public int getComputerSize() {
		return computerSize;
	}
	public void setComputerSize(int computerSize) {
		this.computerSize = computerSize;
	}
	
	public static class Builder {
		Page page;
		private Builder() {
			page=new Page();
		}
		public Builder page(int page) {
			this.page.setPage(page);
			return this;
		}
		
		public  Builder search(String search) {
			this.page.setSearch(search);
			return this;
		}
		
		public Builder computerList(List<ComputerDto> computerList) {
			this.page.setComputerList(computerList);
			return this;
		}
		
		public Builder computerSize(int computerSize) {
			this.page.setComputerSize(computerSize);
			return this;
		}
		
		public Builder interval(int interval) {
			this.page.setInterval(interval);
			return this;
		}
		
		public Builder isDesc(boolean isDesc) {
			this.page.setDesc(isDesc);
			return this;
		}
		public Builder orderBy(int orderBy) {
			this.page.setOrderBy(orderBy);
			return this;
		}
		public Builder nbPage(int nbPage) {
			this.page.setNbPage(nbPage);
			return this;
		}
		public Page build() {
			return page;
		}
	}
	
	public static Builder build() {
		return new Builder();
	}
	
}
