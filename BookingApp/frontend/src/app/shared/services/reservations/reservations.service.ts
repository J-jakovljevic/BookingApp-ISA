import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Reservation } from '../../models/Reservation';
import { QuickReservation } from '../../models/reservations/QuickReservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  constructor(private http: HttpClient) { }

  getPreviousQuickReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getPreviousReservationsByClient}?clientId=${clientId}`);
  }
  getFutureQuickReservationsForClient(clientId : Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureReservationsByClient}?clientId=${clientId}`);
  }
  cancelQuickReservationForClient(reservationId : Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
  createQuickReservation(quickRes : QuickReservation) : Observable<QuickReservation>{
    return this.http.post<QuickReservation>(`${environment.baseUrl}/${environment.quickReservations}/${environment.create}`,quickRes);
  }

  createReservation(reservation : Reservation) : Observable<Reservation>{
    return this.http.post<Reservation>(`${environment.baseUrl}/${environment.reservations}/${environment.create}`,reservation);
  }

  getPreviousReservationsForClient(clientId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getPreviousReservationsByClient}?clientId=${clientId}`);
  }

  getFutureReservationsForClient(clientId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getFutureReservationsByClient}?clientId=${clientId}`);
  }

  cancelReservationForClient(reservationId : Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }

  getQuickReservationById(id : Number) : Observable<QuickReservation>{
    return this.http.get<QuickReservation>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getById}?id=${id}`);
  }

  getReservationById(id : Number) : Observable<Reservation>{
    return this.http.get<Reservation>(`${environment.baseUrl}/${environment.reservations}/${environment.getById}?id=${id}`);
  }
}
