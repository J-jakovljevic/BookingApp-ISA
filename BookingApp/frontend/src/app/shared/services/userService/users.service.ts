import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../../models/Client';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { Complaint } from '../../models/Complaint';
import { DeleteAccountRequestReplyDTO } from '../../models/DeleteAccountRequestReplyDTO';
import { CottageOwner } from '../../models/users/CottageOwner';
import { BoatOwner } from '../../models/users/BoatOwner';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http : HttpClient) { }


  registerClient(client : Client) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.clients}/${environment.register}`,client);
  }

  registerCottageOwner(cottageOwner : CottageOwner) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.cottageOwners}/${environment.register}`,cottageOwner);
  }

  registerBoatOwner(boatOwner : BoatOwner) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.boatOwners}/${environment.register}`,boatOwner);
  }

  getAllClients() : Observable<Client[]>{
    return this.http.get<Client[]>(`${environment.baseUrl}/${environment.clients}/${environment.getAll}`);
  }

  getFishingInstructorById(id: Number) : Observable<FishingInstructor>{
    return this.http.get<FishingInstructor>(`${environment.baseUrl}/${environment.fishingInstructors}/${environment.getById}?id=${id}`);
  }

  getClientById(id: Number) : Observable<Client>{
    return this.http.get<Client>(`${environment.baseUrl}/${environment.clients}/${environment.getById}?id=${id}`);
  }

  getCottageOwnerById(id: Number) : Observable<CottageOwner>{
    return this.http.get<CottageOwner>(`${environment.baseUrl}/${environment.cottageOwners}/${environment.getById}?id=${id}`);
  }

  getBoatOwnerById(id: Number) : Observable<BoatOwner>{
    return this.http.get<BoatOwner>(`${environment.baseUrl}/${environment.boatOwners}/${environment.getById}?id=${id}`);
  }

  updateClient(client : Client) : Observable<Client> {
    return this.http.put<Client>(`${environment.baseUrl}/${environment.clients}/${environment.update}`,client);
  }

  updateCottageOwner(cottageOwner : CottageOwner) : Observable<CottageOwner> {
    return this.http.put<CottageOwner>(`${environment.baseUrl}/${environment.cottageOwners}/${environment.update}`, cottageOwner);
  }

  updateBoatOwner(boatOwner : CottageOwner) : Observable<BoatOwner> {
    return this.http.put<BoatOwner>(`${environment.baseUrl}/${environment.boatOwners}/${environment.update}`, boatOwner);
  }

  createDeleteAccountRequest(deleteAccReq : DeleteAccountRequest) : Observable<DeleteAccountRequest> {
    return this.http.post<DeleteAccountRequest>(`${environment.baseUrl}/${environment.deleteAccountRequests}/${environment.add}`,deleteAccReq);
  }

  getAllFishingInstructors() : Observable<FishingInstructor[]>{
    return this.http.get<FishingInstructor[]>(`${environment.baseUrl}/${environment.fishingInstructors}/${environment.getAll}`);
  }

  searchFishingInstructors(searchInput : String) : Observable<FishingInstructor[]>{
    return this.http.get<FishingInstructor[]>(`${environment.baseUrl}/${environment.fishingInstructors}/${environment.search}?searchInput=${searchInput}`);
  }

  getAllCottageOwners() : Observable<CottageOwner[]>{
    return this.http.get<CottageOwner[]>(`${environment.baseUrl}/${environment.cottageOwners}/${environment.getAll}`);
  }

  searchCottageOwners(searchInput : String) : Observable<CottageOwner[]>{
    return this.http.get<CottageOwner[]>(`${environment.baseUrl}/${environment.cottageOwners}/${environment.search}?searchInput=${searchInput}`);
  }

  getAllComplaints(): Observable<Complaint[]>{
    return this.http.get<Complaint[]>(`${environment.baseUrl}/${environment.complaints}/${environment.getAll}`);
  }
  
  getAllDeleteAccountRequests() : Observable<DeleteAccountRequest[]>{
    return this.http.get<DeleteAccountRequest[]>(`${environment.baseUrl}/${environment.deleteAccountRequests}/${environment.getAll}`);
  }
  approveDeleteAccountRequest(deleteAccReq : DeleteAccountRequestReplyDTO) : Observable<DeleteAccountRequest> {
    return this.http.post<DeleteAccountRequest>(`${environment.baseUrl}/${environment.deleteAccountRequests}/${environment.approve}`,deleteAccReq);
  }
  denyDeleteAccountRequest(deleteAccReq : DeleteAccountRequestReplyDTO) : Observable<DeleteAccountRequest> {
    return this.http.post<DeleteAccountRequest>(`${environment.baseUrl}/${environment.deleteAccountRequests}/${environment.deny}`,deleteAccReq);
  }


}
