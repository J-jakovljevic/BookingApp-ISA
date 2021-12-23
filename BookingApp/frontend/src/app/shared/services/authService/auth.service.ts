import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginRequest } from '../../models/LoginRequest';
import { PasswordChanger } from '../../models/PasswordChanger';
import { User } from '../../models/users/User';
import { UserTokenState } from '../../models/users/UserTokenState';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    public currentUser: UserTokenState;

  constructor(private http : HttpClient, private router: Router) { }

  login(loginRequestData : LoginRequest) : Observable<UserTokenState>{
    return this.http.post<UserTokenState>(`${environment.baseUrl}/${environment.auth}/${environment.login}`, loginRequestData) 
    .pipe(map(res => {
      this.currentUser = res;
      return res;
    }));
  }
changePassword(passwordChanger : PasswordChanger) : Observable<Response>{
  return this.http.post<Response>(`${environment.baseUrl}/${environment.auth}/${environment.changePassword}`, passwordChanger);
}
public getCurrentUser(): User {
  return this.currentUser.user;
}

public getCurrentUserRole(): string {
  return this.currentUser.user.role;
}
logout() {
  this.router.navigate(['login']);
}


}
