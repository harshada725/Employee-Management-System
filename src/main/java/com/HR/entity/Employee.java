package com.HR.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String employeeName;
	private Float employeeSalary;
	private String employeeEmail;
	private String password;
	private String skillSet;
	
	@ManyToOne()
	@JoinColumn(name="departmentId",nullable=false)
	private Department department;

	public Employee() {
	}

	public Employee(Integer employeeId, String employeeName,
					Float employeeSalary, String employeeEmail, String password, String skillSet) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeEmail = employeeEmail;
		this.password = password;
		this.skillSet = skillSet;
		//this.department = department;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", employeeName='" + employeeName + '\'' +
				", employeeSalary=" + employeeSalary +
				", employeeEmail='" + employeeEmail + '\'' +
				", password='" + password + '\'' +
				", skillSet='" + skillSet + '\'' +
				", department=" + department +
				'}';
	}
}
