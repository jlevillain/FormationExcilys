package com.excilys.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class containing the log of database
 * 
 * @author jlevillain
 *
 *
 */
@Entity
@Table(name="log_table")
public class Log {
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue
	long id=0;;
	@Column(name="request",nullable=false)
	String request=null;
	
	/**
	 * get the id of Log
	 * 
	 * @return id of Log
	 */
	public long getId() {
		return id;
	}
	/**
	 * set the id of log
	 * 
	 * @param id id of log
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * get the request
	 * 
	 * @return request the request
	 */
	public String getRequest() {
		return request;
	}
	
	/**
	 * set the request
	 * 
	 * @param request the request
	 */
	public void setRequest(String request) {
		this.request = request;
	}
	
	
	/**
	 * builder of Log
	 * 
	 * @author jlevillain
	 *
	 */
	public static class Builder {
		Log log;
		/**
		 * constructor of builder
		 */
		private Builder()  {
			log=new Log();
		}
		
		/**
		 * set the id of log
		 * @param id id of log
		 * @return builder of log
		 */
		public Builder id(long id) {
			this.log.setId(id);
			return this;
		}
		/**
		 * set the request of log
		 * @param request request of log
		 * @return builder of log
		 */
		public Builder request(String request) {
			this.log.setRequest(request);
			return this;
		}
		
		/**
		 * construct the log object
		 * @return log 
		 */
		public Log build() {
			return log;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Log))
			return false;
		Log other = (Log) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/**
	 * get the builder of Log
	 * 
	 * @return the builder of Log
	 */
	public static Builder build() {
		return new Builder();
	}
}
