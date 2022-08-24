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
  message : String = "";
  

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
    this.authService.login(new LoginRequest(this.username,this.password)).subscribe(res => {
      this.dataService.sendClickEvent();
      console.log(res);
      if(res.user.role == Role.Client){
        this.store.dispatch({type:'CLIENT'});
        this.router.navigate(['clientReservations']);
      }
      if(res.user.role == Role.SystemAdmin){
        this.store.dispatch({type:'SYSTEMADMIN'});
        this.router.navigate(['systemAdminPage']);
      }
      if(res.user.role == Role.CottageOwner){
        this.store.dispatch({type:'COTTAGEOWNER'});
        this.router.navigate(['cottageOwnerProfile']);
      }
      if(res.user.role == Role.BoatOwner){
        this.store.dispatch({type:'BOATOWNER'});
        this.router.navigate(['boatOwnerProfile']);
      }
    },
    error=>{
      this.message = "Wrong username or password.";

    });
  }
  logOut(){
    this.authService.logout();
  }


  
  

}
