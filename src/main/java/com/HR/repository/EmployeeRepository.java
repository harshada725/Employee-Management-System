package com.HR.repository;

import java.util.List;

import com.HR.DTO.EmployeeProjection;
import org.springframework.data.repository.CrudRepository;
import com.HR.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{
	Integer deleteByEmployeeId(Integer employeeId);
	List<EmployeeProjection> findByEmployeeName(String employeeName);
	List<EmployeeProjection> findBySkillSet(String skillSet);
	List<EmployeeProjection> findBy();
	EmployeeProjection findByEmployeeId(Integer employeeId);
    EmployeeProjection findByEmployeeEmailAndPassword(String employeeEmail, String password);
}
