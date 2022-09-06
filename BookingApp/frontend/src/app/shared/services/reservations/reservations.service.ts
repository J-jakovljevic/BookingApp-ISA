import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CancellationCheckDTO } from '../../models/CancellationCheck';
import { Reservation } from '../../models/Reservation';
import { Action } from '../../models/reservations/Action';
import { QuickReservation } from '../../models/reservations/QuickReservation';
import { RevisionReply } from '../../models/RevisionReply';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {
  
  constructor(private http: HttpClient) { }

  calculateCottageProfitForReservations(cottageOwnerId : Number, startDate : Date) {
    return this.http.get<Number>(`${environment.baseUrl}/${environment.reservations}/${environment.calculateCottageProfitForReservations}/${cottageOwnerId}?startDate=${startDate}`);
  }

  calculateCottageProfitForQR(cottageOwnerId : Number, startDate : Date) {
    return this.http.get<Number>(`${environment.baseUrl}/${environment.quickReservations}/${environment.calculateCottageProfitForQR}/${cottageOwnerId}?startDate=${startDate}`);
  }

  calculateBoatProfitForReservations(boatOwnerId : Number, startDate : Date) {
    return this.http.get<Number>(`${environment.baseUrl}/${environment.reservations}/${environment.calculateBoatProfitForReservations}/${boatOwnerId}?startDate=${startDate}`);
  }

  calculateBoatProfitForQR(boatOwnerId : Number, startDate : Date) {
    return this.http.get<Number>(`${environment.baseUrl}/${environment.quickReservations}/${environment.calculateBoatProfitForQR}/${boatOwnerId}?startDate=${startDate}`);
  }

  checkPeriod(cottageId: Number, action: Action) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriod}/${cottageId}`,action);
  }

  checkPeriodQR(cottageId: Number, action: Action) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriodQR}/${cottageId}`,action);
  }

  checkPeriodForBoat(boatId: Number, action: Action) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriodForBoat}/${boatId}`,action);
  }

  checkPeriodQRForBoat(boatId: Number, action: Action) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriodQRForBoat}/${boatId}`,action);
  }

  checkPeriodForReservation(cottageId: Number, reservation: Reservation) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriodForReservation}/${cottageId}`,reservation);
  }

  checkPeriodQRForReservation(cottageId: Number, reservation: Reservation) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.checkPeriodQRForReservation}/${cottageId}`,reservation);
  }

  checkPeriodForReservationForBoat(boatId: Number, reservation: Reservation) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.reservations}/${environment.checkPeriodForReservationForBoat}/${boatId}`,reservation);
  }

  checkPeriodQRForReservationForBoat(boatId: Number, reservation: Reservation) {
    return this.http.post<boolean>(`${environment.baseUrl}/${environment.quickReservations}/${environment.checkPeriodQRForReservationForBoat}/${boatId}`,reservation);
  }

  getFutureReservationsForCottage(cottageId: Number) {
    return this.http.get<Reservation[]>(`${environment.baseUrl}/${environment.reservations}/${environment.getFutureReservationsForCottage}?cottageId=${cottageId}`);
  }

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
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureReservationsByCottageOwner}?id=${id}`);
  }
  getPreviousQuickReservationsForCottageOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getPreviousReservationsByCottageOwner}?id=${id}`);
  }

  getFutureQuickReservationsForBoatOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getFutureReservationsByBoatOwner}?id=${id}`);
  }

  getPreviousQuickReservationsForBoatOwner(id: Number) : Observable<QuickReservation[]>{
    return this.http.get<QuickReservation[]>(`${environment.baseUrl}/${environment.quickReservations}/${environment.getPreviousReservationsByBoatOwner}?id=${id}`);
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
