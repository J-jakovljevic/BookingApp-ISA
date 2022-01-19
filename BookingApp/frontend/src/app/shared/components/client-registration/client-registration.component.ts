import { Component, OnInit } from '@angular/core';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Client } from '../../models/Client';
import { UsersService } from '../../services/userService/users.service';
import { AuthService } from '../../services/authService/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.css']
})
export class ClientRegistrationComponent implements OnInit {
  public registrationForm : FormGroup = new FormGroup({});

  constructor(private userService : UsersService,
    private authService: AuthService,private router : Router) { }

  ngOnInit(): void {
    this.registrationForm = new FormGroup({
      'name' : new FormControl(null, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
      'surname' : new FormControl(null, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
      'email' : new FormControl(null, [Validators.required, Validators.email]),
      'phoneNumber' : new FormControl(null,  [Validators.required, Validators.pattern("^[0-9]*$")]),
      'password' : new FormControl(null, [Validators.required,Validators.minLength(8)]),
      'confirmPassword' : new FormControl(null,[Validators.required,Validators.minLength(8)]),
      'address' : new FormControl(null, Validators.required),
    });
  }

  register():void {
    var client = new Client(0,this.registrationForm.value.name,this.registrationForm.value.surname,
                           this.registrationForm.value.phoneNumber,this.registrationForm.value.email,
                           this.registrationForm.value.password,this.registrationForm.value.address,'Client');
    
   this.userService.registerClient(client).subscribe( res => {
     alert("Account succesfully registered! Go to your email to verify your registration.")
     this.router.navigate(['login']);
   })
  }

  logOut() : void {
    this.authService.logout();
  }


}
