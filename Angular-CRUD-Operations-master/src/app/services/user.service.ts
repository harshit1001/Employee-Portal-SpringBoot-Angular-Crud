import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http:HttpClient) { }

 

  addUser(user) {
   return this.http.post("/product/",user);
  }
  getUsersFromData(){
    return this.http.get("/product/");
   }
   editUser(user) {
    return this.http.post("/product/edit/",user);
  }
  deleteUser(id) {
    return this.http.delete("/product/delete/"+id);
  }
  import(file){
    return this.http.post("product/upload",file);
  }
  

}
