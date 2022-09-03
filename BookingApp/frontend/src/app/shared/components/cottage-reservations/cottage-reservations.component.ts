import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintReply } from '../../models/ComplaintReply';
import { Reservation } from '../../models/Reservation';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { Revision } from '../../models/Revision';
import { RevisionReply } from '../../models/RevisionReply';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemAvailabilityService } from '../../services/rentingItemAvailability/renting-item-availability.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { UsersService } from '../../services/userService/users.service';
import { Action } from '../../models/reservations/Action';
import { ActionService } from '../../services/actionService/action.service';


@Component({
  selector: 'app-cottage-reservations',
  templateUrl: './cottage-reservations.component.html',
  styleUrls: ['./cottage-reservations.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CottageReservationsComponent implements OnInit {
  selectedTab: string;
  cottageSelected : boolean = false;
  cottage2Selected : boolean = false;
  complaintReplyMode : boolean = false;
  revisionReplyMode : boolean = false;
  selectedComplaint : any;
  selectedCottage : any;
  selectedRevision : Revision;
  previousReservations : Reservation[] = [];
  futureReservations : Reservation[] = [];
  previousQuickReservations : QuickReservation[] = [];
  futureQuickReservations : QuickReservation[] = [];
  dateSortType : String;
  dateSortType2 : String;
  rentingItemForComplaintReplyId : Number;
  selectedFutureReservation : any;
  futureReservationsSelected : boolean = false;
  futureReservations2Selected : boolean = false;
  description : string;
  reservationId : Number;
  actions : Action[];


  constructor(private reservationService : ReservationsService, private rentingService : RentingItemsService,
    private usersService: UsersService, private router: Router,private rentingItemAvailabilityService : RentingItemAvailabilityService,
    private authService:AuthService, private actionService : ActionService) { }

  ngOnInit() : void {
    this.getAllPreviousQuickReservationsForCottageOwner();
    this.getAllQuickFutureReservationsForCottageOwner();
    this.getAllPreviousReservationsForCottageOwner();
    this.getAllFutureReservationsForCottageOwner();
    this.getActions();
  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }

  logOut(){
    this.authService.logout();
  }

  getAllPreviousQuickReservationsForCottageOwner(){
    this.reservationService.getPreviousQuickReservationsForCottageOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.previousQuickReservations = res;
      for(let i = 0;i < this.previousQuickReservations.length; i++){
          this.rentingService.getCottageById(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
            this.previousQuickReservations[i].action.reservedRentingItem = res;
          });
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
          this.previousQuickReservations[i].action.rentingItem.additionalServices = res;
        });
      }
    });
  }

  getAllQuickFutureReservationsForCottageOwner(){
   this.reservationService.getFutureQuickReservationsForCottageOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.futureQuickReservations = res;
      for(let i = 0 ; i < this.futureQuickReservations.length ; i++){
      this.rentingService.getCottageById(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
        this.futureQuickReservations[i].action.reservedRentingItem = res;
      });
    this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
      this.futureQuickReservations[i].action.rentingItem.additionalServices = res;
    });
    }
   });
  }

  getRevisionByReservationId(reservationId : Number) : void {
    this.rentingService.getRevisionByReservationId(reservationId).subscribe(res => {
    this.selectedRevision = res;
    });

  }

  turnReplyRevsionModeOn(reservation : Reservation){
    this.reservationId = reservation.id;
    this.getRevisionByReservationId(this.reservationId);
    this.revisionReplyMode = true;
  }

  turnReplyRevsionModeOnForQR(reservation : QuickReservation){
    this.reservationId = reservation.action.id;
    this.getRevisionByReservationId(this.reservationId);
    this.revisionReplyMode = true;
  }

  turnMakeRevisionReplyModeOff(){
    this.revisionReplyMode = false;
  }

  makeRevisionReply(){
    var revisionReply = new RevisionReply(0,this.selectedRevision,this.authService.currentUser.user.id,
       this.description);
    this.rentingService.createRevisionReply(revisionReply).subscribe(res=>{
    });
    alert("Reply successfully created.");
    this.turnMakeRevisionReplyModeOff();
}

  showCottageDetails(id: Number): void{
    this.cottageSelected = true;
    this.selectedCottage = this.previousQuickReservations.find(reservation => reservation.id == id);
    console.log(this.selectedCottage);
  }

  showCottageDetails2(id: Number): void{
    this.cottage2Selected = true;
    this.selectedCottage = this.previousReservations.find(reservation => reservation.id == id);
    console.log(this.selectedCottage);
  }

  unselectCottage() : void{
    this.cottageSelected = false;
    this.cottage2Selected = false;
  }

  sortByDate(){
    if(this.dateSortType == 'Descending'){
      this.previousQuickReservations.sort(function(a : any,b : any){
        var date1 = new Date(a.action.startTime)
        var date2 = new Date(b.action.startTime)
        return date1.getTime() - date2.getTime();
      });
    }
    else{
      this.previousQuickReservations.sort(function(a : any,b : any){
        var date1 = new Date(a.action.startTime)
        var date2 = new Date(b.action.startTime)
        return date2.getTime() - date1.getTime();
      });
    }
  }

  sortByDate2(){
    if(this.dateSortType2 == 'Descending'){
      this.previousReservations.sort(function(a : any,b : any){
        var date1 = new Date(a.startTime)
        var date2 = new Date(b.startTime)
        return date1.getTime() - date2.getTime();
      });
    }
    else{
      this.previousReservations.sort(function(a : any,b : any){
        var date1 = new Date(a.startTime)
        var date2 = new Date(b.startTime)
        return date2.getTime() - date1.getTime();
      });
    }
  }

  getAllPreviousReservationsForCottageOwner(){
    this.reservationService.getPreviousReservationsForCottageOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.previousReservations = res;
      for(let i = 0;i < this.previousReservations.length; i++){
          this.rentingService.getCottageById(this.previousReservations[i].rentingItem.id).subscribe( res => {
            this.previousReservations[i].reservedRentingItem = res;
           // this.quickCottageReservationsCopy[i].action.rentingItem = res;
          });
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousReservations[i].rentingItem.id).subscribe( res => {
          this.previousReservations[i].rentingItem.additionalServices = res;
        });
    }
    });
  }

  getAllFutureReservationsForCottageOwner(){
    this.reservationService.getFutureReservationsForCottageOwner(this.authService.currentUser.user.id).subscribe( res => {
       this.futureReservations = res;
       console.log(this.futureReservations);
       for(let i = 0 ; i < this.futureReservations.length ; i++){
       this.rentingService.getCottageById(this.futureReservations[i].rentingItem.id).subscribe( res => {
         this.futureReservations[i].reservedRentingItem = res;
        // this.quickCottageReservationsCopy[i].action.rentingItem = res;
       });
     this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureReservations[i].rentingItem.id).subscribe( res => {
       this.futureReservations[i].rentingItem.additionalServices = res;
     });
   }
   console.log(this.futureReservations);
    });
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

    this.reservationService.cancelQuickReservationForCotaggeOwner(this.selectedFutureReservation.id).subscribe( res =>{
      alert("Succesfully cancelled reservation");
      this.getAllQuickFutureReservationsForCottageOwner();
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
    this.reservationService.cancelReservationForCotaggeOwner(this.selectedFutureReservation.id).subscribe( res =>{
      alert("Succesfully cancelled reservation");
      this.getAllFutureReservationsForCottageOwner();
      this.futureReservationsSelected = false;
      this.futureReservations2Selected = false;
    }); 
  }
}

getActions(){
  this.actionService.getActionsForCottageOwner(this.authService.currentUser.user.id).subscribe( res => {
    this.actions = res;
  });
}

}
