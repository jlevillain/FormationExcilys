package com.excilys.dto;

public class CompanyDto {
	String id;
	String name;
	public CompanyDto() {
		id=null;
		name=null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static class Builder{
		CompanyDto companyDto;
		private Builder() {
			companyDto=new CompanyDto();
		}
		
		public Builder id(String id) {
			companyDto.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			companyDto.setName(name);
			return this;
		}
		
		public CompanyDto build() {
			return companyDto;
		}
	}
	
	public static Builder build() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + "]";
	}
	
}
