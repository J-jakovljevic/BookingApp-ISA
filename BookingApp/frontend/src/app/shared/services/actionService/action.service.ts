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
}
