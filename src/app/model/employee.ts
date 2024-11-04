import { Department } from "./department";



export class Employee
{
  employeeId:number;
	employeeName:String;
	employeeSalary:number;
	employeeEmail:String;
	password:String;
	skillSet:String;
  department:Department;

  constructor()
  {
    this.employeeId=0,
    this.employeeName=" ",
    this.employeeSalary=0,
    this.employeeEmail="",
    this.password="",
    this.skillSet=" "
    this.department=new Department()

  }
}