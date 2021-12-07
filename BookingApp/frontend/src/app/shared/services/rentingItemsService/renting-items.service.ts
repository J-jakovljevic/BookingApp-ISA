import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Boat } from '../../models/Boat';
import { Cottage } from '../../models/Cottage';
import { FishingInstructorClass } from '../../models/FishingInstructorClass';

@Injectable({
  providedIn: 'root'
})
export class RentingItemsService {

  constructor(private http : HttpClient) { }
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

  searchBoats(searchInput : String) : Observable<Boat[]>{
    return this.http.get<Boat[]>(`${environment.baseUrl}/${environment.boats}/${environment.search}?searchInput=${searchInput}`);
  }

  searchFishingInstructorClasses(searchInput : String) : Observable<FishingInstructorClass[]>{
    return this.http.get<FishingInstructorClass[]>(`${environment.baseUrl}/${environment.fishingInstructorClasses}/${environment.search}?searchInput=${searchInput}`);
  }
}
