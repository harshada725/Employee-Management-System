import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { RegisterComponent } from './register/register.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';
import { DeleteEmpComponent } from './delete-emp/delete-emp.component';

const routes: Routes = [
{ path: '',   //this redirect to 'home'
  redirectTo: 'home',
  pathMatch: 'full' 
},
{
  path:'login',
  component:LoginComponent
},
{
  path:'home',
  component:HomeComponent
},
{
  path:'register',
  component:RegisterComponent
},
{
  path:'employee',
  component:EmployeeComponent
},
{
  path:'department',
  component:DepartmentComponent
},
{
  path:'update-emp',
  component:UpdateEmpComponent
},
{
  path:'delete-emp',
  component:DeleteEmpComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
