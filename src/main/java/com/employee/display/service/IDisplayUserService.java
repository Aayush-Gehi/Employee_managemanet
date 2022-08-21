package com.employee.display.service;

import java.util.List;
import java.util.Map;
/*
 * @author Aayush Gehi
 * The user of this interface will have control on the displaying  users and their projects associated 
 */
public interface IDisplayUserService {
	/*
	 * Returns the list of users and their projects associated in dictionary format with
	 * users as key and projects as value
	 */
public Map<String, List<String>> displayUser(); 
}
