package com.employee.register.service;
/*
 * the user of this interface will have the privilege to check whether the details provided to the
 * dao layer are registered or not
 */
public interface IRegisterUserService {
	/*
	 *returns the status of user whether it is registered or not 
	 */
public boolean isRegistered(String username , String password , String project);
}
