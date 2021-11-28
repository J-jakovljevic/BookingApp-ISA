import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../../models/Client';
import { FishingInstructor } from '../../models/users/FishingInstructor';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http : HttpClient) { }

  registerClient(client : Client) : Observable<Response> {
    return this.http.post<Response>(`${environment.baseUrl}/${environment.clients}/${environment.register}`,client);
  }

  getAll() : Observable<Client[]>{
    return this.http.get<Client[]>(`${environment.baseUrl}/${environment.clients}/${environment.getAll}`);
  }

  getFishingInstructorById(id: Number) : Observable<FishingInstructor>{
    return this.http.get<FishingInstructor>(`${environment.baseUrl}/${environment.fishingInstructors}/${environment.getById}?id=${id}`);
  }
}
