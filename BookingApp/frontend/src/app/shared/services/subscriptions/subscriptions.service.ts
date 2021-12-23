import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Subscription } from '../../models/Subscription';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionsService {
  
  constructor(private http : HttpClient) { }
  
  getAllByClient(clientId : Number) : Observable<Subscription[]>{
    return this.http.get<Subscription[]>(`${environment.baseUrl}/${environment.subscriptions}/${environment.getByClient}?id=${clientId}`);
  }
  getById(id : Number) : Observable<Subscription>{
    return this.http.get<Subscription>(`${environment.baseUrl}/${environment.subscriptions}/${environment.getById}?id=${id}`);
  }
  unsubscribe(rentingItemId : Number) : Observable<Response>{
    return this.http.delete<Response>(`${environment.baseUrl}/${environment.subscriptions}/${environment.delete}?id=${rentingItemId}`);
 }
 subscribe(subscription : Subscription) : Observable<Subscription>{
  return this.http.post<Subscription>(`${environment.baseUrl}/${environment.subscriptions}/${environment.add}`,subscription);
}
}
