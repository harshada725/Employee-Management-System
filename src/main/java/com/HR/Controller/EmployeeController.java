package com.HR.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.HR.DTO.DepartmentDTO;
import com.HR.DTO.EmployeeDTO;
import com.HR.DTO.EmployeeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.HR.entity.Employee;
import com.HR.repository.EmployeePaginRepository;
import com.HR.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import responseType.QueryStatus;


@RestController
@Transactional
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeePaginRepository employeePaginRepository;

	//TODO:Return all Employees using Projection concept
	@GetMapping("employee")
	public List<EmployeeProjection> getEmployeesProjection()
	{
		return employeeRepository.findBy();
	}


	//TODO:Save Employee details
	@PostMapping("employee")
	public EmployeeDTO saveEmployee(@RequestBody Employee employee)
	{
		Employee realEmployee=employeeRepository.save(employee);

		EmployeeDTO employeeDTO=new EmployeeDTO(realEmployee.getEmployeeId(),realEmployee.getEmployeeName(),
				realEmployee.getEmployeeSalary(),realEmployee.getEmployeeEmail(),realEmployee.getPassword(),
				realEmployee.getSkillSet(),new DepartmentDTO(realEmployee.getDepartment().getDepartmentId()));
		return employeeDTO;
	}

	
	//TODO:Search Employee by Id
	@GetMapping("employee/find/{employeeId}")
	public EmployeeProjection getEmployeeByEmployeeId(@PathVariable Integer employeeId)
	{
		EmployeeProjection employee=employeeRepository.findByEmployeeId(employeeId);
		if(employee ==null)
			//throw new EmployeeNotFound();
			return null;
		return employee;
	}
	
	//TODO:Delete Employee by Id
	@DeleteMapping("employee/delete/{employeeId}")
	public QueryStatus deleteEmployeeByEmployeeId(@PathVariable Integer employeeId)
	{
		Integer deleteEmp=employeeRepository.deleteByEmployeeId(employeeId);
		if(deleteEmp==1)
		   return new QueryStatus (true);
		return new QueryStatus(false); 
		
	}
	
	//TODO:Find employee by name
	@GetMapping("employee/find/name/{employeeName}")
	public List<EmployeeProjection> getEmployeeByEmployeeName(@PathVariable String employeeName)
	{
		List<EmployeeProjection> empName=employeeRepository.findByEmployeeName(employeeName);
		if(empName==null)
		return null;
		return empName;
		
	}
	
	//TODO:Find employee by SkillSet
	@GetMapping("employee/find/skillset/{skillSet}")
	public List<EmployeeProjection> getEmployeeByskillSet(@PathVariable String skillSet)
	{
		List<EmployeeProjection> empSkillSet=employeeRepository.findBySkillSet(skillSet);
		if(empSkillSet==null)
		return null;
		return empSkillSet;
	}
	
	//TODO:Login by email and password
	@PostMapping("employee/login")
	public ResponseEntity<EmployeeProjection> login(@RequestBody Employee employee) {
	    System.out.println("Login request received");

	    // Find employee by email and password
	    EmployeeProjection emp = employeeRepository.findByEmployeeEmailAndPassword(
	            employee.getEmployeeEmail(), employee.getPassword());

	    //employee is not found, return 404 Not Found
	    if (emp == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	    // If employee is found, return 200 OK with employee details
	    return ResponseEntity.ok(emp);
	}

	
	//TODO:Update employee by Id
	@PostMapping("employee/update/{employeeId}")
	public EmployeeDTO updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) 
	{
	    Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);

	    if (existingEmployee != null) {
	        // Update the existing employee's details with the new data
	        existingEmployee.setEmployeeName(employee.getEmployeeName());
	        existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
	        existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
	        existingEmployee.setSkillSet(employee.getSkillSet());
	        existingEmployee.setPassword(employee.getPassword());
	        existingEmployee.setDepartment(employee.getDepartment());

	        Employee updatedEmployee = employeeRepository.save(existingEmployee);
	        EmployeeDTO employeeDTO = new EmployeeDTO(updatedEmployee.getEmployeeId(), updatedEmployee.getEmployeeName(),
	                updatedEmployee.getEmployeeSalary(), updatedEmployee.getEmployeeEmail(), updatedEmployee.getPassword(),
	                updatedEmployee.getSkillSet(), new DepartmentDTO(updatedEmployee.getDepartment().getDepartmentId()));
	        return employeeDTO;
	    }

	    return null; 
	}
	

	@GetMapping("employee/paginate/{pageNo}")
	public ResponseEntity<List<EmployeeProjection>> paginateEmployees(@PathVariable Integer pageNo,
			@RequestParam(defaultValue = "7") Integer pageSize)
		{
	        Pageable pageable = PageRequest.of(pageNo, pageSize);
	        Page<EmployeeProjection> pageResult = employeePaginRepository.findAllBy(pageable);
	        
	        // Return paginated content with status OK
	        Map<String, Object> response = new HashMap<>();
	        response.put("employees", pageResult.getContent());
	        response.put("totalPages", pageResult.getTotalPages());
	        return new ResponseEntity<>(pageResult.getContent(), HttpStatus.OK);
	    }
  
}

