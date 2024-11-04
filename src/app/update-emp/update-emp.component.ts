import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { CurdService } from '../services/curd.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-emp',
  templateUrl: './update-emp.component.html',
  styleUrls: ['./update-emp.component.css']
})
export class UpdateEmpComponent {

  employee:Employee
  
  constructor(public curdService:CurdService) {
    this.employee=new Employee();
   }
   updateSubmit(updateForm:any)
   {
    this.curdService.updateEmployee(this.employee)
    setTimeout(() => {
      this.curdService.employeeUpdated = false; // Hide success message
      window.location.reload(); // Reload page
    }, 6000); // 6 seconds

   }
   selectEmployeeId()
   {
    for(let i=0;i<this.curdService.employees.length;i++)
    
      if(this.curdService.employees[i].employeeId==this.employee.employeeId)
        Object.assign(this.employee ,this.curdService.employees[i])
   }


}
