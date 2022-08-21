package com.employee.register.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name="PDetails")
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int projectId;
private String project;
public ProjectDetails() 
{
	}
public ProjectDetails(String project) {
	super();
	this.project = project;
}
@Override
public String toString() {
	return "ProjectDetails [projectId=" + projectId + ", project=" + project + "]";
}
public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
public String getProject() {
	return project;
}
public void setProject(String project) {
	this.project = project;
}

}
