package com.HR.Controller;
import java.util.List;


import com.HR.DTO.DepartmentProjection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.HR.entity.Department;
import com.HR.repository.DepartmentRepository;


@RestController
@Transactional
@CrossOrigin
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
 
	//TODO: Return all departments using Projection concept
	@GetMapping("departments")
	public List<DepartmentProjection> getDepartmentsProjection()
	{
		return departmentRepository.findBy();
	}

	//TODO: Save a new Department
	@PostMapping("departments")
	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentRepository.save(department);
	}

	//TODO: Find Department by id
	@GetMapping("departments/find/{departmentId}")
	public DepartmentProjection getDepartment(@PathVariable Integer departmentId)
	{
		DepartmentProjection department=departmentRepository.findByDepartmentId(departmentId);
		if(department==null)
			return null;
			//throw new DepartmentNotFound();
		return department;
	}

	//TODO: Delete a Department
	@DeleteMapping("departments/delete/{departmentId}")
	public String deleteDepartment(@PathVariable Integer departmentId)
	{
		Integer dept=departmentRepository.deleteByDepartmentId(departmentId);
		if(dept==1)
			return "OK";
		return "Nok_ok";
	}
	
	//TODO: Find department by name
	@GetMapping("departments/find/name/{departmentName}")
	public List<DepartmentProjection> getDepartmentByName(@PathVariable String departmentName)
	{
		List<DepartmentProjection> deptName=departmentRepository.findByDepartmentName(departmentName);
		if(deptName==null)
			return null;
			//throw new DepartmentNotFound();
		return deptName;
	}
	

}


