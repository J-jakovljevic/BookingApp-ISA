import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../../models/Client';
import { LoginRequest } from '../../models/LoginRequest';
import { PasswordChanger } from '../../models/PasswordChanger';
import { User } from '../../models/users/User';
import { UserTokenState } from '../../models/users/UserTokenState';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    public currentUser: UserTokenState;
    isLogin = false;
    roleAs: any;

  constructor(private http : HttpClient, private router: Router) { }

  login(loginRequestData : LoginRequest) : Observable<UserTokenState>{
    return this.http.post<UserTokenState>(`${environment.baseUrl}/${environment.auth}/${environment.login}`, loginRequestData) 
    .pipe(map(res => {
      this.isLogin = true;
      this.roleAs = res.user.role;
      localStorage.setItem('STATE', 'true');
      localStorage.setItem('ROLE', this.roleAs);
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
  this.isLogin = false;
  this.roleAs = '';
  localStorage.setItem('STATE', 'false');
  localStorage.setItem('ROLE', '');
  this.router.navigate(['login']);
}

public activateClientProfile(token : String) : Observable<Client>{
  return this.http.put<Client>(`${environment.baseUrl}/${environment.clients}/${environment.activateProfile}?activationToken=${token}`,null);
}

isLoggedIn() {
  const loggedIn = localStorage.getItem('STATE');
  if (loggedIn == 'true')
    this.isLogin = true;
  else
    this.isLogin = false;
  return this.isLogin;
}

getRole() {
  this.roleAs = localStorage.getItem('ROLE');
  return this.roleAs;
}




}
