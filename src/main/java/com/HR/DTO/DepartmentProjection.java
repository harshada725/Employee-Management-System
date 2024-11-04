package com.HR.DTO;

import java.util.List;

public interface DepartmentProjection {
    public Integer getDepartmentId();
    public String getDepartmentName();
    public List<Employee> getEmployees();

    interface Employee
    {
        public Integer getEmployeeId();
        public String getEmployeeName();
        public Float getEmployeeSalary();
        public String getEmployeeEmail();
        public String getPassword();
        public String getSkillSet();
    }
}
