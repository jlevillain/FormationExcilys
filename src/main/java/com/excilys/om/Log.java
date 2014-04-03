package com.excilys.om;

import com.excilys.wrapper.Page.Builder;

public class Log {
	long id=0;;
	String request=null;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	public static class Builder {
		Log log;
		private Builder()  {
			log=new Log();
		}
		
		public Builder id(long id) {
			this.log.setId(id);
			return this;
		}
		
		public Builder request(String request) {
			this.log.setRequest(request);
			return this;
		}
		
		public Log build() {
			return log;
		}
	}
	
	public static Builder build() {
		return new Builder();
	}
}
