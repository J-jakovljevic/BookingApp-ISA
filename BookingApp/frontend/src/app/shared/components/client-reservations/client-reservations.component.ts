import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Router } from '@angular/router';
import { Action } from 'rxjs/internal/scheduler/Action';
import { Complaint } from '../../models/Complaint';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { AuthService } from '../../services/authService/auth.service';
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
  boatReservations : QuickReservation[];
  cottageReservations : QuickReservation[];
  fishingInstructorClassReservations : QuickReservation[];
  selectedTab: string;
  cottageSelected : boolean = false;
  selectedCottage : any;
  boatSelected : boolean = false;
  selectedBoat : any;
  fishingInstructorClassSelected : boolean = false;
  selectedFishingInstructorClass : any;
  fishingInstructor : FishingInstructor;
  futureReservationsSelected : boolean = false;
  futureReservations : QuickReservation[] = [];
  futureBoatReservations : QuickReservation[] = [];
  futureCottageReservations : QuickReservation[] = [];
  futureFishingInstructorClassReservations : QuickReservation[] = [];
  selectedFutureReservation : any;
  description : string;
  complaintMode : boolean = false;
  reservationForComplaint : QuickReservation;
  

  constructor(private reservationService : ReservationsService
    ,private authService : AuthService, private rentingService : RentingItemsService,
    private usersService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.reservationService.getAllBoatReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.boatReservations = res;
      for(let i = 0;i < this.boatReservations.length; i++){
        this.rentingService.getBoatById(this.boatReservations[i].action.rentingItemId).subscribe( res => {
          this.boatReservations[i].action.rentingItem = res;
        });
      }
      console.log(this.boatReservations);
    });

    this.reservationService.getAllCottagReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.cottageReservations = res;
      for(let i = 0;i < this.cottageReservations.length; i++){
        this.rentingService.getCottageById(this.cottageReservations[i].action.rentingItemId).subscribe( res => {
          this.cottageReservations[i].action.rentingItem = res;
        });
      }
      console.log(this.cottageReservations);
    });
    this.reservationService.getAllFishingInstructorClassReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.fishingInstructorClassReservations = res;
      for(let i = 0;i < this.fishingInstructorClassReservations.length; i++){
        this.rentingService.getFishingInstructorClassById(this.fishingInstructorClassReservations[i].action.rentingItemId).subscribe( res => {
          this.fishingInstructorClassReservations[i].action.rentingItem = res;
        });
      }
      console.log(this.fishingInstructorClassReservations);
    });

    this.getAllFutureReservationsForClient();
   
  }
  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }
  showCottageDetails(id: Number): void{
    this.cottageSelected = true;
    this.selectedCottage = this.cottageReservations.find(reservation => reservation.id == id);
  }

  unselectCottage() : void{
    this.cottageSelected = false;
  }

  showBoatDetails(id: Number): void{
    this.boatSelected = true;
    this.selectedBoat = this.boatReservations.find(reservation => reservation.id == id);
  }

  unselectBoat() : void{
    this.boatSelected = false;
  }

  showFishingInstructorClassDetails(id: Number): void{
    this.fishingInstructorClassSelected = true;
    this.selectedFishingInstructorClass = this.fishingInstructorClassReservations.find(reservation => reservation.id == id);
    this.usersService.getFishingInstructorById(this.selectedFishingInstructorClass.fishingInstructorId).subscribe(res => {
      this.fishingInstructor = res;
    });
  }

  unselectFishingInstructorClass() : void{
    this.fishingInstructorClassSelected = false;
  }
  unselectFutureReservations() : void{
    this.futureReservationsSelected = false;
  }

  showFutureReservationDetails(id: Number){
    this.futureReservationsSelected = true;
    this.selectedFutureReservation = this.futureReservations.find(reservation => reservation.id == id);
  }

  cancelReservation(reservation : QuickReservation){
      var currentDate = new Date();
    if( new Date(reservation.action.startTime).getTime() - currentDate.getTime() < 1000 * 3600 * 24 * 3 ) {
      alert('Reservation cancellation unsuccessfull. You could cancel reservation at least' +
      'three days before beginning of an Action.')
    }
    else{
      this.reservationService.cancelReservationsForClient(reservation.id).subscribe( res =>{
        alert("Succesfully cancelled reservation");
        this.getAllFutureReservationsForClient();
        window.location.reload();
      }); 
    }
    
  }

  turnMakeComplaintModeOn(reservation : QuickReservation){
    this.reservationForComplaint = reservation;
    this.complaintMode = true;
  }

  turnMakeComplaintModeOff(){
    this.complaintMode = false;
  }

  makeComplaint(){
      var complaint = new Complaint(0,this.authService.currentUser.user.id,
        this.reservationForComplaint.action.rentingItemId, this.description);
      this.rentingService.createComplaint(complaint).subscribe(res=>{
          alert("Complaint successfully created.");
          this.turnMakeComplaintModeOff();
      });
  }

  getAllFutureReservationsForClient(){
    this.reservationService.getFutureBoatReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.futureBoatReservations = res;
      for(let i = 0;i < this.futureBoatReservations.length; i++){
        this.rentingService.getBoatById(this.futureBoatReservations[i].action.rentingItemId).subscribe( res => {
          this.futureBoatReservations[i].action.rentingItem = res;
          this.futureReservations.push(this.futureBoatReservations[i]);
        });
      }
    });

    this.reservationService.getFutureCottageReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.futureCottageReservations = res;
      for(let i = 0;i < this.futureCottageReservations.length; i++){
        this.rentingService.getCottageById(this.futureCottageReservations[i].action.rentingItemId).subscribe( res => {
          this.futureCottageReservations[i].action.rentingItem = res;
          this.futureReservations.push(this.futureCottageReservations[i]);
        });
      }
    });

    this.reservationService.getFutureFishingInstructorClassReservationsForClient(this.authService.currentUser.user.id).subscribe( res => {
      this.futureFishingInstructorClassReservations = res;
      for(let i = 0;i < this.futureFishingInstructorClassReservations.length; i++){
        this.rentingService.getFishingInstructorClassById(this.futureFishingInstructorClassReservations[i].action.rentingItemId).subscribe( res => {
          this.futureFishingInstructorClassReservations[i].action.rentingItem = res;
          this.futureReservations.push(this.futureFishingInstructorClassReservations[i]);
        });
      }
    });
  }


}
