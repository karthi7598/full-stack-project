import { Component } from '@angular/core';
import { User} from '../class/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  guest:User=new User();
  userService: any;


  constructor(private loginService:UserService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.guest)
    this.userService.save(this.guest).subscribe(()=>{
      alert("Login Sucessfully")
      
    },()=>alert("Sorry please enter correct Email and Password")
    )
  }
}