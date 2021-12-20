import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, ChangeDetectionStrategy, OnDestroy } from '@angular/core';
import { Router,NavigationEnd } from '@angular/router';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { AppState } from 'src/app/app.component';
import { AuthService } from '../../services/authService/auth.service';
import { DataService } from '../../services/data/data.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NavbarComponent implements OnInit  {
  role: String;
  constructor(private authService : AuthService,private dataService: DataService,
    private router: Router, private store : Store<AppState>) { }

  ngOnInit(): void {
    this.store.select('role').subscribe(role =>{
      this.role = role;
      console.log('rola u navbaru ' ,this.role );
    });
  }

  logOut(){
    this.authService.logout();
  }

}
