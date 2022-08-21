package com.employee.register.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="UDetails")
public class RegisterUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
private String username;
private String password;
@OneToMany(cascade = {CascadeType.ALL})
List <ProjectDetails> projects = new ArrayList<>();
public RegisterUser() 
{}
@Override
public String toString() {
	return "RegisterUser [Id=" + userId + ", username=" + username + ", password=" + password + ", projects=" + projects
			+ "]";
}
public RegisterUser( String username, String password) {
	super();

	this.username = username;
	this.password = password;
}
public int getId() {
	return userId;
}
public void setId(int id) {
	userId = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<ProjectDetails> getProjects() {
	return projects;
}
public void setProjects(List<ProjectDetails> projects) {
	this.projects = projects;
}

}
