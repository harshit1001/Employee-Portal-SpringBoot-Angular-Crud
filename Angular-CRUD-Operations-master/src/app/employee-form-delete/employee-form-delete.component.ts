import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-employee-form-delete',
  templateUrl: './employee-form-delete.component.html',
  styleUrls: ['./employee-form-delete.component.scss']
})
export class EmployeeFormDeleteComponent implements OnInit {
  
  constructor(private dialogRef: MatDialogRef<EmployeeFormComponent>, 
   private userService: UserService,
    @Inject(MAT_DIALOG_DATA) public data: any) { console.log(this.data) }

  ngOnInit(): void {
  }
  deleteUser(id) {
    this.userService.deleteUser(id).subscribe(data => { console.log(data) ;
      
      this.dialogRef.close();});

  }
 
  cancelEdits() {
    this.dialogRef.close()
  }
}
