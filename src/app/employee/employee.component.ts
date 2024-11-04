import { Component } from '@angular/core';
import { CurdService } from '../services/curd.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {
  
  searchTerm: string = '';
  p:number=1;
  itemsPerPage:number=7;
  employees: any[] = [];
  totalEmployee:any;

  constructor(public curdService: CurdService) {}

  performSearch() {
    // The pipe will automatically filter the employees based on the search term
  }

  ngOnInit() {
    this.curdService.getEmployees()
  }


  loadEmployees() {
    this.curdService.getPaginatedEmployees(this.p, this.itemsPerPage).subscribe(data => {
      this.employees = data.employees;
      this.totalEmployee = data.totalPages;
    });
  }

  onPageChange(page: number) {
    this.p = page;
    this.loadEmployees();
  }
  

}
