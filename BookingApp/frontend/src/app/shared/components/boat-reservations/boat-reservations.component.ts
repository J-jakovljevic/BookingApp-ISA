import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Boat } from '../../models/Boat';
import { Reservation } from '../../models/Reservation';
import { Action } from '../../models/reservations/Action';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { Revision } from '../../models/Revision';
import { RevisionReply } from '../../models/RevisionReply';
import { ActionService } from '../../services/actionService/action.service';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemAvailabilityService } from '../../services/rentingItemAvailability/renting-item-availability.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { UsersService } from '../../services/userService/users.service';


@Component({
  selector: 'app-boat-reservations',
  templateUrl: './boat-reservations.component.html',
  styleUrls: ['./boat-reservations.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BoatReservationsComponent implements OnInit {
  selectedTab: string;
  boatSelected : boolean = false;
  boat2Selected : boolean = false;
  actionSelected : boolean = false;
  futureReservationsSelected = false;
  futureReservations2Selected = false;
  complaintReplyMode : boolean = false;
  profitCalculatorMode : boolean = false;
  revisionReplyMode : boolean = false;
  clientProfileMode : boolean = false;
  selectedBoat : any;
  selectedAction : any;
  selectedRevision : Revision;
  previousReservations : Reservation[] = [];
  futureReservations : Reservation[] = [];
  previousQuickReservations : QuickReservation[] = [];
  futureQuickReservations : QuickReservation[] = [];
  dateSortType : String;
  dateSortType2 : String;
  rentingItemForComplaintReplyId : Number;
  reservationId : Number;
  description : string;
  selectedFutureReservation : any;
  actions : Action[];
  selectedClient : any;
  profit : Number;
  profitQR : Number;
  sum : any;
  calculateForm : FormGroup;


  constructor(private reservationService : ReservationsService, private rentingService : RentingItemsService,
    private usersService: UsersService, private router: Router,private rentingItemAvailabilityService : RentingItemAvailabilityService,
    private authService:AuthService, private actionService : ActionService, private userService : UsersService) { }

  ngOnInit(): void {
    this.getAllPreviousQuickReservationsForBoatOwner();
    this.getAllQuickFutureReservationsForBoatOwner();
    this.getAllPreviousReservationsForBoatOwner();
    this.getAllFutureReservationsForBoatOwner();
    this.getActions();
    this.calculateForm = new FormGroup({
      'fromDate' : new FormControl(null, [Validators.required])
    });

  }

  selectionChanged(selectedItem : string): void{
    this.selectedTab = selectedItem;
  }

  getAllPreviousQuickReservationsForBoatOwner(){
    this.reservationService.getPreviousQuickReservationsForBoatOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.previousQuickReservations = res;
      for(let i = 0;i < this.previousQuickReservations.length; i++){
          this.rentingService.getBoatById(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
            this.previousQuickReservations[i].action.reservedRentingItem = res;
          });
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousQuickReservations[i].action.rentingItem.id).subscribe( res => {
          this.previousQuickReservations[i].action.rentingItem.additionalServices = res;
        });
      }
    });
  }

  getAllQuickFutureReservationsForBoatOwner(){
    this.reservationService.getFutureQuickReservationsForBoatOwner(this.authService.currentUser.user.id).subscribe( res => {
       this.futureQuickReservations = res;
       for(let i = 0 ; i < this.futureQuickReservations.length ; i++){
       this.rentingService.getBoatById(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
         this.futureQuickReservations[i].action.reservedRentingItem = res;
       });
     this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureQuickReservations[i].action.rentingItem.id).subscribe( res => {
       this.futureQuickReservations[i].action.rentingItem.additionalServices = res;
     });
     }
    });
   }

   getAllPreviousReservationsForBoatOwner(){
    this.reservationService.getPreviousReservationsForBoatOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.previousReservations = res;
      for(let i = 0;i < this.previousReservations.length; i++){
          this.rentingService.getBoatById(this.previousReservations[i].rentingItem.id).subscribe( res => {
            this.previousReservations[i].reservedRentingItem = res;
           // this.quickCottageReservationsCopy[i].action.rentingItem = res;
          });
        this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.previousReservations[i].rentingItem.id).subscribe( res => {
          this.previousReservations[i].rentingItem.additionalServices = res;
        });
    }
    });
  }

  getAllFutureReservationsForBoatOwner(){
    this.reservationService.getFutureReservationsForBoatOwner(this.authService.currentUser.user.id).subscribe( res => {
       this.futureReservations = res;
       console.log(this.futureReservations);
       for(let i = 0 ; i < this.futureReservations.length ; i++){
       this.rentingService.getBoatById(this.futureReservations[i].rentingItem.id).subscribe( res => {
         this.futureReservations[i].reservedRentingItem = res;
        // this.quickCottageReservationsCopy[i].action.rentingItem = res;
       });
     this.rentingItemAvailabilityService.getAdditionalServicesByRentingItem(this.futureReservations[i].rentingItem.id).subscribe( res => {
       this.futureReservations[i].rentingItem.additionalServices = res;
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

  turnClientProfileModeOnForQR(reservation : QuickReservation){
    this.selectedClient = reservation.client
    this.clientProfileMode = true;
  }

  turnClientProfileModeOn(reservation : Reservation){
    this.userService.getClientById(reservation.clientId).subscribe( res => {
      this.selectedClient = res;
    });
    this.clientProfileMode = true;
  }

  turnClientProfileModeOff(){
    this.clientProfileMode = false;
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

showBoatDetails(id: Number): void{
  this.boatSelected = true;
  this.selectedBoat = this.previousQuickReservations.find(reservation => reservation.id == id);
  console.log(this.selectedBoat);
}

showBoatDetails2(id: Number): void{
  this.boat2Selected = true;
  this.selectedBoat = this.previousReservations.find(reservation => reservation.id == id);
  console.log(this.selectedBoat);
}


  logOut(){
    this.authService.logout();
  }

  unselectBoat() : void{
    this.boatSelected = false;
    this.boat2Selected = false;
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

    this.reservationService.cancelQuickReservationForBoatOwner(this.selectedFutureReservation.id).subscribe( res =>{
      alert("Succesfully cancelled reservation");
      this.getAllQuickFutureReservationsForBoatOwner();
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
    this.reservationService.cancelReservationForBoatOwner(this.selectedFutureReservation.id).subscribe( res =>{
      alert("Succesfully cancelled reservation");
      this.getAllFutureReservationsForBoatOwner();
      this.futureReservationsSelected = false;
      this.futureReservations2Selected = false;
    }); 
  }
  }

  getActions(){
    this.actionService.getActionsForBoatOwner(this.authService.currentUser.user.id).subscribe( res => {
      this.actions = res;
    });
  }

  turnProfitCalculatorModeOn() : void{
    this.profitCalculatorMode = true;
  }
  
  turnProfitCalculatorModeOff() : void{
    this.profitCalculatorMode = false;
  }
  
  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }
  
  
  async calculate() : Promise<void>{
    this.reservationService.calculateBoatProfitForReservations(this.authService.currentUser.user.id, this.calculateForm.value.fromDate).subscribe(res => {
      this.profit = res;
    });
    await this.delay(250);
    this.reservationService.calculateBoatProfitForQR(this.authService.currentUser.user.id, this.calculateForm.value.fromDate).subscribe(res => {
      this.profitQR = res;
    });
    await this.delay(250);
    this.sum = this.profit.valueOf() + this.profitQR.valueOf();
    alert("Od izabranog datuma zaradili ste "+this.sum+"€.")
    console.log(this.sum);
  }

  async showActionDetails(id : Number): Promise<void>{
    this.actionService.getActionById(id).subscribe( res => {
      this.selectedAction=res;
    });
    await this.delay(500);
    this.rentingService.getBoatById(this.selectedAction.rentingItemId).subscribe( res => {
      this.selectedAction.rentingItem=res;
    });
    this.actionSelected = true;
    console.log(this.selectedAction);
  }
  
  unselectAction() : void{
    this.actionSelected = false;
  }
  
  deleteAction(actionId : Number) : void{
    this.actionService.deleteAction(actionId).subscribe( res => {
    });
    this.actionSelected = false;
  }

}
