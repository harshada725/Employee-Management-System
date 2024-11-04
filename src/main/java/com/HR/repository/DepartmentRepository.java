package com.HR.repository;

import com.HR.DTO.DepartmentProjection;
import org.springframework.data.repository.CrudRepository;

import com.HR.entity.Department;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    List<DepartmentProjection> findBy();
	DepartmentProjection findByDepartmentId(Integer departmentId);
    int deleteByDepartmentId(Integer departmentId);
    List<DepartmentProjection> findByDepartmentName(String departmentName);
}
