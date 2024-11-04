package com.HR.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.HR.DTO.EmployeeProjection;
import com.HR.entity.Employee;

public interface EmployeePaginRepository extends PagingAndSortingRepository<Employee, Integer> {

	 Page<EmployeeProjection> findAllBy(Pageable pageable);
}
