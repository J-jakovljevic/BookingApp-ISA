import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/authService/auth.service';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { PasswordChanger } from '../../models/PasswordChanger';
import { BoatOwner } from '../../models/users/BoatOwner';
import { off } from 'process';
import { UsersService } from '../../services/userService/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-boat-owner-profile',
  templateUrl: './boat-owner-profile.component.html',
  styleUrls: ['./boat-owner-profile.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BoatOwnerProfileComponent implements OnInit {
  editMode : Boolean = false;
  changePasswordMode : Boolean = false;
  boatOwnerInfoForm : FormGroup;
  changePasswordForm : FormGroup;
  boatOwner : BoatOwner;
  dataLoaded : Promise<boolean>;
  description : String;
  deleteAccountRequestMode: boolean = false;

  constructor(private usersService : UsersService, private authService : AuthService,private router: Router,) { }

  ngOnInit(): void {
      this.usersService.getBoatOwnerById(Number(localStorage.getItem('currentUserId'))).subscribe(res =>{
        this.boatOwner = res;
        this.boatOwnerInfoForm = new FormGroup({
          'name' : new FormControl(this.boatOwner.name, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
          'surname' : new FormControl(this.boatOwner.surname, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
          'email' : new FormControl(this.boatOwner.email, [Validators.required, Validators.email]),
          'phoneNumber' : new FormControl(this.boatOwner.phoneNumber,  [Validators.required, Validators.pattern("^[0-9]*$")]),
          'address' : new FormControl(this.boatOwner.address, Validators.required),
        });
        this.changePasswordForm = new FormGroup({
          'oldPass' : new FormControl(null, [Validators.required]),
          'newPass' : new FormControl(null, [Validators.required]),
          'confirmPass' : new FormControl(null, [Validators.required]),
         });
         this.dataLoaded = Promise.resolve(true);
      });
    }
  
    updateBoatOwner(): void{
      var boatOwner = new BoatOwner(Number(localStorage.getItem('currentUserId')),this.boatOwnerInfoForm.value.name,
      this.boatOwnerInfoForm.value.surname,this.boatOwnerInfoForm.value.phoneNumber,this.boatOwner.email,this.boatOwner.password,this.boatOwner.address,this.boatOwner.role);
      this.usersService.updateBoatOwner(boatOwner).subscribe(res => {
      this.boatOwner = res;
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
  
    logOut(){
      this.authService.logout();
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

}
