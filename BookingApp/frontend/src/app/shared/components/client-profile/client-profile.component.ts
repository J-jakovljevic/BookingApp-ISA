import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from '../../models/Client';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { PasswordChanger } from '../../models/PasswordChanger';
import { AuthService } from '../../services/authService/auth.service';
import { LoyaltyProgramService } from '../../services/loyaltyProgramService/loyalty-program.service';
import { UsersService } from '../../services/userService/users.service';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientProfileComponent implements OnInit {
  editMode : Boolean = false;
  changePasswordMode : Boolean = false;
  userInfoForm : FormGroup;
  changePasswordForm : FormGroup;
  client : Client;
  dataLoaded : Promise<boolean>;
  description : String;
  deleteAccountRequestMode: boolean = false;
  loyaltyProgramStatus : String;

  constructor(private usersService : UsersService, private authService : AuthService,private router: Router,
    private loyaltyProgramService : LoyaltyProgramService) { }

  ngOnInit(): void {
    this.loyaltyProgramService.getStatusByClient(Number(localStorage.getItem('currentUserId'))).subscribe(res=>{
      this.loyaltyProgramStatus = res.status;
      this.usersService.getClientById(Number(localStorage.getItem('currentUserId'))).subscribe(res =>{
        this.client = res;
        this.userInfoForm = new FormGroup({
          'name' : new FormControl(this.client.name, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
          'surname' : new FormControl(this.client.surname, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
          'email' : new FormControl(this.client.email, [Validators.required, Validators.email]),
          'phoneNumber' : new FormControl(this.client.phoneNumber,  [Validators.required, Validators.pattern("^[0-9]*$")]),
          'address' : new FormControl(this.client.address, Validators.required),
        });
        this.changePasswordForm = new FormGroup({
          'oldPass' : new FormControl(null, [Validators.required]),
          'newPass' : new FormControl(null, [Validators.required]),
          'confirmPass' : new FormControl(null, [Validators.required]),
         });
         this.dataLoaded = Promise.resolve(true);
      });
    });
   
   
    
   
  }

  updateClient(): void{
    var client = new Client(Number(localStorage.getItem('currentUserId')),this.userInfoForm.value.name,
    this.userInfoForm.value.surname,this.userInfoForm.value.phoneNumber,this.client.email,this.client.password,this.client.address,this.client.role);
    this.usersService.updateClient(client).subscribe(res => {
      this.client = res;  
      this.turnEditModeOff();
    });
  }
  turnEditModeOn(): void{
    this.editMode = true;
  }

  turnEditModeOff(): void{
    this.editMode = false;
  }
  
  turnChangePasswordModeOn() : void{
    this.changePasswordMode = true;
  }
  turnChangePasswordModeOff() : void{
    this.changePasswordMode = false;
  }
  turnDeleteAccountRequestModeOff(){
    this.deleteAccountRequestMode = false;
  }

  turnDeleteAccountRequestModeOn(){
    this.deleteAccountRequestMode = true;
  }

  changePassword() : void{
    if(this.changePasswordForm.value.newPass != this.changePasswordForm.value.confirmPass){
      console.log("passwords doesn't match");
    }
    else{
      var passwordChanger = new PasswordChanger(this.changePasswordForm.value.oldPass, this.changePasswordForm.value.newPass);
      console.log(passwordChanger);
      this.authService.changePassword(passwordChanger).subscribe( res =>{
      });
      this.turnChangePasswordModeOff();
      this.turnEditModeOff();
    }
  }

  makeDeleteAccountRequest(){
    var deleteAccRequest = new DeleteAccountRequest(0,this.description,false,this.authService.currentUser.user.id);
    this.usersService.createDeleteAccountRequest(deleteAccRequest).subscribe(res =>{
    });
    alert("Request successfully sent!");
    this.turnDeleteAccountRequestModeOff();
  }
  
  logOut(){
    this.authService.logout();
  }

}
