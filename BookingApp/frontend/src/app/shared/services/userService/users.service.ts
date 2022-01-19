import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../../models/Client';
import { FishingInstructor } from '../../models/users/FishingInstructor';
import { DeleteAccountRequest } from '../../models/DeleteAccountRequest';
import { Complaint } from '../../models/Complaint';
import { DeleteAccountRequestReplyDTO } from '../../models/DeleteAccountRequestReplyDTO';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http : HttpClient) { }

  registerClient(client : Client) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.clients}/${environment.register}`,client);
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

  updateClient(client : Client) : Observable<Client> {
    return this.http.put<Client>(`${environment.baseUrl}/${environment.clients}/${environment.update}`,client);
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
