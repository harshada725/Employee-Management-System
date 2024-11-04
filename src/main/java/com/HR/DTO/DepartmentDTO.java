package com.HR.DTO;

import java.util.List;

public class DepartmentDTO {
    private Integer departmentId;


    private List<EmployeeDTO> employees;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Integer departmentId,  List<EmployeeDTO> employees) {
        this.departmentId = departmentId;
        this.employees = employees;
    }

    public DepartmentDTO(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentId=" + departmentId +
                ", employees=" + employees +
                '}';
    }
}
