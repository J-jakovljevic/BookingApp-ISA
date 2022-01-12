import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router,NavigationEnd } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from './shared/services/authService/auth.service';
import { DataService } from './shared/services/data/data.service';
import { Observable }   from 'rxjs';
import { Store } from '@ngrx/store';


export interface AppState{
  role : String;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  role : Observable<String>;
  constructor(private router:Router,private authService : AuthService){}
  
  ngOnInit(): void {
    if(!this.authService.isLoggedIn()){
      localStorage.setItem('ROLE', '');
    }
    
  }
}
