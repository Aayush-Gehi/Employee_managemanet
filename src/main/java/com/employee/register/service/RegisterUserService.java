package com.employee.register.service;

import com.employee.register.dao.IRegisterNewUser;
import com.employee.register.dao.RegisterNewUser;
/*
 * the class to check whether the details provided to the
 * dao layer are registered or not
 */
public class RegisterUserService implements IRegisterUserService {
	/*
	 *returns the status of user whether it is registered or not 
	 */
	@Override
	public boolean isRegistered(String username, String password, String project) {
		IRegisterNewUser user = new RegisterNewUser();
		return user.registerUser(username, password, project);
	}

}
