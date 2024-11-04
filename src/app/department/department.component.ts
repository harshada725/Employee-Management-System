import { Component } from '@angular/core';
import { CurdService } from '../services/curd.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent {

  constructor(public curdService:CurdService)
  {

  }
  ngOnInit()
  {
    this.curdService.getDepartments()
  }
}
