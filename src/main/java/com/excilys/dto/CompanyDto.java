package com.excilys.dto;

public class CompanyDto {
	String id;
	String name;
	/**
	 * Default constructor of company
	 */
	public CompanyDto() {
		id=null;
		name=null;
	}
	
	/**
	 * get the id of company
	 * @return id of company
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the company of id
	 * @param id id of company
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get the name of company
	 * @return name of company
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of company
	 * @param name name of company
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * builder of company
	 * @author jlevillain
	 *
	 */
	public static class Builder{
		CompanyDto companyDto;
		/**
		 * builder of company
		 */
		private Builder() {
			companyDto=new CompanyDto();
		}
		/**
		 * set the id of company
		 * @param id id of company
		 * @return builder of company
		 */
		public Builder id(String id) {
			companyDto.setId(id);
			return this;
		}
		/**
		 * set the name of company
		 * @param name name of company
		 * @return builder of company
		 */
		public Builder name(String name) {
			companyDto.setName(name);
			return this;
		}
		/**
		 * construct the company object
		 * @return company object
		 */
		public CompanyDto build() {
			return companyDto;
		}
	}
	/**
	 * get the builder of company
	 * @return builder of company
	 */
	public static Builder build() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + "]";
	}
	
}
