package org.dxc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	
//	@ManyToMany(mappedBy = "projects")
//     private Set<Employee> employees = new HashSet<Employee>();;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
//	public Set<Employee> getEmployees() {
//		return employees;
//	}
//	public void setEmployees(Set<Employee> employees) {
//		this.employees = employees;
//	}
	
	

}
