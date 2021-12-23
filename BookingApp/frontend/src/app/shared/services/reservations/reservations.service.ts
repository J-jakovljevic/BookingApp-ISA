import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { QuickReservation } from '../../models/reservations/QuickReservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  constructor(private http: HttpClient) { }

  getAllBoatReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getBoatReservationsByClient}?clientId=${clientId}`);
  }

  getAllCottagReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getCottageReservationsByClient}?clientId=${clientId}`);
  }
  getAllFishingInstructorClassReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFishingInstructorClassReservationsByClient}?clientId=${clientId}`);
  }
  getFutureBoatReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureBoatReservationsByClient}?clientId=${clientId}`);
  }
  getFutureCottageReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureCottageReservationsByClient}?clientId=${clientId}`);
  }
  getFutureFishingInstructorClassReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureFishingInstructorClassReservationsByClient}?clientId=${clientId}`);
  }
  cancelReservationsForClient(reservationId : Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
}
