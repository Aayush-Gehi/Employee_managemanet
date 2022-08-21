package com.employee.update.service;
/*
 * the user of this interface will have the privilege to check whether the details provided to the
 * dao layer are updated or not 
 */
public interface IUpdateUserService {
	/*
	 *returns the status of user whether it is updated or not 
	 */
public boolean isUserUpdated(int userId , String newUsername , String newProjects);
}
