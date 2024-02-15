package com.ki.pma.dto;

public interface EmployeeProject {

	//  Property names must begin with 'get', it's how Spring knows that this data transfer object is used to handle data coming from our custom query specified in EmployeeRepository 
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();
	
}