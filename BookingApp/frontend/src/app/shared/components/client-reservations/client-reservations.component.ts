import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, ChangeDetectionStrategy, Input, Output, Directive, ViewChildren, QueryList } from '@angular/core';
import { Router } from '@angular/router';
import { Action } from 'rxjs/internal/scheduler/Action';
import { EventEmitter } from 'stream';
import { Complaint } from '../../models/Complaint';
import { Reservation } from '../../models/Reservation';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemAvailabilityService } from '../../services/rentingItemAvailability/renting-item-availability.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { UsersService } from '../../services/userService/users.service';



@Component({
  selector: 'app-client-reservations',
  templateUrl: './client-reservations.component.html',
  styleUrls: ['./client-reservations.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientReservationsComponent implements OnInit {
  selectedTab: string;
  cottageSelected : boolean = false;
  cottage2Selected : boolean = false;
  fishingInstructorClassSelected : boolean = false;
  fishingInstructorClass2Selected : boolean = false;
  futureReservationsSelected : boolean = false;
  futureReservations2Selected : boolean = false;
  boatSelected : boolean = false;
  boat2Selected : boolean = false;
  complaintMode : boolean = false;

  selectedBoat : any;
  selectedCottage : any;
  selectedFutureReservation : any;
  selectedFishingInstructorClass : any;

  fishingInstructor : FishingInstructor;
  description : string;
  type : any;
  reservationType : String;
  
  rentingItemForComplaintId : any;
  quickCottageReservationsCopy : any[];

  previousReservations : Reservation[];
  futureReservations : Reservation[] = [];
  previousQuickReservations : QuickReservation[];
  futureQuickReservations : QuickReservation[] = [];


  
 

  constructor(private reservationService : ReservationsService
    ,private authService : AuthService, private rentingService : RentingItemsService,
    private usersService: UsersService, private router: Router,private rentingItemAvailabilityService : RentingItemAvailabilityService) { }

  ngOnInit(): void {
    this.getAllPreviousQuickReservationsForClient();
    this.getAllQuickFutureReservationsForClient();
    this.getAllPreviousReservationsForClient();
    this.getAllFutureReservationsForClient();
  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }

  showCottageDetails(id: Number): void{
    this.cottageSelected = true;
    this.selectedCottage = this.previousQuickReservations.find(reservation => reservation.id == id);
  }

  showCottageDetails2(id: Number): void{
    this.cottage2Selected = true;
    this.selectedCottage = this.previousReservations.find(reservation => reservation.id == id);
  }

  unselectCottage() : void{
    this.cottageSelected = false;
    this.cottage2Selected = false;
  }

  showBoatDetails(id: Number): void{
    this.boatSelected = true;
    this.selectedBoat = this.previousQuickReservations.find(reservation => reservation.id == id);
  }

  showBoatDetails2(id: Number): void{
    this.boat2Selected = true;
    this.selectedBoat = this.previousReservations.find(reservation => reservation.id == id);
  }

  unselectBoat() : void{
    this.boatSelected = false;
    this.boat2Selected = false;
  }

  showFishingInstructorClassDetails(id: Number): void{
    this.fishingInstructorClassSelected = true;
    this.selectedFishingInstructorClass = this.previousQuickReservations.find(reservation => reservation.id == id);
    this.usersService.getFishingInstructorById(this.selectedFishingInstructorClass.action.reservedRentingItem.fishingInstructorId).subscribe(res => {
      this.fishingInstructor = res;
    });
  }

  showFishingInstructorClassDetails2(id: Number): void{
    this.fishingInstructorClass2Selected = true;
    this.selectedFishingInstructorClass = this.previousReservations.find(reservation => reservation.id == id);
    this.usersService.getFishingInstructorById(this.selectedFishingInstructorClass.reservedRentingItem.fishingInstructorId).subscribe(res => {
      this.fishingInstructor = res;
    });
  }

  unselectFishingInstructorClass() : void{
    this.fishingInstructorClassSelected = false;
    this.fishingInstructorClass2Selected = false;
  }
  unselectFutureReservations() : void{
    this.futureReservationsSelected = false;
    this.futureReservations2Selected = false;
  }

  showFutureReservationDetails(id: Number){
    this.futureReservationsSelected = true;
    this.selectedFutureReservation = this.futureQuickReservations.find(reservation => reservation.id == id);
    console.log(this.selectedFutureReservation);
  }

  showFutureReservationDetails2(id: Number){
    this.futureReservations2Selected = true;
    this.selectedFutureReservation = this.futureReservations.find(reservation => reservation.id == id);
    console.log(this.selectedFutureReservation);
  }

  cancelQuickReservation(){
      var currentDate = new Date();
    if( new Date(this.selectedFutureReservation.action.startTime).getTime() - currentDate.getTime() < 1000 * 3600 * 24 * 3 ) {
      alert('Reservation cancellation unsuccessfull. You could cancel reservation at least' +
      'three days before beginning of an Action.')
    }
    else{
      this.reservationService.cancelQuickReservationForClient(this.selectedFutureReservation.id).subscribe( res =>{
        alert("Succesfully cancelled reservation");
        this.getAllQuickFutureReservationsForClient();
        this.futureReservationsSelected = false;
        this.futureReservations2Selected = false;
      }); 
    }
  }

  cancelReservation(){
  var currentDate = new Date();
  if( new Date(this.selectedFutureReservation.startTime).getTime() - currentDate.getTime() < 1000 * 3600 * 24 * 3 ) {
    alert('Reservation cancellation unsuccessfull. You could cancel reservation at least' +
    'three days before beginning of an Action.')
  }
  else{
    this.reservationService.cancelReservationForClient(this.selectedFutureReservation.id).subscribe( res =>{
      alert("Succesfully cancelled reservation");
      this.getAllQuickFutureReservationsForClient();
      this.futureReservationsSelected = false;
      this.futureReservations2Selected = false;
    }); 
  }
}

  turnMakeComplaintModeOn(reservation : any){
    this.rentingItemForComplaintId = reservation;
    console.log(this.rentingItemForComplaintId);
    this.complaintMode = true;
  }

  turnMakeComplaintModeOff(){
    this.complaintMode = false;
  }

  makeComplaint(){
      var complaint = new Complaint(0,this.authService.currentUser.user.id,
        this.rentingItemForComplaintId, this.description);
      this.rentingService.createComplaint(complaint).subscribe(res=>{
      });
      alert("Complaint successfully created.");
      this.turnMakeComplaintModeOff();
  }

  getAllPreviousQuickReservationsForClient(){
    this.reservationService.getPreviousQuickReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.previousQuickReservations = res;
      for(let i = 0;i < this.previousQuickReservations.length; i++){
        if(this.previousQuickReservations[i].action.rentingItem.type == 'Boat'){
            this.rentingService.getBoatById(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
              this.previousQuickReservations[i].action.reservedRentingItem = res;
            });
        }
        else if(this.previousQuickReservations[i].action.rentingItem.type == 'Cottage'){
          this.rentingService.getCottageById(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
            this.previousQuickReservations[i].action.reservedRentingItem = res;
          });
        }
        else{
          this.rentingService.getFishingInstructorClassById(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
            this.previousQuickReservations[i].action.reservedRentingItem = res;
          });
        }
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
          this.previousQuickReservations[i].action.rentingItem.additionalServices = res;
        });
    }
    });

  
  }

  getAllQuickFutureReservationsForClient(){
   this.reservationService.getFutureQuickReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.futureQuickReservations = res;
      for(let i = 0 ; i < this.futureQuickReservations.length ; i++){
      if(this.futureQuickReservations[i].action.rentingItem.type == 'Boat'){
        this.rentingService.getBoatById(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
          this.futureQuickReservations[i].action.reservedRentingItem = res;
        });
    }
    else if(this.futureQuickReservations[i].action.rentingItem.type == 'Cottage'){
      this.rentingService.getCottageById(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
        this.futureQuickReservations[i].action.reservedRentingItem = res;
       // this.quickCottageReservationsCopy[i].action.rentingItem = res;
      });
    }
    else{
      this.rentingService.getFishingInstructorClassById(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
        this.futureQuickReservations[i].action.reservedRentingItem = res;
      });
    }
    this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
      this.futureQuickReservations[i].action.rentingItem.additionalServices = res;
    });
  }
  console.log(this.futureQuickReservations)
   });
  }

 
  
  logOut(){
    this.authService.logout();
  }

  getAllPreviousReservationsForClient(){
    this.reservationService.getPreviousReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.previousReservations = res;
      for(let i = 0;i < this.previousReservations.length; i++){
        if(this.previousReservations[i].rentingItem.type == 'Boat'){
            this.rentingService.getBoatById(this.previousReservations[i].rentingItem.id).subscribe( res => {
              this.previousReservations[i].reservedRentingItem = res;
            });
        }
        else if(this.previousReservations[i].rentingItem.type == 'Cottage'){
          this.rentingService.getCottageById(this.previousReservations[i].rentingItem.id).subscribe( res => {
            this.previousReservations[i].reservedRentingItem = res;
           // this.quickCottageReservationsCopy[i].action.rentingItem = res;
          });
        }
        else{
          this.rentingService.getFishingInstructorClassById(this.previousReservations[i].rentingItem.id).subscribe( res => {
            this.previousReservations[i].reservedRentingItem = res;
          });
        }
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousReservations[i].rentingItem.id).subscribe( res => {
          this.previousReservations[i].rentingItem.additionalServices = res;
        });
    }
    });

  
  }

  getAllFutureReservationsForClient(){
   this.reservationService.getFutureReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.futureReservations = res;
      for(let i = 0 ; i < this.futureReservations.length ; i++){
      if(this.futureReservations[i].rentingItem.type == 'Boat'){
        this.rentingService.getBoatById(this.futureReservations[i].rentingItem.id).subscribe( res => {
          this.futureReservations[i].reservedRentingItem = res;
        });
    }
    else if(this.futureReservations[i].rentingItem.type == 'Cottage'){
      this.rentingService.getCottageById(this.futureReservations[i].rentingItem.id).subscribe( res => {
        this.futureReservations[i].reservedRentingItem = res;
       // this.quickCottageReservationsCopy[i].action.rentingItem = res;
      });
    }
    else{
      this.rentingService.getFishingInstructorClassById(this.futureReservations[i].rentingItem.id).subscribe( res => {
        this.futureReservations[i].reservedRentingItem = res;
      });
    }
    this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureReservations[i].rentingItem.id).subscribe( res => {
      this.futureReservations[i].rentingItem.additionalServices = res;
    });
  }
  console.log(this.futureReservations);
   });
  }

  
  
}
