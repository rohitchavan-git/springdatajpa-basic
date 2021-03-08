package com.rohit.sbb.pojo;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeePojo {

	String getFname();
	
	String getLname();
	@Value("#{target.address?.state}")
	String getState();
}
