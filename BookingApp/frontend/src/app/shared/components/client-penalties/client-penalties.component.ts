import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { QuickReservationPenalty } from '../../models/QuickReservationPenalty';
import { ReservationPenalty } from '../../models/ReservationPenalty';
import { AuthService } from '../../services/authService/auth.service';
import { PenaltiesService } from '../../services/penalties/penalties.service';
import { RentingItemsService } from '../../services/rentingItemsService/renting-items.service';
import { ReservationsService } from '../../services/reservations/reservations.service';

@Component({
  selector: 'app-client-penalties',
  templateUrl: './client-penalties.component.html',
  styleUrls: ['./client-penalties.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientPenaltiesComponent implements OnInit {
  quickReservationPenaltiesForClient : QuickReservationPenalty[];
  reservationPenaltiesForClient : ReservationPenalty[];

  constructor(private authService : AuthService,private penaltyService : PenaltiesService,
    private quickReservationsService : ReservationsService,private rentingItemService : RentingItemsService) { }

  ngOnInit(): void {
    this.penaltyService.getQuickReservationPenaltiesByClient(this.authService.currentUser.user.id).subscribe(res => {
      this.quickReservationPenaltiesForClient = res;
      for(let i = 0 ; i < this.quickReservationPenaltiesForClient.length; i ++){
        this.quickReservationsService.getQuickReservationById(this.quickReservationPenaltiesForClient[i].quickReservationId).subscribe(res =>{
          this.quickReservationPenaltiesForClient[i].quickReservation = res;
        });
      }
      console.log(this.quickReservationPenaltiesForClient);
    });
    this.penaltyService.getReservationPenaltiesByClient(this.authService.currentUser.user.id).subscribe(res => {
      this.reservationPenaltiesForClient = res;
      for(let i = 0 ; i < this.reservationPenaltiesForClient.length; i ++){
        this.quickReservationsService.getReservationById(this.reservationPenaltiesForClient[i].reservationId).subscribe(res =>{
          this.reservationPenaltiesForClient[i].reservation = res;
        });
      }
      console.log(this.reservationPenaltiesForClient);
    });
  }

  
  logOut(){
    this.authService.logout();
  }

}
