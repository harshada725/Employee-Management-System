import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { Department } from '../model/department';
import { User } from '../user';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class CurdService {

  employees:Employee[]

  departments:Department[]

  loginSuccessfull:boolean
  employeeAddSuccess:boolean
  employeeAddError:boolean
  employeeUpdated:boolean
  employeeDeleted:boolean
  departmentAdded:boolean
  

  constructor(public http:HttpClient) { 
    this.employees=[],
    this.departments=[],
    this.employeeAddSuccess=false,
    this.employeeAddError=false,
    this.loginSuccessfull=false,
    this.employeeUpdated=false,
    this.employeeDeleted=false,
    this.departmentAdded=false
  }
  getEmployees()
  {
    this.http.get<Employee[]>('http://localhost:8080/employee').subscribe(data => this.employees=data)
  }
  getDepartments()
  {
    this.http.get<Department[]>('http://localhost:8080/departments').subscribe(data => this.departments=data)
  }

  loginSuccess(user: User) 
  {
  this.loginSuccessfull = false;

  this.http.post<Employee>('http://localhost:8080/employee/login', user).subscribe(
    data => {
      if (data) 
        {
        // Login successful
        this.loginSuccessfull = true;
        alert("Login Successful");
      }
    },
    error => 
      {
      // Handle error (404 error for incorrect credentials)
      if (error.status == 404) {
        alert("Invalid email or password. Please try again.");
      }
    }
  );
}


  addEmployee(employee:Employee)
  {
    this.employeeAddSuccess=false
    this.http.post<Employee>('http://localhost:8080/employee',employee).subscribe(data=>{this.employeeAddSuccess=true}
    )
  }

  updateEmployee(employee:Employee)
  {
    this.employeeUpdated=false
    this.http.post<Employee>    
      ('http://localhost:8080/employee',employee).subscribe(data=> 
        {this.employeeUpdated=true}
    )
  }

  deleteEmployee(employeeId:number)
  {
    this.employeeDeleted=false
    this.http.delete<any>('http://localhost:8080/employee/delete/'+employeeId).subscribe(data=>
     { if(data.status)
    this.employeeDeleted=true}
    )
  }

  getPaginatedEmployees(page: number, size: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/employee/paginate/${page}?pageSize=${size}`);
  }
  
}


