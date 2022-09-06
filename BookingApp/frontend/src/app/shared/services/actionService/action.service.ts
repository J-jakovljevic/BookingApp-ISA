import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Action } from '../../models/reservations/Action';

@Injectable({
  providedIn: 'root'
})
export class ActionService {

  constructor(private http : HttpClient) { }

  getActionsForClient(clientId : Number) : Observable<Action[]>{
    return this.http.get<Action[]>(`${environment.baseUrl}/${environment.actions}/${environment.getByClient}?clientId=${clientId}`);
  }

  getActionById(id : Number) : Observable<Action>{
    return this.http.get<Action>(`${environment.baseUrl}/${environment.actions}/${environment.getById}?id=${id}`);
  }

  getActionsForCottageOwner(ownerId: Number) : Observable<Action[]>{
    return this.http.get<Action[]>(`${environment.baseUrl}/${environment.actions}/${environment.getByCottageOwner}?ownerId=${ownerId}`);
  }

  getActionsForBoatOwner(ownerId: Number) : Observable<Action[]>{
    return this.http.get<Action[]>(`${environment.baseUrl}/${environment.actions}/${environment.getByBoatOwner}?ownerId=${ownerId}`);
  }

  newAction(action: Action) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.actions}/${environment.create}`,action);
  }

}
