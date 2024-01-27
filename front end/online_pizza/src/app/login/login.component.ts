import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../class/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  login:User=new User();


  constructor(private userService:UserService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.user)
    this.userService.save(this.login).subscribe(data=>{
      alert("Login Sucessfully")
      
    }
    )
  }
  user(user: any) {
    throw new Error('Method not implemented.');
  }
}