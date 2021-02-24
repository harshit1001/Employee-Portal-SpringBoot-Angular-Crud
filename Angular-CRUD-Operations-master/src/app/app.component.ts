import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { EmployeeFormDeleteComponent } from './employee-form-delete/employee-form-delete.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { User } from './models/user';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  users: User[];
  userForm: boolean;
  isNewUser: boolean;
  newUser: any = {};
  editUserForm: boolean;
  editedUser: any = {};
  sorting={name:true,salary:true,id:true}
  
  constructor(private userService: UserService,public matDialog: MatDialog) { }

  ngOnInit() {
    this.userService.getUsersFromData().subscribe((data:User[])=>{this.users=data})
   
  }

 getUsers(): User[] {
    return this.users
  }

  showEditUserForm(user: User) {
    this.editForm(user);
    if (!user) {
      this.userForm = false;
      return;
    }
    this.editUserForm = true;
    this.editedUser = user;
  }

  showAddUserForm() {
    //this.gg()
    // resets form if edited user
    const dialogConfig = new MatDialogConfig();
 
    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "350px";
    dialogConfig.width = "600px";
    dialogConfig.data=undefined;
    
    const modalDialog = this.matDialog.open(EmployeeFormComponent, dialogConfig);

  }
  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
    
      let formData = new FormData(); 
      formData.append("file", file, file.name); 
     
      this.userService.import(formData).subscribe(
        (res) => console.log(res),
        (err) => console.log(err)
      );
     
    }
  
  }
 
  sortById(sorting){
  sorting.id=!sorting.id;
  sorting.name=false;
  sorting.salary=false;
  this.sorting=sorting;
  if(this.sorting.id)
    this.users.sort((a,b) => (a.id > b.id) ? 1 : ((b.id > a.id) ? -1 : 0))
else
    this.users.sort((a,b) => (a.id < b.id) ? 1 : ((b.id < a.id) ? -1 : 0))
  }
  sortByName(sorting){
    sorting.name=!sorting.name;
   
     sorting.id=false;
    sorting.salary=false;
    this.sorting=sorting;
    if(this.sorting.name)
    this.users.sort((a,b) => (a.name > b.name) ? 1 : ((b.name > a.name) ? -1 : 0))
    else
    this.users.sort((a,b) => (a.name < b.name) ? 1 : ((b.name < a.name) ? -1 : 0))
  }
  sortBySalary(sorting){
    sorting.salary=!sorting.salary;
    sorting.id=false;
    sorting.name=false;
    this.sorting=sorting;
    if(this.sorting.salary)
    this.users.sort((a,b) => (a.value > b.value) ? 1 : ((b.value >  a.value) ? -1 : 0))
    else
    this.users.sort((a,b) => (a.value < b.value) ? 1 : ((b.value < a.value) ? -1 : 0))
  }
  saveUser(user: User) {

    let a={name:"Harshit Jain",value:444,code:"",description:"d"}
    if (this.isNewUser) {
      // add a new user
      this.userService.addUser(a).subscribe((data)=>{console.log(data)})
    }
   
    this.userForm = false;
  }

  editForm(user){
   
      const dialogConfig = new MatDialogConfig();
 
      dialogConfig.disableClose = true;
      dialogConfig.id = "modal-component";
      dialogConfig.height = "350px";
      dialogConfig.width = "600px";
      dialogConfig.data={user}
      
      const modalDialog = this.matDialog.open(EmployeeFormComponent, dialogConfig);
    
  }
  deleteForm(id){
   
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.id = "modal-componentj";
    dialogConfig.height = "350px";
    dialogConfig.width = "600px";
    dialogConfig.data={id:id}
    
    const modalDialog = this.matDialog.open(EmployeeFormDeleteComponent, dialogConfig);
  
}
 

  removeUser(user: User) {
    this.deleteForm(user.id);
  
  }

  cancelEdits() {
    this.editedUser = {};
    this.editUserForm = false;
  }

  cancelNewUser() {
    this.newUser = {};
    this.userForm = false;
  }
 

}
