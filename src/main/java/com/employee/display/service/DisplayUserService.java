package com.employee.display.service;

import java.util.List;
import java.util.Map;

import com.employee.display.dao.DisplayUserDAO;
import com.employee.display.dao.IDisplayUserDAO;
/*
 * @author Aayush Gehi
 * A class used by the user to display all the users present in the database with the detial's of the projects they are involved */

public class DisplayUserService implements IDisplayUserService {
	/*
	 * Returns the list of users and their projects associated in dictionary format with
	 * users as key and projects as value
	 */
	@Override
	public Map<String, List<String>> displayUser() {
		IDisplayUserDAO displayUser = new DisplayUserDAO();
		return displayUser.displayUser();
	}

}
