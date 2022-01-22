import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoyaltyProgram } from '../../models/LoyaltyProgram';
import { LoyaltyProgramStatusDTO } from '../../models/LoyaltyProgramStatusDTO';

@Injectable({
  providedIn: 'root'
})
export class LoyaltyProgramService {

  constructor(private http : HttpClient) { }

  getLoyaltyProgram() : Observable<LoyaltyProgram>{
    return this.http.get<LoyaltyProgram>(`${environment.baseUrl}/${environment.loyaltyProgram}/${environment.get}`);
  }

  create(loyaltyProgram: LoyaltyProgram) : Observable<LoyaltyProgram>{
    return this.http.post<LoyaltyProgram>(`${environment.baseUrl}/${environment.loyaltyProgram}/${environment.create}`,loyaltyProgram);
  }

  update(loyaltyProgram: LoyaltyProgram) : Observable<LoyaltyProgram>{
    return this.http.post<LoyaltyProgram>(`${environment.baseUrl}/${environment.loyaltyProgram}/${environment.update}`,loyaltyProgram);
  }

  getStatusByClient(clientId : Number) : Observable<LoyaltyProgramStatusDTO>{
    return this.http.get<LoyaltyProgramStatusDTO>(`${environment.baseUrl}/${environment.loyaltyProgram}/${environment.getLoyaltyProgramStatusByClient}?clientId=${clientId}`);
  }
}
