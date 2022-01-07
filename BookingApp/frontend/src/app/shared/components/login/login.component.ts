import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from 'src/app/app.component';
import { LoginRequest } from '../../models/LoginRequest';
import { Role } from '../../models/users/Role';
import { AuthService } from '../../services/authService/auth.service';
import { DataService } from '../../services/data/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent implements OnInit {
  username : String;
  password : String;
  role : String;
  

  constructor(private authService : AuthService, private router: Router,private dataService: DataService,
    private store : Store<AppState>,private activatedRoute : ActivatedRoute) { 
    }
    

  ngOnInit(): void {
      this.activatedRoute.queryParams.subscribe(params => {
        let token = params['token'];
        if(token != undefined) {
          this.authService.activateClientProfile(token).subscribe(
            res => {
              alert('Account successfully activated.');
            });
        }});
  }

  login() : void {
    console.log(this.password);
    this.authService.login(new LoginRequest(this.username,this.password)).subscribe(res => {
      this.dataService.sendClickEvent();
      if(res.user.role == Role.Client){
        this.store.dispatch({type:'CLIENT'});
        this.router.navigate(['clientReservations']);
      }
    });
  }
  logOut(){
    this.authService.logout();
  }


  
  

}
