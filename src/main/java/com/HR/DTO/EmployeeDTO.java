package com.HR.DTO;



public class EmployeeDTO {
    private Integer employeeId;
    private String employeeName;
    private Float employeeSalary;
    private String employeeEmail;
    private String password;
    private String skillSet;

    private DepartmentDTO department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer employeeId, String employeeName,
                       Float employeeSalary, String employeeEmail, String password,
                       String skillSet, DepartmentDTO department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.password = password;
        this.skillSet = skillSet;
        this.department = department;
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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
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
