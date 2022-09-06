import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cottage } from '../../models/Cottage';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { Router } from '@angular/router';
import { Action } from '../../models/reservations/Action';
import { ActionService } from '../../services/actionService/action.service';
import { Reservation } from '../../models/Reservation';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { AdditionalService } from '../../models/AdditionalService';


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
  newReservationForm : FormGroup;
  newReservationMode : boolean = false;
  reservations : Reservation[];
  aditionalServices : AdditionalService[] = [];
  free : boolean = true;
  freeQR : boolean = true;

  constructor(private actionService : ActionService, private authService: AuthService, private rentingItemsService : RentingItemsService,
     private router : Router, private reservationsService : ReservationsService ) { }

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
      'startTime' : new FormControl(null, [Validators.required]),
      'endTime' : new FormControl(null, [Validators.required]),
      'additionalServices' : new FormControl(null, [Validators.required]),
      'price' : new FormControl(null, [Validators.required])
     
    });
    this.newReservationForm = new FormGroup({
      'clientId' : new FormControl(null, [Validators.required]),
      'startTime' : new FormControl(null, [Validators.required]),
      'endTime' : new FormControl(null, [Validators.required]),
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
      this.rentingItemsService.searchMyCottages(this.authService.getCurrentUserId(), this.searchInput).subscribe( res => {
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

  turnNewReservationModeOn() : void{
    this.newReservationMode = true;
  }

  turnNewReservationModeOff() : void{
    this.newReservationMode = false;
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

checkPeriod(action : Action) : void{
  this.reservationsService.checkPeriod(this.selectedCottage.id, action).subscribe( res => {
    this.free = res;
    console.log(this.free);
  });
}

checkPeriodForReservation(reservation : Reservation) : void{
  this.reservationsService.checkPeriodForReservation(this.selectedCottage.id, reservation).subscribe( res => {
    this.free = res;
    console.log(this.free);
  });
}

checkPeriodQR(action : Action) : void{
  this.reservationsService.checkPeriodQR(this.selectedCottage.id, action).subscribe( res => {
    this.freeQR = res;
    console.log(this.freeQR);
  });
}

checkPeriodQRForReservation(reservation : Reservation) : void{
  this.reservationsService.checkPeriodQRForReservation(this.selectedCottage.id, reservation).subscribe( res => {
    this.freeQR = res;
    console.log(this.freeQR);
  });
}

createAction(action : Action) : void{
  if(this.free && this.freeQR){
    this.actionService.newAction(action).subscribe( res => {
      alert("Uspesno ste dodali novu akciju.")
    })
  }
  else{
    alert("Neuspesno,izabrani datum je zauzet. Niste dodali novu akciju.")
  }
}

createReservation(reservation : Reservation) : void{
  if(this.free && this.freeQR){
    this.reservationsService.createReservation(reservation).subscribe( res => {
      alert("Uspesno ste dodali novu rezervaciju.")
    })
  }
  else{
    alert("Neuspesno,izabrani datum je zauzet. Niste dodali novu rezervaciju.")
  }
}

 delay(ms: number) {
  return new Promise( resolve => setTimeout(resolve, ms) );
}

  async newAction() : Promise<void> {
  var action = new Action(Math.floor((1 + Math.random()) * 0x10000),this.selectedCottage.id, this.newActionForm.value.startTime, this.newActionForm.value.endTime, this.selectedCottage.capacity, this.newActionForm.value.additionalServices,this.newActionForm.value.price,false, this.selectedCottage);
  this.checkPeriod(action);
  await this.delay(500);
  this.checkPeriodQR(action);
  await this.delay(500);
  this.createAction(action);
}

async newReservation() : Promise<void> {
  var additionalService = new AdditionalService(Math.floor((1 + Math.random()) * 0x10000),this.selectedCottage.id,this.newReservationForm.value.additionalServices);
  this.aditionalServices.push(additionalService);
  var reservation = new Reservation(Math.floor((1 + Math.random()) * 0x10000),this.newReservationForm.value.clientId,this.selectedCottage.id, this.newReservationForm.value.startTime, this.newReservationForm.value.endTime, this.aditionalServices,this.newReservationForm.value.price);
  this.checkPeriodForReservation(reservation);
  await this.delay(500);
  this.checkPeriodQRForReservation(reservation);
  await this.delay(500);
  this.createReservation(reservation);
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
