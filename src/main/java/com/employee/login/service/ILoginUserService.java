package com.employee.login.service;
/*
 * the user of this interface will have the privilege to check whether the details provided to the
 * dao layer are valid for login or not
 */
public interface ILoginUserService {
	/*
	 *returns the status of user whether it is eligible for login or not 
	 */
public boolean isLoggedIn(String username,String password);
}
