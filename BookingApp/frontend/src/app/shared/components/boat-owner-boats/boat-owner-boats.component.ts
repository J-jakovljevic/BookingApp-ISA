import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdditionalService } from '../../models/AdditionalService';
import { Boat } from '../../models/Boat';
import { Reservation } from '../../models/Reservation';
import { Action } from '../../models/reservations/Action';
import { ActionService } from '../../services/actionService/action.service';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';

@Component({
  selector: 'app-boat-owner-boats',
  templateUrl: './boat-owner-boats.component.html',
  styleUrls: ['./boat-owner-boats.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class BoatOwnerBoatsComponent implements OnInit {
  allBoats : Boat[];
  boatSelected : boolean = false;
  selectedBoat : any;
  searchInput : String;
  newBoatMode : boolean = false;
  newBoatForm : FormGroup;
  newActionForm : FormGroup;
  newActionMode : boolean = false;
  newReservationForm : FormGroup;
  newReservationMode : boolean = false;
  reservations : Reservation[];
  aditionalServices : AdditionalService[] = [];
  free : boolean = true;
  freeQR : boolean = true;


  constructor(private actionService : ActionService, private authService: AuthService, private rentingItemsService : RentingItemsService,
     private router : Router, private reservationsService : ReservationsService ) {}

  ngOnInit(): void {
      this.getMyBoats(this.authService.getCurrentUserId());
      this.newBoatForm = new FormGroup({
      'name' : new FormControl(null, [Validators.required]),
      'description' : new FormControl(null, [Validators.required]),
      'rules' : new FormControl(null, [Validators.required]),
      'address' : new FormControl(null, [Validators.required]),
      'capacity' : new FormControl(null, [Validators.required]),
      'type' : new FormControl(null, [Validators.required]),
      'length' : new FormControl(null, [Validators.required]),
      'engineNumber' : new FormControl(null, [Validators.required]),
      'maxSpeed' : new FormControl(null, [Validators.required]),
      'navigationEqipment' : new FormControl(null, [Validators.required]),
      'aditionalFishingEquipment' : new FormControl(null, [Validators.required]),
      'cancellationTerms' : new FormControl(null, [Validators.required]),
    });
    this.newActionForm = new FormGroup({
      'rentingItemId' : new FormControl(null, [Validators.required]),
      'startTime' : new FormControl(null, [Validators.required]),
      'endTime' : new FormControl(null, [Validators.required]),
      'capacity' : new FormControl(null, [Validators.required]),
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

  getMyBoats(ownerId : Number) : void{
    console.log(ownerId);
    this.rentingItemsService.getMyBoats(ownerId).subscribe(res => {
      this.allBoats = res;
    });
  }

  showBoatDetails(id: Number): void{
    this.boatSelected = true;
    this.selectedBoat = this.allBoats.find(boat => boat.id == id);
  }

  unselectBoat() : void{
    this.boatSelected = false;
  }

  searchBoats() : void{
    if(this.searchInput == ''){
      this.getMyBoats(this.authService.getCurrentUserId());
    }
    else{
      console.log(this.searchInput);
      this.rentingItemsService.searchMyBoats(this.authService.getCurrentUserId(), this.searchInput).subscribe( res => {
          this.allBoats = res;
      });
    }
  }

  turnNewBoatModeOn() : void{
    this.newBoatMode = true;
  }

  turnNewBoatModeOff() : void{
    this.newBoatMode = false;
  }

  turnNewReservationModeOn() : void{
    this.newReservationMode = true;
  }

  turnNewReservationModeOff() : void{
    this.newReservationMode = false;
  }

  newBoat(): void {
    var boat = new Boat(Math.floor((1 + Math.random()) * 0x10000),this.newBoatForm.value.name,this.newBoatForm.value.address,
    this.newBoatForm.value.description, this.newBoatForm.value.type, this.newBoatForm.value.length,this.newBoatForm.value.engineNumber,
    this.newBoatForm.value.maxSpeed,this.newBoatForm.value.navigationEqipment,this.newBoatForm.value.aditionalFishingEquipment,this.newBoatForm.value.cancellationTerms ,this.newBoatForm.value.rules, this.newBoatForm.value.capacity,this.authService.getCurrentUserId());
    this.rentingItemsService.newBoat(boat).subscribe(res => {
      alert("Uspesno ste dodali novu brod.")
    })
  }

  deleteBoat() : void {
    this.rentingItemsService.deleteBoat(this.selectedBoat.id).subscribe( res => {
      this.boatSelected = false;
      this.selectedBoat = null;
      alert("Uspesno ste obrisali brod.");
      this.router.navigate(['/myBoats']);
    })
  }

  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }

  async newAction() : Promise<void> {
    var action = new Action(Math.floor((1 + Math.random()) * 0x10000),this.selectedBoat.id, this.newActionForm.value.startTime, this.newActionForm.value.endTime, this.selectedBoat.capacity, this.newActionForm.value.additionalServices,this.newActionForm.value.price,false, this.selectedBoat);
    this.checkPeriod(action);
    await this.delay(500);
    this.checkPeriodQR(action);
    await this.delay(500);
    this.createAction(action);
  }

  async newReservation() : Promise<void> {
    var additionalService = new AdditionalService(Math.floor((1 + Math.random()) * 0x10000),this.selectedBoat.id,this.newReservationForm.value.additionalServices);
    this.aditionalServices.push(additionalService);
    var reservation = new Reservation(Math.floor((1 + Math.random()) * 0x10000),this.newReservationForm.value.clientId,this.selectedBoat.id, this.newReservationForm.value.startTime, this.newReservationForm.value.endTime, this.aditionalServices,this.newReservationForm.value.price);
    this.checkPeriodForReservation(reservation);
    await this.delay(500);
    this.checkPeriodQRForReservation(reservation);
    await this.delay(500);
    this.createReservation(reservation);
  }

  checkPeriod(action : Action) : void{
    this.reservationsService.checkPeriodForBoat(this.selectedBoat.id, action).subscribe( res => {
      this.free = res;
      console.log(this.free);
    });
  }

  checkPeriodQR(action : Action) : void{
    this.reservationsService.checkPeriodQRForBoat(this.selectedBoat.id, action).subscribe( res => {
      this.freeQR = res;
      console.log(this.freeQR);
    });
  }

  checkPeriodForReservation(reservation : Reservation) : void{
    this.reservationsService.checkPeriodForReservationForBoat(this.selectedBoat.id, reservation).subscribe( res => {
      this.free = res;
      console.log(this.free);
    });
  }

  checkPeriodQRForReservation(reservation : Reservation) : void{
    this.reservationsService.checkPeriodQRForReservationForBoat(this.selectedBoat.id, reservation).subscribe( res => {
      this.freeQR = res;
      console.log(this.freeQR);
    });
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

  turnNewActionModeOn() : void{
    this.newActionMode = true;
  }

  turnNewActionModeOff() : void{
    this.newActionMode = false;
  }

  logOut(){
    this.authService.logout();
  }

}
