import { Component, OnInit } from '@angular/core';
import { FormControl, FormControlDirective, FormGroup, Validators } from '@angular/forms';
import { LoyaltyProgram } from '../../models/LoyaltyProgram';
import { AuthService } from '../../services/authService/auth.service';
import { LoyaltyProgramService } from '../../services/loyaltyProgramService/loyalty-program.service';

@Component({
  selector: 'app-loyalty-program',
  templateUrl: './loyalty-program.component.html',
  styleUrls: ['./loyalty-program.component.css']
})
export class LoyaltyProgramComponent implements OnInit {

  constructor(private authService : AuthService,private loyaltyProgramService : LoyaltyProgramService) { }
  editMode : Boolean = false;
  loyaltyProgramForm : FormGroup;

  ngOnInit(): void {
    this.loyaltyProgramService.getLoyaltyProgram().subscribe(res=>{
      console.log(res);
      this.loyaltyProgramForm = new FormGroup({
        'pointsPerReservation' : new FormControl(res.pointsPerReservation, [Validators.required]),
        'silverMemberThreshold' : new FormControl(res.silverMemberThreshold, [Validators.required]),
        'goldenMemberThreshold' : new FormControl(res.goldenMemberThreshold, [Validators.required]),
       });
    })
    
  }

  logOut(){
    this.authService.logout();
  }

  updateLoyaltyProgram(){
    console.log(this.loyaltyProgramForm.value);
    if(this.loyaltyProgramForm.value.silverMemberThreshold > this.loyaltyProgramForm.value.goldenMemberThreshold){
      alert("Wrong data input.Golden member rate must be higher than silver member rate.")
    }
    else if(this.loyaltyProgramForm.value.silverMemberThreshold == null || this.loyaltyProgramForm.value.goldenMemberThreshold== null
    || this.loyaltyProgramForm.value.pointsPerReservation == null){
      alert("All fields are required!")
    }
    else{
      var loyaltyProgram = new LoyaltyProgram(0,this.loyaltyProgramForm.value.pointsPerReservation,this.loyaltyProgramForm.value.silverMemberThreshold,
        this.loyaltyProgramForm.value.silverMemberThreshold);
        this.loyaltyProgramService.update(loyaltyProgram).subscribe(res =>{
          alert("Loyalty program successfully updated.");
        });
    }
  }
}
