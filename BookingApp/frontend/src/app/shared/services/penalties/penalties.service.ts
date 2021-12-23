import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Penalty } from '../../models/Penalty';

@Injectable({
  providedIn: 'root'
})
export class PenaltiesService {
  constructor(private http : HttpClient) { }
  getByClient(id : Number) : Observable<Penalty[]>{
    return this.http.get<Penalty[]>(`${environment.baseUrl}/${environment.penalties}/${environment.getByClient}?clientId=${id}`);
  }
}
