import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {
  add: boolean;
  edit: boolean;
  newUser={name:undefined,code:undefined,description:undefined,value:undefined};

  constructor( 
    private dialogRef: MatDialogRef<EmployeeFormComponent>,@Inject(MAT_DIALOG_DATA) public data: any
    ,private userService:UserService){
      console.log(this.data)
    } 

  ngOnInit(): void {
    this.add=this.data?false:true
    this.edit=this.data?true:false
  }
  addUser(){
    //let a={name:"Harshit Jain",value:444,code:"",description:"d"}
   console.log(this.newUser)
      // add a new user
     this.userService.addUser(this.newUser).subscribe((data)=>{console.log(data)})
   }
  updateUser() {
  console.log(this.data.user)
  this.userService.editUser(this.data.user).subscribe((data)=>{console.log(data)})
  
  }

 

  cancelEdits() {
    this.closeModal();
  }

  editUser(User){

  }
  closeModal() {
    this.dialogRef.close();
  }
}
