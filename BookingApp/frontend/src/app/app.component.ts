import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from './shared/services/authService/auth.service';
import { DataService } from './shared/services/data/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy {
  notifierSubscription: Subscription = this.dataService.subjectNotifier.subscribe(notified => {
   this.ngOnInit();
  });
  constructor(private router:Router, private dataService : DataService,private authService : AuthService){}
  
  ngOnInit(): void {
    console.log('refresh app component');
    if(!this.authService.currentUser){
      this.router.navigate(['homepage']);
    }
    else if(this.authService.getCurrentUserRole() === 'Client'){
      this.router.navigate(['clientProfile']);
    }
    
  }
  ngOnDestroy() {
    this.notifierSubscription.unsubscribe();
  }

 
}

