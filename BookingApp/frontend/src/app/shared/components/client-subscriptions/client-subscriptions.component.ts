import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Subscription } from '../../models/Subscription';
import { AuthService } from '../../services/authService/auth.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
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
  constructor(private subscriptionService : SubscriptionsService,private rentingItemService: RentingItemsService,
    private authService:AuthService) { }

   ngOnInit(): void {
    this.loadSubscriptions()
   
  }

  unsubscribe(subscriptionId : Number){
    this.subscriptionService.unsubscribe(subscriptionId).subscribe(res =>{
      console.log(res);
    });
  }

  loadSubscriptions(){
    this.subscriptionsLoaded = new Promise((resolve, reject) => {
      this.subscriptionService.getAllByClient(this.authService.currentUser.user.id).subscribe(res =>{
        this.subscriptionsForClient = res;
        for(let i = 0 ; i < this.subscriptionsForClient.length; i++){
          this.rentingItemService.getRentingItemById(this.subscriptionsForClient[i].rentingItemId).subscribe(res=>{
            this.subscriptionsForClient[i].rentingItem =res;
          });
        }
      });
      resolve(true);
    });
  }
}