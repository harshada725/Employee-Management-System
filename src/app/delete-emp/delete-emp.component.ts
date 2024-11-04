import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { CurdService } from '../services/curd.service';

@Component({
  selector: 'app-delete-emp',
  templateUrl: './delete-emp.component.html',
  styleUrls: ['./delete-emp.component.css']
})
export class DeleteEmpComponent {

  employee:Employee
  constructor(public curdService:CurdService)
  {
    this.employee=new Employee()
  }

  selectEmployeeId()
   {
    for(let i=0;i<this.curdService.employees.length;i++)
    
      if(this.curdService.employees[i].employeeId==this.employee.employeeId)
        Object.assign(this.employee ,this.curdService.employees[i])
   }
   deleteSubmit(deleteForm:any)
   {
     this.curdService.deleteEmployee(this.employee.employeeId)

     setTimeout(() => {
      this.curdService.employeeDeleted = false; // Hide success message
      window.location.reload(); // Reload page
    }, 6000); // 6 seconds
   }


}
