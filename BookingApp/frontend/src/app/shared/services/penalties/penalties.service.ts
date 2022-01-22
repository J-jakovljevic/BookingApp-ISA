import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { QuickReservationPenalty } from '../../models/QuickReservationPenalty';
import { ReservationPenalty } from '../../models/ReservationPenalty';

@Injectable({
  providedIn: 'root'
})
export class PenaltiesService {
  constructor(private http : HttpClient) { }
  getQuickReservationPenaltiesByClient(id : Number) : Observable<QuickReservationPenalty[]>{
    return this.http.get<QuickReservationPenalty[]>(`${environment.baseUrl}/${environment.quickReservationPenalties}/${environment.getByClient}?clientId=${id}`);
  }

  getReservationPenaltiesByClient(id : Number) : Observable<ReservationPenalty[]>{
    return this.http.get<ReservationPenalty[]>(`${environment.baseUrl}/${environment.reservationPenalties}/${environment.getByClient}?clientId=${id}`);
  }
}
