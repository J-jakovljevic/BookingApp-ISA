import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, ChangeDetectionStrategy, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from '../../services/authService/auth.service';
import { DataService } from '../../services/data/data.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NavbarComponent implements OnInit , OnDestroy {
  notifierSubscription: Subscription = this.dataService.subjectNotifier.subscribe(notified => {
    this.ngOnInit();
  });
  role: string;
  constructor(private authService : AuthService,private dataService: DataService,
    private router: Router) { }

  ngOnInit(): void {
    if(this.authService.currentUser){
      this.role = this.authService.getCurrentUserRole();
      console.log(this.authService.getCurrentUserRole());
    }
    else{
      this.role = 'unauthenticatedUser';
      console.log('usao kod unauth');
    }
  }

  ngOnDestroy() {
    this.notifierSubscription.unsubscribe();
  }

  logOut(){
    this.authService.logout();
  }

}
