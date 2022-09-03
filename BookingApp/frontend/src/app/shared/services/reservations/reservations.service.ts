import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CancellationCheckDTO } from '../../models/CancellationCheck';
import { Reservation } from '../../models/Reservation';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { RevisionReply } from '../../models/RevisionReply';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {
  constructor(private http: HttpClient) { }

  cancelQuickReservationForCotaggeOwner(reservationId:Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
  cancelReservationForCotaggeOwner(reservationId : Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
  cancelQuickReservationForBoatOwner(reservationId:Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
  cancelReservationForBoatOwner(reservationId : Number) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.cancelReservation}?reservationId=${reservationId}`,null);
  }
  getFutureQuickReservationsForCottageOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getPreviousReservationsByCottageOwner}?id=${id}`);
  }
  getPreviousQuickReservationsForCottageOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureReservationsByCottageOwner}?id=${id}`);
  }

  getFutureQuickReservationsForBoatOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getPreviousReservationsByBoatOwner}?id=${id}`);
  }

  getPreviousQuickReservationsForBoatOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureReservationsByBoatOwner}?id=${id}`);
  }

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

  getPreviousReservationsForCottageOwner(cottageOwnerId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getPreviousReservationsByCottageOwner}?cottageOwnerId=${cottageOwnerId}`);
  }

  getFutureReservationsForCottageOwner(cottageOwnerId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getFutureReservationsByCottageOwner}?cottageOwnerId=${cottageOwnerId}`);
  }

  getPreviousReservationsForBoatOwner(boatOwnerId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getPreviousReservationsByBoatOwner}?boatOwnerId=${boatOwnerId}`);
  }

  getFutureReservationsForBoatOwner(boatOwnerId : Number) : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getFutureReservationsByBoatOwner}?boatOwnerId=${boatOwnerId}`);
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

  cancelledQuickReservationExists(clientId : Number, actionId : Number) : Observable<boolean>{
    return this.http.get<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.cancelledReservationExists}?actionId=${actionId}&clientId=${clientId}`);
  }

  cancelledReservationExists(dto : CancellationCheckDTO) : Observable<boolean>{
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.cancelledReservationExists}`,dto);
  }
}
