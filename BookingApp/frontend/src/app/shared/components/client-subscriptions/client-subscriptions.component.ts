import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Action } from '../../models/reservations/Action';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { Subscription } from '../../models/Subscription';
import { ActionService } from '../../services/actionService/action.service';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';
import { SubscriptionsService } from '../../services/subscriptions/subscriptions.service';

@Component({
  selector: 'app-client-subscriptions',
  templateUrl: './client-subscriptions.component.html',
  styleUrls: ['./client-subscriptions.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientSubscriptionsComponent implements OnInit {
  subscriptionsForClient: Subscription[];
  subscriptionsLoaded: Promise<boolean>;
  currentActions : Action[];
  constructor(private subscriptionService : SubscriptionsService,private rentingItemService: RentingItemsService,
    private authService:AuthService , private actionService : ActionService,private reservationService : ReservationsService) { }

   ngOnInit(): void {
    this.loadSubscriptions()
    this.loadCurrentActions()
   
  }

  unsubscribe(subscriptionId : Number){
    this.subscriptionService.unsubscribe(subscriptionId).subscribe(res =>{
       this.loadSubscriptions();
    });
  }

  loadSubscriptions(){
      this.subscriptionService.getAllByClient(this.authService.currentUser.user.id).subscribe(res =>{
        this.subscriptionsForClient = res;
        for(let i = 0 ; i < this.subscriptionsForClient.length; i++){
          this.rentingItemService.getRentingItemById(this.subscriptionsForClient[i].rentingItemId).subscribe(res=>{
            this.subscriptionsForClient[i].rentingItem =res;
          });
        }
        console.log(this.subscriptionsForClient);
      });
  }

  loadCurrentActions(){
      this.actionService.getActionsForClient(this.authService.currentUser.user.id).subscribe( res =>{
        this.currentActions = res;
        for(let i = 0; i < this.currentActions.length ; i++){
          this.rentingItemService.getReservedRentingItemById(this.currentActions[i].rentingItemId).subscribe( res => {
             this.currentActions[i].reservedRentingItem = res;
          });
        }
        console.log(this.currentActions);
      });
  }

  
  logOut(){
    this.authService.logout();
  }

  createQuickReservation(action : any){
    this.reservationService.cancelledQuickReservationExists(this.authService.currentUser.user.id,action.id).subscribe( res => {
      if(res){
        alert('You already cancelled this action, so you are not able anymore to reserve it.');
      }
      else{
        var newQuickReservation = new QuickReservation(0,this.authService.currentUser.user,action);
        this.reservationService.createQuickReservation(newQuickReservation).subscribe(res => {
          alert("Successfully reserved action!");
          this.loadCurrentActions();
        });
      }
    })

  }
}