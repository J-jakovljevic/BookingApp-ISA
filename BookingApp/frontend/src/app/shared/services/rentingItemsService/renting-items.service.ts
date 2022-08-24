import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Boat } from '../../models/Boat';
import { Complaint } from '../../models/Complaint';
import { ComplaintReply } from '../../models/ComplaintReply';
import { Cottage } from '../../models/Cottage';
import { FishingInstructorClass } from '../../models/FishingInstructorClass';
import { RentingItem } from '../../models/reservations/RentingItem';
import { ReservedRentingItem } from '../../models/reservations/ReservedRentingItem';
import { Revision } from '../../models/Revision';

@Injectable({
  providedIn: 'root'
})
export class RentingItemsService {
  deleteCottage(id: Number) : Observable<Response>{
    return this.http.delete<Response>(`${environment.baseUrl}/${environment.cottages}/${environment.delete}?id=${id}`);
  }
  newCottage(cottage: Cottage): Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.cottages}/${environment.add}`,cottage);
  }

  constructor(private http : HttpClient) { }

  getMyCottages(ownerId : Number) : Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`${environment.baseUrl}/${environment.cottages}/${environment.myCottages}?ownerId=${ownerId}`);
  }

  getAllFishingInstructorClass() : Observable<FishingInstructorClass[]>{
    return this.http.get<FishingInstructorClass[]>(`${environment.baseUrl}/${environment.fishingInstructorClasses}/${environment.getAll}`);
  }

  getAllBoats() : Observable<Boat[]>{
    return this.http.get<Boat[]>(`${environment.baseUrl}/${environment.boats}/${environment.getAll}`);
  }

  getAllCottages() : Observable<Cottage[]>{
    return this.http.get<Cottage[]>(`${environment.baseUrl}/${environment.cottages}/${environment.getAll}`);
  }

  searchCottages(searchInput : String) : Observable<Cottage[]>{
    return this.http.get<Cottage[]>(`${environment.baseUrl}/${environment.cottages}/${environment.search}?searchInput=${searchInput}`);
  }

  searchMyCottages(searchInput : String) : Observable<Cottage[]>{
    return this.http.get<Cottage[]>(`${environment.baseUrl}/${environment.cottages}/${environment.searchMyCottages}?searchInput=${searchInput}`);
  }

  searchBoats(searchInput : String) : Observable<Boat[]>{
    return this.http.get<Boat[]>(`${environment.baseUrl}/${environment.boats}/${environment.search}?searchInput=${searchInput}`);
  }

  searchFishingInstructorClasses(searchInput : String) : Observable<FishingInstructorClass[]>{
    return this.http.get<FishingInstructorClass[]>(`${environment.baseUrl}/${environment.fishingInstructorClasses}/${environment.search}?searchInput=${searchInput}`);
  }

  getBoatById(id : Number) : Observable<ReservedRentingItem>{
    return this.http.get<ReservedRentingItem>(`${environment.baseUrl}/${environment.boats}/${environment.getById}?id=${id}`);
  }
  getCottageById(id : Number) : Observable<ReservedRentingItem>{
    return this.http.get<ReservedRentingItem>(`${environment.baseUrl}/${environment.cottages}/${environment.getById}?id=${id}`);
  }
  getFishingInstructorClassById(id : Number) : Observable<ReservedRentingItem>{
    return this.http.get<ReservedRentingItem>(`${environment.baseUrl}/${environment.fishingInstructorClasses}/${environment.getById}?id=${id}`);
  }
  getRentingItemById(id : Number) : Observable<RentingItem>{
    return this.http.get<RentingItem>(`${environment.baseUrl}/${environment.rentingItems}/${environment.getById}?id=${id}`);
  }

  createComplaint(complaint: Complaint) : Observable<Response>{
    return this.http.post<Response>(`${environment.baseUrl}/${environment.complaints}/${environment.add}`,complaint);
  }

  createComplaintReply(complaintReply: ComplaintReply) : Observable<Response>{
    return this.http.post<Response>(`${environment.baseUrl}/${environment.complaints}/${environment.addReply}`,complaintReply);
  }

  getReservedRentingItemById(id : Number) : Observable<ReservedRentingItem>{
    return this.http.get<ReservedRentingItem>(`${environment.baseUrl}/${environment.rentingItems}/${environment.getById}?id=${id}`);
  }

  createRevision(revision : Revision) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.revisions}/${environment.create}`,revision);
  }

  approveRevision(revisionId : Number): Observable<Response>{
    return this.http.post<Response>(`${environment.baseUrl}/${environment.revisions}/${environment.approveRevision}`,revisionId);
  }

  denyRevision(revisionId : Number) : Observable<Response>{
    return this.http.post<Response>(`${environment.baseUrl}/${environment.revisions}/${environment.denyRevision}`,revisionId);
  }

  getAllUnapprovedRevisions() : Observable<Revision[]>{
    return this.http.get<Revision[]>(`${environment.baseUrl}/${environment.revisions}/${environment.getAllUnapprovedRevisions}`);
  }

}
