import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cottage } from '../../models/Cottage';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { Router } from '@angular/router';
import { Action } from '../../models/reservations/Action';
import { ActionService } from '../../services/actionService/action.service';


@Component({
  selector: 'app-cottage-owner-cottages',
  templateUrl: './cottage-owner-cottages.component.html',
  styleUrls: ['./cottage-owner-cottages.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CottageOwnerCottagesComponent implements OnInit {
  allCottages : Cottage[];
  cottageSelected : boolean = false;
  selectedCottage : any;
  searchInput : String;
  newCottageMode : boolean = false;
  newCottageForm : FormGroup;
  newActionForm : FormGroup;
  newActionMode : boolean = false;

  constructor(private actionService : ActionService, private authService: AuthService, private rentingItemsService : RentingItemsService, private router : Router ) { }

  ngOnInit(): void {
    this.getMyCottages(this.authService.getCurrentUserId());
    this.newCottageForm = new FormGroup({
      'name' : new FormControl(null, [Validators.required]),
      'description' : new FormControl(null, [Validators.required]),
      'rules' : new FormControl(null, [Validators.required]),
      'address' : new FormControl(null, [Validators.required]),
      'capacity' : new FormControl(null, [Validators.required])
    });
    this.newActionForm = new FormGroup({
      'rentingItemId' : new FormControl(null, [Validators.required]),
      'startTime' : new FormControl(null, [Validators.required]),
      'endTime' : new FormControl(null, [Validators.required]),
      'capacity' : new FormControl(null, [Validators.required]),
      'additionalServices' : new FormControl(null, [Validators.required]),
      'price' : new FormControl(null, [Validators.required])
     
    });
  }

  getMyCottages(ownerId : Number) : void{
    console.log(ownerId);
    this.rentingItemsService.getMyCottages(ownerId).subscribe(res => {
      this.allCottages = res;
    });
  }

  showCottageDetails(id: Number): void{
    this.cottageSelected = true;
    this.selectedCottage = this.allCottages.find(cottage => cottage.id == id);
  }

  unselectCottage() : void{
    this.cottageSelected = false;
  }

  searchCottages() : void{
    if(this.searchInput == ''){
      this.getMyCottages(this.authService.getCurrentUserId());
    }
    else{
      console.log(this.searchInput);
      this.rentingItemsService.searchMyCottages(this.searchInput).subscribe( res => {
          this.allCottages = res;
      });
    }
  }

  turnNewCottageModeOn() : void{
    this.newCottageMode = true;
  }

  turnNewCottageModeOff() : void{
    this.newCottageMode = false;
  }

  turnNewActionModeOn() : void{
    this.newActionMode = true;
  }

  turnNewActionModeOff() : void{
    this.newActionMode = false;
  }

logOut() : void {
    this.authService.logout();
  }

newCottage() : void {
  var cottage = new Cottage(Math.floor((1 + Math.random()) * 0x10000),this.newCottageForm.value.name,this.newCottageForm.value.address,this.newCottageForm.value.description, this.newCottageForm.value.rules, this.newCottageForm.value.capacity,this.authService.getCurrentUserId());
  this.rentingItemsService.newCottage(cottage).subscribe( res => {
    alert("Uspesno ste dodali novu vikendicu.")
  })
}

newAction() : void {
  var action = new Action(Math.floor((1 + Math.random()) * 0x10000),this.selectedCottage.id, this.newActionForm.value.startTime, this.newActionForm.value.endTime, this.newActionForm.value.capacity, this.newActionForm.value.additionalServices,this.newActionForm.value.price,false, this.selectedCottage);
  this.actionService.newAction(action).subscribe( res => {
    alert("Uspesno ste dodali novu akciju.")
  })
}

deleteCottage() : void {
  this.rentingItemsService.deleteCottage(this.selectedCottage.id).subscribe( res => {
    this.cottageSelected = false;
    this.selectedCottage = null;
    alert("Uspesno ste obrisali vikendicu.");
    this.router.navigate(['/myCottages']);
  })
}


}
