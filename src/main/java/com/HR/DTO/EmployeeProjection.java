package com.HR.DTO;



public interface EmployeeProjection {
    public Integer getEmployeeId();
    public String getEmployeeName();
    public Float getEmployeeSalary();
    public String getEmployeeEmail();
    public String getPassword();
    public String getSkillSet();
    public Department getDepartment();

    interface Department
    {
        public Integer getDepartmentId();
        public String getDepartmentName();
    }
}
