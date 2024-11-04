import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from '../model/employee';

@Pipe({
  name: 'employeeSearch'
})
export class EmployeeSearchPipe implements PipeTransform {

  transform(employees: Employee[], searchTerm: string): Employee[] {
    if (!employees || !searchTerm) {
      return employees;
    }
    searchTerm = searchTerm.toLowerCase();
    return employees.filter(employee => 
      
      employee.employeeName.toLowerCase().includes(searchTerm) ||
      employee.employeeEmail.toLowerCase().includes(searchTerm) ||
      employee.skillSet.toLowerCase().includes(searchTerm)||
      employee.employeeId.toString().toLowerCase().includes(searchTerm) ||  // Search by Employee ID
      employee.employeeSalary.toString().toLowerCase().includes(searchTerm) ||  // Search by Salary
      employee.department.departmentId.toString().toLowerCase().includes(searchTerm)  // Search by Department ID
      
    );
  }
}
