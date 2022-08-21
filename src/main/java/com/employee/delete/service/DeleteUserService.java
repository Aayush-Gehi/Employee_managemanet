package com.employee.delete.service;

import com.employee.delete.dao.DeleteUserDAO;
import com.employee.delete.dao.IDeleteUserDAO;
/*
 * the class to check whether the details provided to the
 * dao layer are deleted or not
 */
public class DeleteUserService implements IDeleteUserService {
    
	/*
	 *returns the status of user whether it is deleted or not 
	 */
	@Override
	public boolean isDeleted( String username) {
		IDeleteUserDAO user = new DeleteUserDAO();
		return user.isDeleted( username);
	}

}
