import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { EmployeeFormComponent } from './employee-form/employee-form.component';
import {MatDialogModule} from "@angular/material/dialog"
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeeFormDeleteComponent } from './employee-form-delete/employee-form-delete.component';

@NgModule({
  declarations: [
    AppComponent,
   
    EmployeeFormComponent,
   
    EmployeeFormDeleteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
