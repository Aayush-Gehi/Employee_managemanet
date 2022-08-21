package com.employee.update.service;

import com.employee.update.dao.IUpdateUserDAO;
import com.employee.update.dao.UpdateUserDAO;
/*
 * the class will check whether the details provided to the
 * dao layer are updated or not 
 */
public class UpdateUserService implements IUpdateUserService {
	/*
	 *returns the status of user whether it is updated or not 
	 */
	@Override
	public boolean isUserUpdated(int userId, String newUsername, String newProjects) {
		IUpdateUserDAO user = new UpdateUserDAO();
		return user.isUserUpdated(userId, newUsername, newProjects);
	}

}
