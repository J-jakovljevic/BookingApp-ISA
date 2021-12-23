import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Penalty } from '../../models/Penalty';
import { AuthService } from '../../services/authService/auth.service';
import { PenaltiesService } from '../../services/penalties/penalties.service';
import { ReservationsService } from '../../services/reservations/reservations.service';

@Component({
  selector: 'app-client-penalties',
  templateUrl: './client-penalties.component.html',
  styleUrls: ['./client-penalties.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClientPenaltiesComponent implements OnInit {
  penaltiesForClient : Penalty[];

  constructor(private authService : AuthService,private penaltyService : PenaltiesService,
    private quickReservationsService :ReservationsService) { }

  ngOnInit(): void {
    this.penaltyService.getByClient(this.authService.currentUser.user.id).subscribe(res => {
      this.penaltiesForClient = res;
      console.log(this.penaltiesForClient);
    //  for( let i=0; i < this.penaltiesForClient.length;i++){
     //   this.quickReservationsService.
     // }
    });
  }

}
