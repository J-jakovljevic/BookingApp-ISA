import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from '../../models/Reservation';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemAvailabilityService } from '../../services/rentingItemAvailability/renting-item-availability.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { UsersService } from '../../services/userService/users.service';

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
  selectedCottage : any;
  previousReservations : Reservation[] = [];
  futureReservations : Reservation[] = [];
  previousQuickReservations : QuickReservation[] = [];
  futureQuickReservations : QuickReservation[] = [];
  dateSortType : String;
  dateSortType2 : String;
  rentingItemForComplaintReplyId : Number;


  constructor(private reservationService : ReservationsService, private rentingService : RentingItemsService,
    private usersService: UsersService, private router: Router,private rentingItemAvailabilityService : RentingItemAvailabilityService,private authService:AuthService) { }

  ngOnInit() : void {
    this.getAllPreviousQuickReservationsForCottageOwner();
    this.getAllQuickFutureReservationsForCottageOwner();
    
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

  turnReplyComplaintModeOn(reservation : any){
    this.rentingItemForComplaintReplyId = reservation;
    console.log(this.rentingItemForComplaintReplyId);
    this.complaintReplyMode = true;
  }

  turnMakeComplaintModeOff(){
    this.complaintReplyMode = false;
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

}
