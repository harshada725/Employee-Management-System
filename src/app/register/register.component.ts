import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { CurdService } from '../services/curd.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  employee:Employee
  
  constructor(public curdService:CurdService) {
    this.employee=new Employee();
   }
   registerSubmit(registrationForm:any)
   {
    this.curdService.addEmployee(this.employee)

    setTimeout(() => {
      this.curdService.employeeAddSuccess = false; // Hide success message
      window.location.reload(); // Reload page
    }, 6000); // 6 seconds
   }
}
