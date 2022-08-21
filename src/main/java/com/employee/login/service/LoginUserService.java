package com.employee.login.service;
/*
 * the user of this interface will have the privilege to check whether the details provided to the
 * dao layer are valid for login or not
 */
import com.employee.login.dao.ILoginUserDAO;
import com.employee.login.dao.LoginUserDAO;

public class LoginUserService implements ILoginUserService {
	
	/*
	 *returns the status of user whether it is elegible for login or not 
	 */
	@Override
	public boolean isLoggedIn(String username, String password) {
		ILoginUserDAO user = new LoginUserDAO();
		return user.isValidUser(username, password);
	}

}
