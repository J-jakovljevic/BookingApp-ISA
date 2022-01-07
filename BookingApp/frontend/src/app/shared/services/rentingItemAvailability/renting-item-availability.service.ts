import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdditionalService } from '../../models/AdditionalService';
import { RentingItemAvailability } from '../../models/reservations/RentingItemAvailability';
import { RentingItemQuery } from '../../models/reservations/RentingItemQuery';

@Injectable({
  providedIn: 'root'
})
export class RentingItemAvailabilityService {

  constructor(private http: HttpClient) { }
  search(query:RentingItemQuery) : Observable<RentingItemAvailability[]>{
    return this.http.post<RentingItemAvailability[]>(`${environment.baseUrl}/${environment.rentingItemAvailabilities}/${environment.searchByParameters}`,query);
  }

  getAdditionalServicesByRentingItem(rentingItemId:Number) : Observable<AdditionalService[]>{
    return this.http.get<AdditionalService[]>(`${environment.baseUrl}/${environment.additionalServices}/${environment.getAllByRentingItem}?rentingItemId=${rentingItemId}`);
  }
}
