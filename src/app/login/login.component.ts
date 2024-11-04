import { Component } from '@angular/core';
import { User } from '../user';
import { CurdService } from '../services/curd.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user:User
  loginOk:boolean
  constructor(private curdService:CurdService)
  {
    this.user=new User();
    this.loginOk=false
  }
  loginSubmit(loginForm:any)
  {
    if (loginForm.valid) 
      {
      this.curdService.loginSuccess(this.user);
      //this.loginOk=true
  //   setTimeout(() => {
  //     this.curdService.employeeAddSuccess = false; // Hide success message
  //     window.location.reload(); // Reload page
  //   }, 6000); // 6 seconds
  //  }
  } 

  }
}