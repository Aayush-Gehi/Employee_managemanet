package com.employee.delete.service;
/*
 * the user of this interface will have the privilege to check whether the details provided to the
 * dao layer are deleted or not
 */
public interface IDeleteUserService {
	/*
	 *returns the status of user whether it is deleted or not
	 */
public boolean isDeleted(String username);
}
