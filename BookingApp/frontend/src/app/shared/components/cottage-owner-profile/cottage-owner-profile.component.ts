import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/authService/auth.service';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { PasswordChanger } from '../../models/PasswordChanger';
import { CottageOwner } from '../../models/users/CottageOwner';
import { off } from 'process';
import { UsersService } from '../../services/userService/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cottage-owner-profile',
  templateUrl: './cottage-owner-profile.component.html',
  styleUrls: ['./cottage-owner-profile.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CottageOwnerProfileComponent implements OnInit {
  editMode : Boolean = false;
  changePasswordMode : Boolean = false;
  cottageOwnerInfoForm : FormGroup;
  changePasswordForm : FormGroup;
  cottageOwner : CottageOwner;
  dataLoaded : Promise<boolean>;
  description : String;
  deleteAccountRequestMode: boolean = false;

  constructor(private usersService : UsersService, private authService : AuthService,private router: Router,) { }

  ngOnInit(): void {
    this.usersService.getCottageOwnerById(Number(localStorage.getItem('currentUserId'))).subscribe(res =>{
      this.cottageOwner = res;
      this.cottageOwnerInfoForm = new FormGroup({
        'name' : new FormControl(this.cottageOwner.name, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
        'surname' : new FormControl(this.cottageOwner.surname, [Validators.required, Validators.pattern("^[a-zšđćčžA-ZŠĐŽČĆ ]*$")]),
        'email' : new FormControl(this.cottageOwner.email, [Validators.required, Validators.email]),
        'phoneNumber' : new FormControl(this.cottageOwner.phoneNumber,  [Validators.required, Validators.pattern("^[0-9]*$")]),
        'address' : new FormControl(this.cottageOwner.address, Validators.required),
      });
      this.changePasswordForm = new FormGroup({
        'oldPass' : new FormControl(null, [Validators.required]),
        'newPass' : new FormControl(null, [Validators.required]),
        'confirmPass' : new FormControl(null, [Validators.required]),
       });
       this.dataLoaded = Promise.resolve(true);
    });
  }

  updateCottageOwner(): void{
    var cottageOwner = new CottageOwner(Number(localStorage.getItem('currentUserId')),this.cottageOwnerInfoForm.value.name,
    this.cottageOwnerInfoForm.value.surname,this.cottageOwnerInfoForm.value.phoneNumber,this.cottageOwner.email,this.cottageOwner.password,this.cottageOwner.address,this.cottageOwner.role);
    this.usersService.updateCottageOwner(cottageOwner).subscribe(res => {
    this.cottageOwner = res;
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
